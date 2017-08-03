package com.example.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.util.Map;

public class IPCTestClient {

    public static void main(String[] args) throws InterruptedException {

        Socket socket = null;
        DataOutputStream os = null;
        BufferedReader is = null;
        int port = 9999;

        Map<String, String> env = System.getenv();
        String hostName = env.get("HOSTNAME");

        try {
            System.out.println("Attempting to connect with host: " + hostName + "on port: " + port);
            socket = new Socket(hostName, port);
            os = new DataOutputStream(socket.getOutputStream());
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println("Connection Made");

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: " + e);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: " + e);
        }

        while (socket != null && os != null && is != null) {
            try {
                LocalDateTime localTime = LocalDateTime.now();
                os.writeBytes("Client Local Time is : " + localTime + " \n");

                String responseLine;
                while ((responseLine = is.readLine()) != null) {
                    System.out.println("Server: " + responseLine);
                    break;
                }
                Thread.sleep(1000);

            } catch (UnknownHostException e) {
                System.err.println("Trying to connect to unknown host: " + e);
                break;
            } catch (IOException e) {
                System.err.println("IOException:  " + e);
                break;
            }
        }
    }

}