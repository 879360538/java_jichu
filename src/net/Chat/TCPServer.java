package net.Chat;

import java.io.*;
import java.net.*;


public class TCPServer {

	public static  void main(String[] args) throws Exception {
		ServerSocket serverSocket=new ServerSocket(8899);
		while(true) {
			Socket client=serverSocket.accept();
			Thread thread=new Thread(()->{
				try {
					int port=client.getPort();
					System.out.println("与端口号为"+port+"的客户端连接成功!");
					OutputStream os=client.getOutputStream();
					os.write(("服务器端向客户端做出响应！").getBytes());
					Thread.sleep(5000);
					System.out.println("结束与客户端数据交互");
					os.close();
					client.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}); 
			thread.start();
			
		}

	}

}
