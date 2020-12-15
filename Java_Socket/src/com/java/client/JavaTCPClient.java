package com.java.client;

import java.io.*;
import java.net.Socket;

public class JavaTCPClient {
    public static void main (String[] args) throws Exception{
        // Create a client socket with local IP address and port number
        Socket socket = new Socket("127.0.0.1",8888);
        OutputStream outputStream= socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("Hello Server");
        dataOutputStream.flush();
        dataOutputStream.close();
    }
}
