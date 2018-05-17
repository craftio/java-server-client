package net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    private static final int PORT = 666;

    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(PORT);

            byte[] buffer = new byte[256];

            DatagramPacket request = new DatagramPacket(buffer, buffer.length);
            socket.receive(request);

            byte[] bytes = request.getData();
            String resolt = new String(bytes, "UTF-8");
            System.out.println(resolt);

            InetAddress clientAddress = request.getAddress();
            int clientPort = request.getPort();

            String data = "Message from server";
            buffer = data.getBytes();

            DatagramPacket response = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
            socket.send(response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
