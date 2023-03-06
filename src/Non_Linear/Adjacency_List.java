package Non_Linear;

import java.util.*;

//Using Linked List

/*
public class Adjacency_List 
{
	LinkedList<Integer> adj[];
	Adjacency_List(int nodes)
	{
		this.adj=new LinkedList[nodes];
		for(int i=0;i<nodes;i++)
		{
			this.adj[i]=new LinkedList<>();
		}
	}
	public void addEdge(int u,int v)
	{
		this.adj[u].add(v);
		this.adj[v].add(u);
	}
	public void display()
	{
		for(int i=0;i<adj.length;i++)
		{
			System.out.println(i+" : "+adj[i]+" ");
		}
	}
	public static void main(String[] args) 
	{
		Adjacency_List o=new Adjacency_List(4);
		o.addEdge(0, 1);
		o.addEdge(1, 2);
		o.addEdge(2, 3);
		o.addEdge(3,0);
		o.display();
		
	}
}
*/


//Using ArrayList

public class Adjacency_List
{
	public static void addEdge(ArrayList<ArrayList<Integer>> al, int s, int d)
	{
		al.get(s).add(d);
		al.get(d).add(s);
	}
	public static void display(ArrayList<ArrayList<Integer>> am)
	{
		for(int i=0;i<am.size();i++)
		{
			System.out.println(i+" : "+am.get(i));
		}
	}
	public static void main(String[] args) 
	{
		int V=4;
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>(4);

	    for (int i = 0; i<V; i++)
	      al.add(new ArrayList<Integer>());
	    addEdge(al,0,1);
	    addEdge(al,1, 2);
		addEdge(al,2, 3);
		addEdge(al,3,0);
		display(al);
	    
	}
}


