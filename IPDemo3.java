import java.net.*;
import java.util.Scanner;

public class IPDemo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Host Name or IP address: ");
        String userInput = input.nextLine();

        try {
            InetAddress address = InetAddress.getByName(userInput);
            System.out.println("IP address: " + address.getHostAddress());
            System.out.println("Host name: " + address.getHostName());
	    System.out.println("Host name and IP address: " + address.toString());
        } catch (UnknownHostException ex) {
            System.out.println("Could not find " + userInput);
        }
    }
}


