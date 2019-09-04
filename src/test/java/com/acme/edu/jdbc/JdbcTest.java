package com.acme.edu.jdbc;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class JdbcTest {
    private final String dbUrl = "jdbc:derby:target/db";

    @Test
    public void shouldGetNoExceptionsWhenDbConnect() throws SQLException {
        try (final Connection connection = DriverManager.getConnection(dbUrl)) {
            //Remember to close any resources used
        }
    }

    @Test
    public void shouldDeleteRecordWhenSimpleQuery() throws SQLException {
        try (
                final Connection connection = DriverManager.getConnection(dbUrl);
                final Statement statement = connection.createStatement()
        ) {

            final int rowsAffected = statement.executeUpdate("delete from CLIENT where LOGIN = 'disabled@acme.com'");
            //NEVER do such SQL queries!
        }
    }

    @Test
    public void shouldInsertRecordWhenPreparedQuery() throws SQLException {
        try (
                final Connection connection = DriverManager.getConnection(dbUrl);
                final PreparedStatement statement = connection.prepareStatement(
                        "insert into CLIENT(LOGIN, SECRET, SALT) values(?,?,?)");
        ) {

            statement.setString(1, "login1");
            statement.setString(2, "secret1");
            statement.setString(3, "salt1");
            final int rowsAffected = statement.executeUpdate();
        }
    }

    @Test
    public void shouldHandleTheWholeChainOfExceptionsWhenAny() {
        try (
                final Connection connection = DriverManager.getConnection(dbUrl);
                final PreparedStatement statement = connection.prepareStatement(
                        "insert into CLIENT(LOGIN, SECRET, SALT) values(?,?,?)");
        ) {

            statement.setString(1, "login1");
            statement.setString(2, "secret2");
            statement.setString(3, "salt2");
            final int rowsAffected = statement.executeUpdate();

        } catch (SQLException e) {
            do {
                System.out.println(e.getMessage());
            } while ((e = e.getNextException()) != null);
        }
    }

    @Test
    public void shouldHandleTheWholeChainOfWarningsWhenAny() throws SQLException {
        try (
                final Connection connection = DriverManager.getConnection(dbUrl);
                final PreparedStatement statement = connection.prepareStatement(
                        "insert into CLIENT(LOGIN, SECRET, SALT) values(?,?,?)");
        ) {
            //Some unsupported feature
            connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);

            SQLWarning warning = connection.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
            }

            warning = statement.getWarnings();
            while (warning != null) {
                System.out.println(warning.getMessage());
                warning = warning.getNextWarning();
            }
        }
    }

    @Test
    public void shouldSelectRecordsWhenPreparedQuery() throws SQLException {
        try (
                final Connection connection = DriverManager.getConnection(dbUrl);
                final PreparedStatement statement = connection.prepareStatement(
                        "select * from CLIENT where ENABLED = ?");
        ) {

            statement.setBoolean(1, true);
            try (final ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    System.out.print(resultSet.getLong("ID") + ", ");
                    System.out.print(resultSet.getString("LOGIN") + ", ");
                    System.out.print(resultSet.getDate("CREATED") + ", ");
                    System.out.print(resultSet.getBoolean("ENABLED"));
                    System.out.println();
                }

            }
        }
    }

    @Test
    public void shouldIsolateTransactionsWhenSetLevel() throws InterruptedException, SQLException {
        try (
                final Connection connection = DriverManager.getConnection(dbUrl);
                final Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("update CLIENT set ENABLED = true");
        }

        final ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(this::updateTwoRecordsWithTransactionAndPauseBetween);
        pool.submit(this::printDisabledRecords);

        pool.shutdown();
        pool.awaitTermination(5, TimeUnit.SECONDS);
    }

    private void updateTwoRecordsWithTransactionAndPauseBetween() {
        try (final Connection connection = DriverManager.getConnection(dbUrl)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            connection.setAutoCommit(false);

            try (final Statement statement = connection.createStatement()) {
                statement.executeUpdate("update CLIENT set ENABLED = false where LOGIN = 'admin@acme.com'");
                Thread.sleep(5_000);
                statement.executeUpdate("update CLIENT set ENABLED = false where LOGIN = 'account@acme.com'");

                connection.commit();
            }

        } catch (SQLException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printDisabledRecords() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try (final Connection connection = DriverManager.getConnection(dbUrl)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
            connection.setAutoCommit(false);

            try (
                    final PreparedStatement statement = connection.prepareStatement("select * from CLIENT where ENABLED = false");
                    final ResultSet resultSet = statement.executeQuery();
            ) {

                while (resultSet.next()) {
                    System.out.print(resultSet.getLong("ID") + ", ");
                    System.out.print(resultSet.getString("LOGIN") + ", ");
                    System.out.print(resultSet.getDate("CREATED") + ", ");
                    System.out.print(resultSet.getBoolean("ENABLED"));
                    System.out.println();
                }
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test @Ignore
    public void extraFeatures() throws SQLException {
        try (final Connection connection = DriverManager.getConnection(dbUrl)) {
            connection.getMetaData();

            connection.prepareCall("");

            connection.setSavepoint();

            connection.createStatement().addBatch("");

            connection.createStatement().getGeneratedKeys();

            connection.createStatement().setFetchSize(1);

            connection.createStatement().executeQuery("").wasNull();
        }
    }
}