import java.net.*;
import java.io.*;

public class UDPClient {
    public static void main(String[] args) {
        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverAddress = InetAddress.getByName("localhost");
            int serverPort = 9876;

            while (true) {
                // Read a message from the client console
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Enter a message for the server: ");
                String clientMessage = br.readLine();
                byte[] sendData = clientMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, serverPort);
                clientSocket.send(sendPacket);

                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from server: " + serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
