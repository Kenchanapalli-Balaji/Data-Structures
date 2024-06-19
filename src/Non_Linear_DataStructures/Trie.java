package Non_Linear;

public class Trie 
{
	public class TrieNode
	{
		TrieNode children[];
		boolean isWord;
		TrieNode()
		{
			this.children=new TrieNode[26];//to store english alphabets a-z;
			this.isWord=false;
		}
	}
	TrieNode root;
	Trie()
	{
		this.root=new TrieNode();//root is empty
	}
	
	public void insert(String word)
	{
		if(word==null||word.isEmpty())
			throw new IllegalArgumentException("Invalid input");
		word=word.toLowerCase();
		TrieNode current=root;
		
		for(int i=0;i<word.length();i++)
		{
			char c=word.charAt(i);
			int index=c-'a';
			if(current.children[index]==null)
			{
				TrieNode node=new TrieNode();
				current.children[index]=node;
				current=node;
			}
			else
				current=current.children[index];
		}
		current.isWord=true;
	}
	
	
	public static void main(String[] args) 
	{
		Trie trie=new Trie();
		trie.insert("CAT");
		trie.insert("CAB");
		trie.insert("SON");
		System.out.println("Values inserted Successfully");
		
	}
}
