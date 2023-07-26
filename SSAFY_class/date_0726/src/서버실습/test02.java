package 서버실습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class test02 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9999);
		ArrayList<MyThread> client = new ArrayList<>();
		
		while(true) {
			System.out.println("wait...");
			Socket socket = serverSocket.accept();
			System.out.println("client connet!!");
			MyThread th = new MyThread(socket);
			th.start();
			client.add(th);
		}
		
	}
	
	static class MyThread extends Thread{
		Socket socket;
		MyThread(Socket s){
			socket = s;
		}
		
		@Override
		public void run() {
			try {
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while(true) {
					System.out.println(socket.getInetAddress());
					System.out.println("receive msg >> " + br.readLine());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}
	
}
