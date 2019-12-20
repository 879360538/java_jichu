package biancheng;

import java.net.*;

public class E02 {

	public static void main(String[] args) throws Exception{
		DatagramSocket client=new DatagramSocket(3000);
		String str="cpdd.你是唯一全网无前任，有也不承认，你的寂寞，我来承担";
		byte[]hcqsz=str.getBytes("UTF-8");
		DatagramPacket packet=new DatagramPacket(hcqsz,hcqsz.length,InetAddress.getByName("10.2.103.30"),8900);
		System.out.println("开始发送信息...");
		client.send(packet);
		client.close();

	}

}
