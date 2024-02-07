/*
Step 1: Traverse the array
Step 2: Match the key element with array element
Step 3: If key element is found, return the index position of the array element
Step 4: If key element is not found, return -1
 */

package Algorithms;

public class LinearSearch 
{
	public static int search(int ar[],int num)
	{
		for(int i=0;i<ar.length;i++)
		{
			boolean res=true;
			if(ar[i]==num)
			{
				return i;
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) 
	{
		int ar[]= {3,4,2,5,6,7,10,13,15,20};
		System.out.println("Found at index :"+search(ar,10));
		
		
	}
}
