package com.example.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;

public class EchoServer {

    public static void main(String[] args) throws Exception {

        // create socket
        Map<String, String> env = System.getenv();
        int port = Integer.parseInt(env.get("PORT"));

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.err.println("Started server on port " + port);

            // repeatedly wait for connections, and process
            while (true) {

                // a "blocking" call which waits until a connection is requested
                Socket clientSocket = serverSocket.accept();
                System.err.println("Accepted connection from client");

                // open up IO streams
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // waits for data and reads it in until connection dies
                // readLine() blocks until the server receives a new line from
                // client
                String s;
                while ((s = in.readLine()) != null) {
                    out.println(s);
                }

                // close IO streams, then socket
                System.err.println("Closing connection with client");
                out.close();
                in.close();
                clientSocket.close();
            }

        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}
