package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class LinkedListPalindrome 
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
	
	public String toString()
	{
		String st="[";
		Node temp=head;
		while(temp!=null)
		{
			st=st+temp.data;
			if(temp.next!=null)
			{
				st=st+"->";
			}
			else
				st=st+"]";
			temp=temp.next;
			
		}
		return st;
	}
	
	public boolean isPalindrome(LinkedListPalindrome ll)
	{
		List<Integer> list=new ArrayList<>();
		Node temp=head;
		while(temp!=null)
		{
			list.add(temp.data);
			temp=temp.next;
		}
		int start=0;
		int end=list.size()-1;
		while(start<=end)
		{
			if(list.get(start)!=list.get(end))
				return false;
			start++;
			end--;
		}
		return true;
		
	}
	public static void main(String[] args) 
	{
		LinkedListPalindrome sl=new LinkedListPalindrome();
		sl.add(1);
		sl.add(2);
		sl.add(3);
		sl.add(3);
		sl.add(2);
		sl.add(1);
		
		System.out.println(sl);
		System.out.println(sl.isPalindrome(sl));
	}
}




/*

package Algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Test 
{
	public static  boolean isPalindrome(LinkedList<Integer> ll)
	{
		List<Integer> list=new ArrayList<>();
		//int in=0;
		for(int i=0;i<=ll.size()-1;i++)
		{
			list.add(ll.get(i));
		}
		int start=0;int end=list.size()-1;
		while(start<=end)
		{
			if(list.get(start)!=list.get(end))
				return false;
			start++;
			end--;
		}
		return true;
				
	}
	
	public static void main(String[] args) 
	{
		LinkedList<Integer> sl=new LinkedList<>();
		sl.add(10);
		sl.add(20);
		sl.add(30);
		sl.add(30);
		sl.add(20);
		sl.add(10);
		System.out.println(sl);
		System.out.println(isPalindrome(sl));
	}
	
}
*/