package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test05 {
	
	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(8091);
		Socket s = ss.accept();
		InputStream in  = s.getInputStream();
		while(in.read() != -1) {
			System.out.println(in.read());
		}
	}
}
