package 서버실습;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest {

	public static void main(String[] args) throws IOException {
		Socket socket = new Socket(InetAddress.getByName("192.168.130.40"), 9999);
		Scanner sc = new Scanner(System.in);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		while(true){
			System.out.println("input >> ");
			String line = sc.nextLine();
		}
	}
}
