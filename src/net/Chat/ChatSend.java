package net.Chat;
import java.net.*;
import java.util.Scanner;

import com.mysql.fabric.xmlrpc.base.Data;

public class ChatSend implements Runnable {
	private DatagramSocket client;
	private int targetPort;
	public ChatSend(DatagramSocket client,int targetPort) {
		this.client=client;
		this.targetPort=targetPort;
	}
	public void run() {
		try {
			Scanner scanner=new Scanner(System.in);
			while(true) {
				String data=scanner.nextLine();
				byte[]buf=data.getBytes();
				DatagramPacket packet=new DatagramPacket(buf,buf.length,InetAddress.getByName("10.2.103.233"),targetPort);
				client.send(packet);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
