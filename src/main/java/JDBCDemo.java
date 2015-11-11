import java.sql.*;

class JDBCDemo {
    public static void main(String[] args) {
        Connection c = null;
        try {
            c = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/myDB;create=true"
            );

            c.setAutoCommit(false);
            c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);

            PreparedStatement iq =
                    c.prepareStatement("INSERT INTO demo(ID, NAME) VALUES(?, ?)");
            iq.setInt(1, 9);
            iq.setString(2, "aaaa");
            iq.executeUpdate();

            PreparedStatement sq =
                    c.prepareStatement("SELECT ID,NAME FROM demo WHERE id > ?");
            sq.setInt(1, 5);
            ResultSet resultSet = sq.executeQuery();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("ID") + " > ");
                System.out.println(resultSet.getString("NAME"));
            }

            c.commit();

        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            if (c != null) try {
                c.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}















