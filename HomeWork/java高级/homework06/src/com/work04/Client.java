package com.work04;

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
            BufferedWriter bufferedWriter = null;
            BufferedReader bufferedReader = null;
            while (true) {
                socket = new Socket(InetAddress.getLocalHost(), 10002);
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                Scanner scanner = new Scanner(System.in);
                String message = scanner.nextLine();
                bufferedWriter.write(message);
                bufferedWriter.newLine(); //设置写入结束标记
                bufferedWriter.flush();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String line;
                line = bufferedReader.readLine(); //使用readline读取 配合newline写入结束标记使用
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
