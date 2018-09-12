package org.saggu;

class TrieNode {
	static final int ALPHABETS = 26;
	TrieNode children[] = new TrieNode[26];
	boolean isEndOfWord;

	TrieNode() {
		isEndOfWord = false;
		for (int i = 0; i < ALPHABETS; i++) {
			children[i] = null;
		}
	}

}

public class Trie {

	static TrieNode root = new TrieNode();

	public static void insert(String str) {
		TrieNode pCrawl = root;
		for(int i =0;i<str.length();i++) {
			int val = str.charAt(i)-'a';
			if(pCrawl.children[val]==null)
			{
				pCrawl.children[val] =new TrieNode();
			}
			pCrawl = pCrawl.children[val];
			pCrawl.isEndOfWord= true;
			
		}
	}

	public static boolean  search(String str) {

		TrieNode ptr = root;
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - 'a';

			if (ptr.children[index] == null) {
				return false;
			}

			ptr = ptr.children[index];
		}
		return (ptr != null && ptr.isEndOfWord);

	}

	public static void main(String args[]) {

		String keys[] = { "the", "a", "there", "answer", "any", "by", "bye", "their" };

		String output[] = { "Not present in trie", "Present in trie" };

		root = new TrieNode();

// Construct trie
		int i;
		for (i = 0; i < keys.length; i++)
			insert(keys[i]);

// Search for different keys
		if (search("the") == true)
			System.out.println("the --- " + output[1]);
		else
			System.out.println("the --- " + output[0]);

		if (search("these") == true)
			System.out.println("these --- " + output[1]);
		else
			System.out.println("these --- " + output[0]);

		if (search("their") == true)
			System.out.println("their --- " + output[1]);
		else
			System.out.println("their --- " + output[0]);

		if (search("thaw") == true)
			System.out.println("thaw --- " + output[1]);
		else
			System.out.println("thaw --- " + output[0]);

	}

}


