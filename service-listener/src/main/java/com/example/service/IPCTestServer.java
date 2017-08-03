package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class IPCTestServer {

    static ServerSocket serverSocket = null;
    static String message;
    static BufferedReader is;
    static PrintStream os;
    static Socket socket = null;
    static int port = 9999;

    public static String listen() {
        try {
            socket = serverSocket.accept();
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new PrintStream(socket.getOutputStream());
            while (true) {
                message = is.readLine();
                os.println(message);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return message;
    }

    public static void getSocket() {
        try {
            System.out.println("Attempting to open server socket on port: " + port);
            serverSocket = new ServerSocket(port);
            System.out.println("Connection made");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void main(String args[]) {
        getSocket();
        listen();
    }
}
