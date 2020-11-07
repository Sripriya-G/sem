import java .util.Scanner;
public class BellmanFord {
	private int d[];
	private int num_ver;
	public static final int MAX_VALUE=999;
	public BellmanFord(int num_ver)
	{
		this.num_ver=num_ver;
		d=new int[num_ver+1];
	}
	
	public void BellmanFordEvaluation(int source,int a[][])
	{
		for(int node=1;node<=num_ver;node++)
		{
			d[node]=MAX_VALUE;
		}
		d[source]=0;
		for(int node=1;node<=num_ver-1;node++)
		{
			for(int sn=1;sn<=num_ver;sn++)
			{
				for(int dn=1;dn<=num_ver;dn++)
				{
					if(a[sn][dn]!=MAX_VALUE)
					{
						if(d[dn]>d[sn]+a[sn][dn])
							d[dn]=d[sn]+a[sn][dn];
						
					}
				}
			}
		}
		
		for(int sn=1;sn<=num_ver;sn++)
		{
			for(int dn=1;dn<=num_ver;dn++)
			{
				if(a[sn][dn]!=MAX_VALUE)
				{
					if(d[dn]>d[sn]+a[sn][dn])
						System.out.println("a graph contains a negative edge cycle");
					
						
				}
			}
		}
		for(int vertex=1;vertex<=num_ver;vertex++)
		{
			System.out.println("distance of source" +source+  "to"  +vertex+ "is" +d[vertex]);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int num_ver=0,source;
			Scanner sc= new Scanner(System.in);
			System.out.println("enter the number of vertices");
			num_ver=sc.nextInt();
			int a[][]=new int[num_ver+1][num_ver+1];
			System.out.println("enter the adjacency matrix");
			for(int sn=1;sn<=num_ver;sn++)
			{
				for(int dn=1;dn<=num_ver;dn++)
				{
					a[sn][dn]=sc.nextInt();
					if(sn==dn)
					{
						a[sn][dn]=0;
						
					}
					if(a[sn][dn]==0)
					{
						a[sn][dn]=MAX_VALUE;
					}
				}
			}
			System.out.println("enter the source vertex");
			source=sc.nextInt();
			BellmanFord b=new BellmanFord(num_ver);
			b.BellmanFordEvaluation(source,a);
			sc.close();
	}

}
