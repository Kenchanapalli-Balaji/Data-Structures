package Non_Linear;

public class MaxHeap_Bottom_Up 
{
	int heap[];
	int ind=0;
	int capacity;
	MaxHeap_Bottom_Up(int capacity)
	{
		this.capacity=capacity;
		heap=new int[capacity];
	}
	public void add(int data)
	{
		if(ind==capacity-1)
			grow();
		heap[++ind]=data;
		swim(ind);
	}
	public void swim(int k)
	{
		while(k>1&&heap[k/2]<heap[k])
		{
			int temp=heap[k];
			heap[k]=heap[k/2];
			heap[k/2]=temp;
			k=k/2;
		}
	}
	public void grow()
	{
		capacity=capacity*2;
		int newheap[]=new int[capacity];
		for(int i=1;i<=ind;i++)
		{
			newheap[i]=heap[i];
		}
		heap=newheap;
	}
	public String toString()
	{
		String st="[";
		for(int i=1;i<=ind;i++)
		{
			st=st+heap[i];
			if(i<ind)
				st=st+",";
		}
		return st+"]";
	}
	public static void main(String[] args) 
	{
		MaxHeap_Bottom_Up obj=new MaxHeap_Bottom_Up(10);
		obj.add(15);
		obj.add(20);
		obj.add(25);
		obj.add(5);
		obj.add(10);
		obj.add(6);
		obj.add(2);
		System.out.println(obj);
	}
	
	
}
