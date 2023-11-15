import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String[] args) {
        try (DatagramSocket serverSocket = new DatagramSocket(9876)) {
            while (true) {
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from " + clientAddress + ":" + clientPort + ": " + clientMessage);

                // Read a response message from the server console
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter a response for the client: ");
                String serverResponse = br.readLine();
                byte[] sendData = serverResponse.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
