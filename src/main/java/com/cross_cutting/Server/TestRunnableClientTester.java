package com.cross_cutting.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class TestRunnableClientTester implements Runnable {

    static Socket socket;

    public TestRunnableClientTester() {

        try {
            // создаём сокет общения на стороне клиента в конструкторе объекта
            socket = new Socket("localhost", 3345);
            System.out.println("Client connected to socket");
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {

        try (DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
             DataInputStream ois = new DataInputStream(socket.getInputStream())) {

            System.out.println("Client oos & ois initialized");

            int i = 0;

            while (i < 5) {

                oos.writeUTF("clientCommand " + i);
                oos.flush();
                Thread.sleep(10);
                System.out.println("Client wrote & start waiting for data from server...");
                System.out.println("reading...");
                String in = ois.readUTF();
                System.out.println(in);
                i++;
                Thread.sleep(500);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
