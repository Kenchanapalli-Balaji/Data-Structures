package Non_Linear;

public class Adjacency_Matrix 
{
	int ar[][]=new int[4][4];
	public void addEdge(int u,int v)
	{
		ar[u][v]=1;
		ar[v][u]=1;
	}
	public void display()
	{
		for(int i=0;i<ar.length;i++)
		{
			System.out.print(i+" : ");
			for(int j=0;j<ar[i].length;j++)
			{
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		Adjacency_Matrix o=new Adjacency_Matrix();
		o.addEdge(0, 1);
		o.addEdge(1, 2);
		o.addEdge( 2, 3);
		o.addEdge(3, 0);
		o.display();
	}
}
