package Non_Linear;

import java.util.LinkedList;
import java.util.Stack;

public class Depth_First_Search 
{
	LinkedList<Integer> adj[];
	Depth_First_Search(int nodes)
	{
		this.adj=new LinkedList[nodes];
		for(int i=0;i<adj.length;i++)
		{
			this.adj[i]=new LinkedList<>();
		}
	}
	public void addEdge(int u,int v)
	{
		this.adj[u].add(v);
		this.adj[v].add(u);
	}
	public void display(int s)
	{
		for(int i=0;i<adj.length;i++)
		{
			System.out.println(i+" : "+adj[i]);
		}
	}
	public void dfs(int s)
	{
		boolean visited[]=new boolean[adj.length];
		Stack<Integer> stk=new Stack<>();
		stk.push(s);
		while(!stk.isEmpty())
		{
			int u=stk.pop();
			if(!visited[u])
			{
				visited[u]=true;
				System.out.print(u+" ");
				for(int v:adj[u])
				{
					if(!visited[v])
						stk.push(v);
				}
			}
		}
	}
	public static void main(String[] args)  
	{
		Depth_First_Search o=new Depth_First_Search(4);
		o.addEdge(0, 1);
		o.addEdge(0, 3);
		o.addEdge(3, 2);
		o.addEdge(2, 1);
		o.display(0);
		o.dfs(0);
	}
}
