package cross_cutting.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MonoThreadClientHandler implements Runnable {

    private static Socket clientDialog;

    public MonoThreadClientHandler(Socket client) {
        MonoThreadClientHandler.clientDialog = client;
    }

    @Override
    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(clientDialog.getOutputStream());

            DataInputStream in = new DataInputStream(clientDialog.getInputStream());
            System.out.println("DataInputStream created");
            System.out.println("DataOutputStream  created");

            while (!clientDialog.isClosed()) {
                System.out.println("Server reading from channel");
                String entry = in.readUTF();
                System.out.println("READ from clientDialog message - " + entry);

                if (entry.equalsIgnoreCase("quit")) {

                    System.out.println("Client initialize connections suicide ...");
                    out.writeUTF("Server reply - " + entry + " - OK");
                    Thread.sleep(1000);
                    break;
                }

                System.out.println("Server try writing to channel");
                out.writeUTF("Server reply - " + entry + " - OK");
                System.out.println("Server Wrote message to clientDialog.");

                out.flush();

            }

            System.out.println("Client disconnected");
            System.out.println("Closing connections & channels.");

            in.close();
            out.close();

            clientDialog.close();

            System.out.println("Closing connections & channels - DONE.");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     /*public void initServer(int port){
        while (s == null) {
            try {
                s = new Socket(InetAddress.getLocalHost(), port); // Подключиться к серверу
            } catch (IOException e) {
                //e.printStackTrace();
            }
        }

        try {
            os = s.getOutputStream();
            is = s.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    } // чтение файла из SocketClient

    public void serverStop(){
        try {
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public String getFile() {
        byte[] b=new byte[1024];
        try {// Определим входной поток,
            InputStream in = is;
            DataInputStream din = new DataInputStream (new BufferedInputStream(in)); // Создать файл для сохранения
            filename = din.readLine();
            flag = din.readLine();
            File f = new File(filename);
            RandomAccessFile fw = new RandomAccessFile(f, "rw");

            int num = din.read(b);
            while (num != -1) {// Записать 0 ~ num байтов в файл
                fw.write(b, 0, num); // Пропустить num байтов и снова записать в файл
                fw.skipBytes(num); // Чтение num байтов
                num = din.read(b);
            } // Закрыть входной и выходной потоки
            din.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filename;
    }

    public void sendFile(String filename) {

        try {
            PrintWriter printWriter = new PrintWriter(os, true);
            printWriter.println(filename);
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] b = new byte[1];
        File f = new File(filename);
        try {// Поток вывода данных
            OutputStream dout = new DataOutputStream(new BufferedOutputStream(s.getOutputStream ())); // Поток чтения файла
            InputStream ins = new FileInputStream(f);
            int n = ins.read(b);
            while (n != -1) {// Запись данных в сеть
                dout.write (b); // Отправить содержимое файла
                dout.flush (); // снова прочитать n байтов
                n = ins.read(b);
            } // Закрыть поток
            ins.close();
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void create(String filename){
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void delete(String filename){
        File file = new File(filename);
        if(file.delete())
        {
            System.out.println("File deleted successfully");
        }
        else
        {
            System.out.println("Failed to delete the file");
        }
    }*/
}