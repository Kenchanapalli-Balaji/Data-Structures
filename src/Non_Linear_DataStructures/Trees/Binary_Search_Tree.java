package Non_Linear;

public class Binary_Search_Tree 
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
	
	/*
	public void insert(int data)
	{
		root=insert(root,data);
	}
	
	public Node insert(Node root,int data)
	{
		Node n=new Node(data);
		if(root==null)
		{
			root=n;
			return root;
		}
		if(data<root.data)
		{
			root.left=insert(root.left,data);
		}
		else
			root.right=insert(root.right,data);
		return root;
	}
	*/
	
	
	public boolean insert(int data)
	{
		Node n=new Node(data);
		if(root==null)
		{
			root=n;
			return true;
		}
		Node temp=root;
		while(true)
		{
			if(temp.data==data)
				return false;
			if(data<temp.data)
			{
				if(temp.left==null)
				{
					temp.left=n;
					return true;
				}
				temp=temp.left;
			}
			else
			{
				if(temp.right==null)
				{
					temp.right=n;
					return true;
				}
				temp=temp.right;
			}
				
		}
	}
	public boolean search(int ele)
	{
		if(root==null)
		{
			return false;
		}
		Node temp=root;
		while(true)
		{
			if(ele==temp.data)
			{
				return true;				
			}
			else if(ele<temp.data)
			{
				if(temp.left==null)
					return false;
				temp=temp.left;	
			}
			else 
			{
				if(temp.right==null)
					return false;
				temp=temp.right;
			}
		}
	}
	
	public Node find(int key)
	{
		return find(root,key);
	}
	public Node find(Node root,int key)
	{
		if(root==null||root.data==key)//base case
			return root;
		if(key<root.data)
		{
			return find(root.left,key);
		}
		else
			return find(root.right,key);	
	}
	public void printInOrder()
	{
		inOrder(root);
		System.out.println();
	}
	public void inOrder(Node root)
	{
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	
	public static void main(String[] args)
	{
		Binary_Search_Tree bt=new Binary_Search_Tree();
		bt.insert(10);
		bt.insert(30);
		bt.insert(40);
		bt.insert(1);
		bt.insert(2);
		bt.insert(20);
		bt.insert(8);
		bt.insert(100);
		bt.insert(50);
		bt.insert(55);
		bt.insert(5);
		bt.printInOrder();
		boolean res=bt.search(1000);
		if(res)
			System.out.println("Found");
		else
			System.out.println("Not Found");
		if(null!=bt.find(1000))
		{
			System.out.println("Key Found");
		}
		else
			System.out.println("Key Not Found");
	}
	
}
