import java.io.*;
import java.net.*;
public class Udpclient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket skt;
		try 
		{
			skt=new DatagramSocket();
			String msg="sri";
			byte[] b=msg.getBytes();
			InetAddress host=InetAddress.getLocalHost();
			int serverSocket=6788;
			DatagramPacket request=new DatagramPacket(b,b.length,host,serverSocket);
			skt.send(request);
			
			
			
			
			byte[] buffer =new byte[1000];
			DatagramPacket reply=new DatagramPacket(buffer,buffer.length);
			skt.receive(reply);
			
			
			System.out.println("client received:"+new String(reply.getData()));
			skt.close();
			
			System.out.println("got client:"+new String(reply.getData()));
		}catch(Exception e) {}
	}

}
