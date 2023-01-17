package com.cross_cutting.Server.Testing;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    private InputStream is = null;
    private OutputStream os = null;
    private Socket client;

    public void connectSocketServer(int port) {
        try {
            ServerSocket server = new ServerSocket(port);
            client = server.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            is = client.getInputStream();
            os = client.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void clientStop() {
        try {
            client.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(File f, String flag) {

        try {
            PrintWriter printWriter = new PrintWriter(os, true);
            printWriter.println(f.getName());
            printWriter.println(flag);
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] b = new byte[1];

        try {
            System.out.println("hui");
            OutputStream dout = new DataOutputStream(new BufferedOutputStream(os));
            InputStream ins = new FileInputStream(f);
            int n = ins.read(b);

            while (n != -1) {// Запись данных в сеть
                dout.write(b); // Отправить содержимое файла
                dout.flush(); // снова прочитать n байтов
                n = ins.read(b);
            }

            ins.close();
            dout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFile() {
        byte[] b=new byte[1024];

        try {// Определим входной поток,
            InputStream in = is;
            DataInputStream din = new DataInputStream (new BufferedInputStream(in)); // Создать файл для сохранения
            String filename = din.readLine();
            File f = new File(filename);
            RandomAccessFile fw = new RandomAccessFile(f, "rw");

            int num = din.read(b);
            while (num != -1) {// Записать 0 ~ num байтов в файл
                System.out.println("hui");
                fw.write(b, 0, num); // Пропустить num байтов и снова записать в файл
                fw.skipBytes(num); // Чтение num байтов
                num = din.read(b);
            } // Закрыть входной и выходной потоки
            din.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
