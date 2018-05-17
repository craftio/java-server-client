import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        BufferedReader userIn = new BufferedReader(
                new InputStreamReader(System.in)
        );

        for(;;) {
            DatagramSocket socket = new DatagramSocket();

            byte[] dataIn = new byte[1024];
            byte[] dataOut = new byte[1024];

            InetAddress IP = InetAddress.getByName("145.49.47.29");
            dataOut = userIn.readLine().getBytes();


            DatagramPacket sendPacket = new DatagramPacket(dataOut, dataOut.length, IP, 666);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(dataIn, dataIn.length);
            socket.receive(receivePacket);

            String str = new String(receivePacket.getData(), "UTF-8");
            System.out.println(str);
        }
    }
}
