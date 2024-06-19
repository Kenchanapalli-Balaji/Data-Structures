package Non_Linear;

import java.util.Stack;

public class BinaryTree 
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
	
	
//Using Recursive Method	
	
//	public void preorder(Node temp)
//	{
//		if(temp==null)
//			return;
//		System.out.print(temp.data+" ");
//		preorder(temp.left);
//		preorder(temp.right);
//	}
	
//Using Iterative Mode
	public void preOrder()
	{
		if(root==null)
			return;
		Stack<Node> stk=new Stack<>();
		stk.push(root);
		while(!stk.isEmpty())
		{
			Node temp=stk.pop();
			System.out.print(temp.data+" ");
			if(temp.right!=null)
				stk.push(temp.right);
			if(temp.left!=null)
				stk.push(temp.left);
		}
		System.out.println();
	}
//Using Recursive Method	
//	public void inOrder(Node temp)
//	{
//		if(temp==null)
//			return;
//		inOrder(temp.left);
//		System.out.print(temp.data+" ");
//		inOrder(temp.right);
//	}
	
	
//Using Iterative Method
	public void inOrder()
	{
		if(root==null)
			return;
		Stack<Node> stk=new Stack<>();
		Node temp=root;
		while(!stk.isEmpty()||temp!=null)
		{
			if(temp!=null)
			{
				stk.push(temp);
				temp=temp.left;
			}
			else
			{
				temp=stk.pop();
				System.out.print(temp.data+" ");
				temp=temp.right;
			}
		}
		System.out.println();
	}
//Using Recursive Method
//	public void postOrder(Node temp)
//	{
//		if(temp==null)
//			return;
//		postOrder(temp.left);
//		postOrder(temp.right);
//		System.out.print(temp.data+" ");
//	}
	
	
//Using Iterative Method
	public void postOrder()
	{
		Node current=root;
		Stack<Node> stk=new Stack<>();
		while(current!=null||!stk.isEmpty())
		{
			if(current!=null)
			{
				stk.push(current);
				current=current.left;
			}
			else
			{
				Node temp=stk.peek().right;
				if(temp==null)
				{
					temp=stk.pop();
					System.out.print(temp.data+" ");
					while(!stk.isEmpty()&&temp==stk.peek().right)
					{
						temp=stk.pop();
						System.out.print(temp.data+" ");
					}
				}
				else
				{
					current=temp;
				}
			}
		}
		System.out.println();
	}
	public static void main(String[] args) 
	{
		BinaryTree bt=new BinaryTree();
		bt.createBinaryTree();
		bt.preOrder();
		bt.inOrder();
		bt.postOrder();
		
	}
}
