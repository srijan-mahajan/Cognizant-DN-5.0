import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args)
            throws Exception {

        Socket socket =
                new Socket("localhost", 5000);

        BufferedReader br =
                new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream()
                        )
                );

        PrintWriter pw =
                new PrintWriter(
                        socket.getOutputStream(),
                        true
                );

        System.out.println(
                br.readLine()
        );

        pw.println("Hello Server");

        socket.close();
    }
}