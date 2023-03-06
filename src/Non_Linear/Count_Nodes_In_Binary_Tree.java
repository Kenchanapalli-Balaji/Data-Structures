/*
 Full Node :- Nodes with both & right child are called full node.
 Half Node :- Nodes that have either left or right child but not both.
 leaf Node :- Nodes that have neither left or right child.
 */
package Non_Linear;

import java.util.LinkedList;
import java.util.Queue;

public class Count_Nodes_In_Binary_Tree
{
	public class Node
	{
		int data;
		Node left;
		Node right;
		public Node(int data)
		{
			this.data=data;
		}
		public Node(int data,Node left, Node right)
		{
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	static Node root;
	public void add()
	{
		Node left=new Node(2);
		Node right=new Node(3);
		 root=new Node(1,left,right);
		left.left=new Node(4);
		right.left=new Node(5,new Node(7),null);
		right.right=new Node(7,null,new Node(8));
	}	
	
	static int fullnodes=0;
	static int halfnodes=0;
	static int leafnodes=0;
	public void countNodesRecursive(Node node)
	{
		
		if(node==null)
			return;
		if(node.left!=null &&node.right!=null)
			fullnodes++;
		else if(node.left!=null ||node.right!=null)
			halfnodes++;
		else
			leafnodes++;
		countNodesRecursive(node.left);
		countNodesRecursive(node.right);
		
		
	}
	
	public void countNodesIterative(Node node)
	{
		if(node==null)
			return;
		Queue<Node> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty())
		{
			Node current=q.remove();
			if(current.left!=null && current.right!=null)
			{
				fullnodes++;
				q.add(current.left);
				q.add(current.right);
			}
			else if(current.left!=null || current.right!=null)
			{
				halfnodes++;
				q.add(current.left !=null ? current.left :current.right);
			}
			else
				leafnodes++;
		}
		
	}
	public static void main(String[] args) 
	{
		Count_Nodes_In_Binary_Tree b1=new Count_Nodes_In_Binary_Tree();
		b1.add();
		b1.countNodesRecursive(root);
		//b1.countNodesIterative(root);
		
		System.out.println("Full Nodes  :- "+fullnodes);
		System.out.println("Half Nodes  :- "+halfnodes);
		System.out.println("Leaf Nodes  :- "+leafnodes);
		
	}
	
	
}
