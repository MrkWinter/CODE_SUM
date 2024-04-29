package com.work04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author MrkWinter
 * @version 1.0
 */
public class Server implements Runnable {
    private Socket socket;

    public static void main(String[] args) throws Exception {
        startServer();
    }
    public Server(Socket socket) {
        this.socket = socket;
    }

    public static void startServer() throws Exception {
        ServerSocket serverSocket = new ServerSocket(10002);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new Server(socket)).start();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            line = bufferedReader.readLine(); //接收标记
            System.out.println(line);
            //反转字符串
            StringBuffer reverse = new StringBuffer(line).reverse();
            line = reverse.toString();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write(line);
            bufferedWriter.newLine(); //设置写入结束标记
            bufferedWriter.flush();
            //关流要在最后
            bufferedWriter.close();
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
