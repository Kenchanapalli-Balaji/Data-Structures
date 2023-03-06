package Non_Linear;
public class Maximum_Value_In_BinaryTree
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
	
	public int findMax(Node root)
	{
		if(root==null)
			return 0;
		int res=root.data;
		int left=findMax(root.left);
		int right=findMax(root.right);
		if(left>res)
			res=left;
		if(right>res)
			res=right;
		return res;
	}
	
	public static void main(String[] args)
	{
		Maximum_Value_In_BinaryTree obj=new Maximum_Value_In_BinaryTree();
		obj.createBinaryTree();
		int result=obj.findMax(obj.root);
		System.out.println("Maximum value is :"+result);
		
	}
	
}
