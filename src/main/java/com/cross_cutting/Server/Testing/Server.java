package com.cross_cutting.Server.Testing;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private Socket s;

    OutputStream os;
    InputStream is;

    private String flag;
    private String filename;


    public void connectSocketServer(int port) {

        try {
            ServerSocket server = new ServerSocket(port);
            s = server.accept();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            is = s.getInputStream();
            os = s.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initServer(int port){

        while (s == null) {

            try {
                s = new Socket(InetAddress.getLocalHost(), port);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }

        try {

            os = s.getOutputStream();
            is = s.getInputStream();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void serverStop(){

        try {
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String getFile() {

        byte[] b=new byte[1024];

        try {
            InputStream in = is;
            DataInputStream din = new DataInputStream (new BufferedInputStream(in)); // Создать файл для сохранения
            filename = din.readLine();
            flag = din.readLine();

            File f = new File(filename);

            RandomAccessFile fw = new RandomAccessFile(f, "rw");

            int num = din.read(b);

            while (num != -1) {
                System.out.println("hui");
                fw.write(b, 0, num);
                fw.skipBytes(num);
                num = din.read(b);
            }

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

        try {
            OutputStream dout = new DataOutputStream(new BufferedOutputStream(s.getOutputStream ())); // Поток чтения файла
            InputStream ins = new FileInputStream(f);
            int n = ins.read(b);

            while (n != -1) {
                dout.write (b);
                dout.flush ();
                n = ins.read(b);
            }

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
    }

    public static void main(String[] args) {
        while(true) {
            Server serverget = new Server();
            serverget.initServer(7890);
            System.out.println("Please wait");
            String getf = serverget.getFile();
            File f1 = new File(getf);
            f1.deleteOnExit();

            System.out.println("Done!");
            serverget.serverStop();

            Server serversend = new Server();
            serversend.initServer(7891);
            serversend.sendFile("src/res/ArchiveAndEncrypt/test.txt");
            File f2 = new File("src/res/ArchiveAndEncrypt/test.txt");
//            f2.deleteOnExit();
            serversend.serverStop();
        }

    }

}