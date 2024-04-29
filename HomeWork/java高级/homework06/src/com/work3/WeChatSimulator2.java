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
 * 接收端
 */
public class WeChatSimulator2 {
    public static void main(String[] args) throws IOException {
        while (true) {
            DatagramSocket socket = new DatagramSocket(9999);//接收端端口
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);//接收包
            socket.receive(datagramPacket); //接收不到就阻塞 接收到存入packet
            int length = datagramPacket.getLength();//得到包中字节数
            byte[] data = datagramPacket.getData();//拆包得到字节数组 1024大小不一定用完
            String s = new String(data, 0, length);
            System.out.println(s);

            System.out.println("请输入发送信息");
            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            byte[] bytes1 = message.getBytes();
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes1, bytes1.length,
                    InetAddress.getByName(InetAddress.getLocalHost().getHostAddress()), 9998);
            socket.send(datagramPacket1);
            socket.close();
        }
    }
}

