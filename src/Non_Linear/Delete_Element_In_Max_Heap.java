package Non_Linear;

public class Delete_Element_In_Max_Heap 
{
	Integer heap[];
	int capacity;
	int ind=0;
	public Delete_Element_In_Max_Heap(int capacity)
	{
		this.capacity=capacity;
		heap=new Integer[capacity+1];
	}
	public void insert(int data)
	{
		if(ind==capacity-1)
			grow();
		heap[++ind]=data;
		swim(ind);
	}
	public void grow()
	{
		capacity=capacity*2;
		Integer temparr[]=new Integer[capacity];
		for(int i=1;i<=ind;i++)
		{
			temparr[i]=heap[i];
		}
		heap=temparr;
	}
	public void swim(int k) //Bottom-Top Approach
	{
		while(k>1&&heap[k/2]<heap[k])
		{
			swap(k,k/2);
			k=k/2;
		}
	}
	
	public int deleteMax()
	{
		int max=heap[1];
		swap(1,ind);
		ind--;
		sink(1);
		heap[ind+1]= null;
		return max;
	}
	public void sink(int k) // Top-Down Approach
	{
		while(2*k<=ind)
		{
			int j=2*k;
			if(j<ind&&heap[j]<heap[j+1])
				j++;
			if(heap[k]<heap[j])
			{
				swap(k,j);
				k=j;
			}
		}
	}
	public void swap(int a,int b)
	{
		int temp=heap[a];
		heap[a]=heap[b];
		heap[b]=temp;
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
		Delete_Element_In_Max_Heap obj=new Delete_Element_In_Max_Heap(8);
		obj.insert(15);
		obj.insert(20);
		obj.insert(25);
		obj.insert(5);
		obj.insert(10);
		obj.insert(6);
		obj.insert(2);
		System.out.println(obj);
		System.out.println(obj.deleteMax());
		System.out.println(obj);
		System.out.println(obj.deleteMax());
		System.out.println(obj);
		
	}
}
