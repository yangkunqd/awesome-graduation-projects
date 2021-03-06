package zhanlang.service.operate;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import zhanlang.entity.Person;

public class ServerListen implements Runnable{
	ServerSocket socket;
	public static List<Person> list=new ArrayList<Person>();
	/**
	 * 监听到一个socket,就创建一个新线程，用来处理一个新用户
	 */
	@Override
	public void run() {
		try {
			//服务器接口
			socket=new ServerSocket(8888);
			System.out.println(Thread.currentThread().getName()+"处理新用户线程，启动成功！正在监听中>>>>>");
			while(true){
				//监听接口，有接入往下执行，没接入阻塞
				Socket s = socket.accept();
				System.out.println("---连接到一个新用户");
				//每个用户处理数据线程
				ListenThread e = new ListenThread(s);
				Thread t = new Thread(e);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		
	}
}
