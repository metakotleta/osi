import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 25.03.2022
 * \*  ----- group JAVA-27 -----
 * \* Description:
 * \
 */
public class Klient {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int port = 8080;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("GET / HTTP/1.1\ntru ly ly \n\n\n");
            String resp = in.readLine();
            System.out.println(resp);

        }

    }
}
