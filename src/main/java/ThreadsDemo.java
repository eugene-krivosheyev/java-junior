import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class ThreadDemo {
    public static void main(String[] args) {
        try(ServerSocket ss = new ServerSocket(9999)) {
            final Collection<Socket> sockets = new LinkedList<>();

            //Lock lock = ReentrantReadWriteLock();

            while (true) {
                Socket s = ss.accept();
                synchronized (sockets) {
                    sockets.add(s);
                }
                new Thread(() -> {
                    try(
                        DataInputStream is =
                                new DataInputStream(s.getInputStream());
                        DataOutputStream os =
                                new DataOutputStream(s.getOutputStream());
                    ) {

                        while (true) {
                            os.writeUTF(">>> " + is.readUTF());
                        }

                    } catch (IOException e) {
                        synchronized (sockets) {
                            sockets.remove(s);
                        }
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}