package Non_Linear;

public class BalancedTree 
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
	boolean add(int data)
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
			if(temp.data<data)
			{
				if(temp.right==null)
				{
					temp.right=n;
					return true;
				}
				temp=temp.right;
			}
			else
			{
				if(temp.data>data)
				{
					if(temp.left==null)
					{
						temp.left=n;
						return true;
					}
					temp=temp.left;
				}
			}
		}
		
	}
	
	
	void printInOrder()
	{
		inOrder(root);
		System.out.println();
	}
	void inOrder(Node temp)
	{
		if(temp==null)
			return;
		inOrder(temp.left);
		System.out.print(temp.data+" ");
		inOrder(temp.right);
	}
	
	void printPreOrder()
	{
		preOrder(root);
		System.out.println();
	}
	void preOrder(Node temp)
	{
		if(temp==null)
			return;
		System.out.print(temp.data+" ");
		inOrder(temp.left);
		inOrder(temp.right);
	}
	
	void printPostOrder()
	{
		postOrder(root);
		System.out.println();
	}
	void postOrder(Node temp)
	{
		if(temp==null)
			return;
		
		inOrder(temp.left);
		inOrder(temp.right);
		System.out.print(temp.data+" ");
	}
	
	public static void main(String[] args) 
	{
		BalancedTree bt=new BalancedTree();
		bt.add(34);
		bt.add(26);
		bt.add(85);
		bt.add(32);
		bt.add(64);
		bt.add(95);
		bt.add(23);
		bt.add(29);
		bt.add(85);
		System.out.println("In Order wise");
		bt.printInOrder();
		System.out.println("pre Order wise");
		bt.printPreOrder();
		System.out.println("post Order wise");
		bt.printPostOrder();
		
	}
}
