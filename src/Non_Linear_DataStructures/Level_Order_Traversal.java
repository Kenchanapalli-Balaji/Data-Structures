package Non_Linear;

import java.util.LinkedList;
import java.util.Queue;
public class Level_Order_Traversal 
{
	class Node
	{
		int data;
		Node left;
		Node right;
		Node(int data)
		{
			this.data=data;
		}
	}
	Node root;
	
	public void createBinaryTree()
	{
		Node first=new Node(10);
		Node second=new Node(20);
		Node third =new Node(30);
		Node fourth=new Node(40);
		Node fifth=new Node(50);
		Node sixth=new Node(60);
		
		root=first;
		first.left=second;
		first.right=third;
		second.left=fourth;
		second.right=fifth;
		third.left=sixth;
		
	}
	public void levelOrder()
	{
		if(root==null)
			return;
		Queue<Node> q=new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty())
		{
			Node temp=q.poll();
			System.out.print(temp.data+" ");
			if(temp.left!=null)
				q.offer(temp.left);
			if(temp.right!=null)
				q.offer(temp.right);
		}
		System.out.println();
	}
	public static void main(String[] args) 
	{
		Level_Order_Traversal obj=new Level_Order_Traversal();
		obj.createBinaryTree();
		obj.levelOrder();
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
	}
}
