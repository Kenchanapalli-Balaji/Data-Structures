package Algorithms;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Test
{
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
		}
	}
Node head;
public void add(int data)
{
	Node n=new Node(data);
	if(head==null)
	{
		head=n;
		return;
	}
	Node temp=head;
	while(temp.next!=null)
	{
		temp=temp.next;
	}
	temp.next=n;	
}
public Node deleteDuplicates()
{
	Set<Integer> s=new HashSet<>();
	Node temp=head;
	while(temp!=null)
	{
		s.add(temp.data);
		temp=temp.next;
	}
	Node list=null;
	Iterator it=s.iterator();
	while(it.hasNext())
	{
		if(list==null)
		{
			list=(Node) it.next();
		}
		Node t=list;
		t.next=(Node) it.next();
		
	}
	return list;
}
public String toString()
{
	String st="";
	Node temp=head;
	while(temp!=null)
	{
		st=st+temp.data;
		if(temp.next!=null)
		{
			st=st+"->";
		}
		temp=temp.next;
	}
	return st;
}
	public static void main(String[] args)
	{
		Test ll=new Test();
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(35);
		ll.add(40);
		ll.add(50);
		ll.add(10);
		ll.add(20);
		ll.add(30);
		System.out.println(ll.deleteDuplicates());
		
		//System.out.println(ll);
	}
	
	
}
