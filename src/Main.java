import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * \* Created with IntelliJ IDEA.
 * \* Author: Prekrasnov Sergei
 * \* Date: 25.03.2022
 * \*  ----- group JAVA-27 -----
 * \* Description: Домашнее задание к занятию 3.1 Основы работы с сетью. Модель OSI
 * \    Задача "Клиент-серверное приложение"
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        synchronized(this) {
            Socket clientSocket = serverSocket.accept(); // ждем подключения
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        }
        System.out.println("New connection accepted");

        final String name = in.readLine();

        out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
    }
}
