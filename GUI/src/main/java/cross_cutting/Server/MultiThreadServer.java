package cross_cutting.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadServer {

    static ExecutorService executeIt = Executors.newFixedThreadPool(2);

    OutputStream os;
    InputStream is;


    /**
     * @param args
     */
    public static void main(String[] args) {

        try (ServerSocket server = new ServerSocket(3345);
             BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Server socket created, command console reader for listen to server commands");

            while (!server.isClosed()) {

                if (br.ready()) {
                    System.out.println("Main Server found any messages in channel, let's look at them.");
                    String serverCommand = br.readLine();
                    if (serverCommand.equalsIgnoreCase("quit")) {
                        System.out.println("Main Server initiate exiting...");
                        server.close();
                        break;
                    }
                }

                Socket client = server.accept();
                executeIt.execute(new MonoThreadClientHandler(client));
                System.out.print("Connection accepted.");
            }

            executeIt.shutdown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
