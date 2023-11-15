import java.io.*;
import java.net.*;

public class udp_client {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();

            String message = "Hello, UDP Server!";
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            byte[] sendData = message.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
            clientSocket.send(sendPacket); // Send a packet to the server

            System.out.println("Sent to server: " + message);

            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}