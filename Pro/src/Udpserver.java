import java.io.*;
import java.net.*;
public class Udpserver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DatagramSocket skt=null;
		try
		{
			skt=new DatagramSocket(6788);
			byte[] buffer =new byte[1000];
			while(true)
			{
				DatagramPacket request=new DatagramPacket(buffer,buffer.length);
				skt.receive(request);
				String[] message =(new String(request.getData())).split("");
				
				/*instead of line 16
				 * String str=new String(request.getData());
				int num=Integer.parseInt(str);*/
				byte[] sendmsg =(message [1] +"server processed").getBytes();
			
				InetAddress host=InetAddress.getLocalHost();
				DatagramPacket reply =new DatagramPacket(sendmsg,sendmsg.length,host,request.getPort());

				skt.send(reply);
				
			}
		}catch(Exception e) {}
	}

}
