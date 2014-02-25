package com.cloud.simple;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import javax.servlet.ServletException;

public class HttpServer {
	private static final String SHUT_DOWN_COMMAND = "/shutdown";
	private boolean shutdown = false;
	
	public void doService() throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException{
		try {
			ServerSocket serverSocket = new ServerSocket(8888,50,InetAddress.getByName("localhost"));
			Socket socket = null;
			InputStream input = null;
			OutputStream output = null;			
			while(!shutdown){
				socket = serverSocket.accept();
				input = socket.getInputStream();
				output = socket.getOutputStream();
				Request request = new Request(input);
				Response response = new Response(output);
				String uri = request.getURI();
				System.out.println(uri);
				ServletProcessor sp = new ServletProcessor();
				sp.process(request, response);				
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, ServletException{
		HttpServer httpServer = new HttpServer();
		httpServer.doService();
	}

}