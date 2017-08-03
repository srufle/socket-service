package com.example.service;

import java.io.*;
import java.net.*;
import java.time.LocalDateTime;
import java.util.Map;

public class EchoClient {

    public static void main(String[] args) throws InterruptedException, UnknownHostException {

        Socket socket = null;
        DataOutputStream os = null;
        BufferedReader is = null;

        Map<String, String> env = System.getenv();
        int port = Integer.parseInt(env.get("PORT"));
        String outIp = env.get("IP");

        String hostName = "localhost";
        InetAddress inetAddress = null;
        if (outIp !=null) {
            inetAddress = InetAddress.getByName(outIp);
        }

        try {

            System.out.println(String.format("Attempting to connect with ip = '%s' on port: '%s'", inetAddress.toString(), hostName, port));
            if (inetAddress != null) {
                socket = new Socket(inetAddress, port);
            }
            if (socket != null) {
                os = new DataOutputStream(socket.getOutputStream());
                is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println("Socket open");
                System.out.println("Ip Address: " + inetAddress.toString());
            }

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
