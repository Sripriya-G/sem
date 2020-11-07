package exam;
import java.io.*;
import java.util.*;
class queue
{
	int q[],r=0,f=0;
	void insert(int n)
	{
		Scanner sc=new Scanner(System.in);
		q=new int[10];
		System.out.println("enter the elements");
		for(int i=0;i<n;i++)
		{
			System.out.println("enter " +i+ "element");
			int ele=sc.nextInt();
			if(r+1>10)
			{
				System.out.println("queue is full\n Lost packet :"+ele);
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
		Scanner sc=new Scanner(System.in);
		Thread t=new Thread();
		if(r==0)
			System.out.println("queue is empty");
		else
		{
			for (int i=f;i<r;i++)
			{
				try {
					t.sleep(1000);
				}
				catch(Exception e) {}
				System.out.println("Leaked packet"+q[i]);
				f++;
	
				
			}
		}
	}
}
	

public class Prg {

	public static void main(String[] args)  throws Exception
	{
		// TODO Auto-generated method stub
		queue q =new queue();
		Scanner in= new Scanner(System.in);
		int size;
		System.out.println("enter the size");
		size= in.nextInt();
		q.insert(size);
		q.delete();
		
	}

}
