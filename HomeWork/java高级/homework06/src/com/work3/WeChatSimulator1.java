package com.work3;

/**
 * @author MrkWinter
 * @version 1.0
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * 发送端
 */
public class WeChatSimulator1 {
    public static void main(String[] args) throws IOException {
        while (true) {
            DatagramSocket socket = new DatagramSocket(9998);
            System.out.println("请输入发送信息");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            byte[] bytes = message.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
                    InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()), 9999);
            socket.send(datagramPacket);

            byte[] bytes1 = new byte[1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length);
            socket.receive(datagramPacket1);
            int length = datagramPacket1.getLength();
            byte[] data = datagramPacket1.getData();
            String s = new String(data,0,length);
            System.out.println(s);
            socket.close();
        }

    }
}

