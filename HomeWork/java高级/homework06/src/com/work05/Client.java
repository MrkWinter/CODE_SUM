package com.work05;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Client {
    public static void main(String[] args) {
        startClient();
    }

    public static void startClient() {
        try {
            Socket socket = null;
            while (true) {
                socket = new Socket(InetAddress.getLocalHost(), 10002);
                OutputStream outputStream = socket.getOutputStream();
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                FileInputStream fileInputStream = new FileInputStream(message);

                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

                byte[] bytes = new byte[1024];

                int read = 0;
                while ((read = fileInputStream.read(bytes)) != -1) {
                    bufferedOutputStream.write(bytes, 0, read);
                }
                bufferedOutputStream.flush();
//                socket.shutdownOutput(); //输出结束标记
//
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//                String line = bufferedReader.readLine();
//                System.out.println(line); //接收标记
//
//                bufferedInputStream.close();
//                bufferedOutputStream.close();
//                bufferedReader.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
