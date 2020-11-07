import java.io.*;
import java .util.*;
class queue
{
	int q[],f=0,r=0,size;
	void insert(int n)
	{
		Scanner in=new Scanner (System.in);
		q=new int[10];
		for(int i=0;i<n;i++)
		{
			System.out.print("\n enter "+i+"element:");
			int ele=in.nextInt();
			if(r+1>10)
			{
				System.out.println("queue is full\nlost packet:"+ele);
				break;
			}
			else
			{
				r++;
				q[i]=ele;
			}
		}
	}
	void delete()
	{
		Scanner in= new Scanner(System.in);
		Thread t =new Thread();
		if(r==0)
			System.out.println("queue empty");
		else
		{
			for(int i=f ;i<r;i++)
			{
				try
				{
					t.sleep(1000);
				}
				catch(Exception e) {}
				System.out.println("\n leaked packet:"+q[i]);
				f++;
			}
		}
		System.out.println();
	}
			
}
public class Licky  extends Thread
{
	public static void main(String args[])throws Exception
	{
		queue q =new queue();
		Scanner s=new Scanner(System.in);
		System.out.println("enter the packet to be sent");
		int size=s.nextInt();
		q.insert(size);
		q.delete();
		
	}
}
