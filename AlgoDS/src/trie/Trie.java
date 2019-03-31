package trie;

class TrieNode {
	static int ALPHA = 26;
	TrieNode[] node = null;
	boolean isEnd = false;

	public TrieNode() {
		node = new TrieNode[26];
		isEnd = false;
	}
}

public class Trie {
	TrieNode root = null;
	int index = 0;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String str) {
		int len = str.length();

		TrieNode pCrawl = root;

		for (int i = 0; i < len; i++) {
			int idx = str.charAt(i) - 'a';
			if (pCrawl.node[idx] == null) {
				pCrawl.node[idx] = new TrieNode();
			}

			pCrawl = pCrawl.node[idx];
		}
		pCrawl.isEnd = true;

	}

	public boolean search(String str) {
		int len = str.length();
		TrieNode pCrawl = root;

		for (int i = 0; i < len; i++) {
			int idx = str.charAt(i) - 'a';
			if (pCrawl.node[idx] == null) {
				return false;
			}

		}
		return (pCrawl != null && pCrawl.isEnd);
	}

	public char[][] readTrie(String prefix) {

		char[][] data = new char[10][10];
		// int index =0;
		TrieNode node = root;
		char[] str = new char[10];
		int strIdx = 0;
		if (prefix == "" || prefix == null) {
			readTr(node, data, str, strIdx);
		} else {
			TrieNode nod = root;
			int i = 0;
			for (i = 0; i < prefix.length(); i++) {
				int idx = prefix.charAt(i) - 'a';
				if (nod.node[idx] != null) {
					nod = nod.node[idx];
					str[i] = prefix.charAt(i);

				} else {
					return null;
				}
			}

			strIdx = i;

			readTr(nod, data, str, strIdx);
		}

		return data;

	}

	private void readTr(TrieNode nod, char[][] data, char[] arr, int strIdx) {
		if (nod != null && nod.isEnd) {

			for (int i = 0; i < strIdx; i++) {
				data[index][i] = arr[i];
			}

			System.out.println(index + " " + new String(arr, 0, strIdx));

			index++;
		}
		for (int i = 0; i < TrieNode.ALPHA; i++) {
			if (nod.node[i] != null) {
				char val = (char) (i + 'a');
				arr[strIdx] = val;
				readTr(nod.node[i], data, arr, strIdx + 1);
			}
		}

	}

	public static void main(String args[]) {

		Trie tr = new Trie();
		tr.insert("randeep");
		tr.insert("mandeep");
		tr.insert("sandeep");
		tr.insert("randeeps");

		tr.readTrie("rande");

	}

}
