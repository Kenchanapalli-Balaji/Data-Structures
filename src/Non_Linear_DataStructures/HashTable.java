package Non_Linear;

public class HashTable 
{
	HashNode buckets[];
	Integer numOfbuckets;//capacity
	Integer size;//number of key value pairs in HashTable or number of hashNodes in Hashtable
	public HashTable()
	{
		this(10);
	}
	public HashTable(int capacity)
	{
		this.numOfbuckets=capacity;
		this.buckets=new HashNode[capacity];
		this.size=0;
	}
	
	class HashNode
	{
		Integer key; //can be any generic type
		String value; // can be any generic type
		HashNode next; // reference to next HashNode 
		
		public HashNode(Integer key, String value)
		{
			this.key=key;
			this.value=value;
		}
	}
	
	
	public void put(Integer key, String value)
	{
		if(key==null||value==null)
			System.out.println("Key or value is null");
		
		int bucketIndex=getBucketIndex(key);
		HashNode head=buckets[bucketIndex];
		while(head!=null)
		{
			if(head.key.equals(key))
			{
				head.value=value;
				return;
			}
			head=head.next;
		}
		size++;
		head=buckets[bucketIndex];
		HashNode node=new HashNode(key,value);
		node.next=head;
		buckets[bucketIndex]=node;
	}
	
	public String get(Integer key)
	{
		int bucketIndex=getBucketIndex(key);
		HashNode head=buckets[bucketIndex];
		while(head!=null)
		{
			if(head.key.equals(key))
				return head.value;
			head=head.next;
		}
		return null;
	}
	
	public String remove(Integer key)
	{
		int bucketIndex=getBucketIndex(key);
		HashNode head=buckets[bucketIndex];
		HashNode previous=null;
		while(head!=null)
		{
			if(head.key.equals(key))
				break;
			previous=head;
			head=head.next;
		}
		if(head==null)
			return null;
		size--;
		if(previous!=null)
			previous.next=head.next;
		else
			buckets[bucketIndex]=head.next;
		return head.value;
		
	}
	public int getBucketIndex(Integer key) // Modular hash Function
	{
		return key % numOfbuckets; //buckets length or capacity
	}
	
	public static void main(String[] args) 
	{
		HashTable ht=new HashTable();
		ht.put(1,"Balaji");
		ht.put(2,"Deekshith");
		ht.put(3,"Vishnu");
		ht.put(10,"Sushanth");
		ht.put(10,"Sushantha");
		System.out.println(ht.size);
		System.out.println(ht.get(1));
		System.out.println(ht.remove(10));
		System.out.println(ht.size);
			
	}
}
