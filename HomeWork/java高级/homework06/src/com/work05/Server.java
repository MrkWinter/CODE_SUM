package com.work05;

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
            BufferedInputStream bufferedInputStream = new BufferedInputStream(socket.getInputStream());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("a.txt"));
            byte[] bytes = new byte[1024];
            int i = 0;
            while((i = bufferedInputStream.read(bytes))!=-1) {
                bufferedOutputStream.write(bytes, 0,i);
            }
            bufferedOutputStream.flush();
//            socket.shutdownInput();//接收结束标记
//
//            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            bufferedWriter.write("接收写入成功");
//            bufferedWriter.newLine();//输出结束标记
//            bufferedWriter.flush();
//
//            bufferedInputStream.close();
//            bufferedOutputStream.close();
//            bufferedWriter.close();
//            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
