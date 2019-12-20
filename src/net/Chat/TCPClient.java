package net.Chat;

import java.awt.im.InputContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws Exception {
		Socket client=new Socket("10.2.103.31",8899);
		File wj=new File("d:\\1.jpg");
		FileInputStream fin=new FileInputStream(wj);
		OutputStream os;
		os=client.getOutputStream();
		byte[]buf=new byte[1024];
		int len=fin.read(buf);
		while(len!=-1) {
			os.write(buf,0,len);
			len=fin.read(buf);
		}
		client.shutdownOutput();
		
		
		InputStream is=client.getInputStream();
		buf=new byte[1024];
		len=is.read(buf);
		while(len!=-1) {
			System.out.println(new String(buf,0,len));
			len=is.read();
		}
		is.close();
		client.close();
	}

}
