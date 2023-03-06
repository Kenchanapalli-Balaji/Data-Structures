package Non_Linear;

public class Max_Heap 
{
	Integer heap[];
	int capacity;
	int ind=0;
	Max_Heap(int capacity)
	{
		this.capacity=capacity;
		heap=new Integer[capacity];
	}
	public void add(int data)
	{
		if(ind==capacity-1)
			grow();
		heap[++ind]=data;
		swim(ind);
	}
	public void grow()
	{
		capacity=capacity*2;
		Integer tempar[]=new Integer[capacity];
		for(int i=1;i<=ind;i++)
		{
			tempar[i]=heap[i];
		}
		heap=tempar;	
	}
	
	public void swim(int k)
	{
		while(k>1&&heap[k/2]<heap[k])
		{
			swap(k,k/2);
			k=k/2;
		}
	}
	public int deletemax()
	{
		int max=heap[1];
		swap(1,ind);
		ind--;
		sink(1);
		heap[ind+1]=null;
		return max;
	}
	public void sink(int k)
	{
		while(2*k<=ind)
		{
			int j=2*k;
			if(j<ind&&heap[j]<heap[j+1])
			{
				j++;
			}
			if(heap[k]<heap[j])
			{
				swap(k,j);
				k=j;
			}
		}
	}
	public void swap(int a, int b)
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
		Max_Heap o=new Max_Heap(8);
		o.add(10);
		o.add(20);
		o.add(30);
		o.add(40);
		o.add(50);
		o.add(60);
		o.add(70);
		o.add(80);
		System.out.println(o);
		System.out.println(o.deletemax());
		System.out.println(o);

	}
}
