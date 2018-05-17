package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    private static final int PORT = 666;

    public static void main(String[] args) {
        try {
            InetAddress ip = InetAddress.getByName("255.255.255.255");
            String dataString = "Hoi";
            byte[] b = dataString.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(
                    b, b.length, ip, PORT
            );
            DatagramSocket clientSocket = new DatagramSocket();
            clientSocket.send(datagramPacket);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
