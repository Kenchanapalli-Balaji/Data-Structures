package Non_Linear;

import java.util.LinkedList;
import java.util.Queue;

public class Breadth_First_Search
{
	LinkedList<Integer> adj[];
	Breadth_First_Search(int nodes)
	{
		this.adj=new LinkedList[nodes];
		for(int i=0;i<adj.length;i++)
		{
			this.adj[i]=new LinkedList<>();
		}
	}
	public void addEdge(int u,int v)
	{
		adj[u].add(v);
		adj[v].add(u);
	}
	public void display()
	{
		for(int i=0;i<adj.length;i++)
		{
			System.out.println(i+" : "+adj[i]);
		}
	}
	
	public void bfs(int s)
	{
		boolean visited[]=new boolean[adj.length];
		Queue<Integer> q=new LinkedList<>();
		visited[s]=true;
		q.offer(s);
		while(!q.isEmpty())
		{
			int u=q.poll();
			System.out.print(u+" ");
			for(int i:adj[u])
			{
				if(!visited[i])
				{
					visited[i]=true;
					q.offer(i);
				}
			}
		}
		
	}
	public static void main(String[] args) 
	{
		Breadth_First_Search o=new Breadth_First_Search(4);
		o.addEdge(0, 1);
		o.addEdge(1, 2);
		o.addEdge(2,3);
		o.addEdge(3, 0);
		o.display();
		o.bfs(0);
	}
}

