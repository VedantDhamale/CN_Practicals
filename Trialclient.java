import java.io.*;
import java.net.*;

public class Trialclient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 12345);
        OutputStream out = socket.getOutputStream();
        FileInputStream in = new FileInputStream("sample.txt");
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }
	System.out.println("Transfered Successfully");
        in.close();
        out.close();
        socket.close();
    }
}
