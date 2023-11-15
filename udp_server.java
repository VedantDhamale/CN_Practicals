import java.io.*;
import java.net.*;

public class udp_server {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876); // Create a UDP server socket

            byte[] receiveData = new byte[1024];

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket); // Receive a packet from the client

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                System.out.println("Received from " + clientAddress + ":" + clientPort + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}