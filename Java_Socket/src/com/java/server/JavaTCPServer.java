package com.java.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class JavaTCPServer {
	 public static void main (String[] args) throws Exception{
	        // Create a server socket with port number 6666
	        ServerSocket serverSocket = new ServerSocket(6666);
	        while (true){
	            Socket socket = serverSocket.accept();
	            DataInputStream inputStream = new DataInputStream (socket.getInputStream());
	            System.out.println(inputStream.readUTF());
	            inputStream.close();
	            System.out.println("Client Connected");
	            socket.close();
	        }
	    }
}
