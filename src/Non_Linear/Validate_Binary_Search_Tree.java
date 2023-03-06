package Non_Linear;

import java.util.Stack;

public class Validate_Binary_Search_Tree 
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
	
	public void inOrder(Node root)
	{
		if(root==null)
			return;
		
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
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
	public boolean isValidBinarySearchTree(Node root, int min,int max)
	{
		if(root==null)
			return true; //Base case
		if(root.data<=min || root.data>=max)
			return false;
		boolean left=isValidBinarySearchTree(root.left,min,root.data);
		if(left)
		{
			boolean right=isValidBinarySearchTree(root.right,root.data,max);
			return right;
		}
		return false;
				
	}
	public static void main(String[] args) 
	{
		Validate_Binary_Search_Tree bst=new Validate_Binary_Search_Tree();
		bst.insert(20);
		bst.insert(30);
		bst.insert(10);
		bst.insert(35);
		bst.insert(32);
		bst.insert(15);
		bst.insert(1);
		bst.inOrder(bst.root);
		System.out.println();
		bst.inOrder();
		System.out.println(bst.isValidBinarySearchTree(bst.root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}
