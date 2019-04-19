package trieextn;

class TrieNode {
	static int ALPHA = 75; // 26 (a-z) + 10(0-9) + @
	TrieNode[] node = null;

	boolean isEnd = false;

	public TrieNode() {
		node = new TrieNode[ALPHA];
		isEnd = false;
	}

}

public class Trie {

	TrieNode root = null;
	int index = 0;

	public Trie() {
		root = new TrieNode();

	}

	public void insert(byte[] arr) {
		int len = arr.length;
		TrieNode pCrawl = root;
		for (int i = 0; i < len; i++) {
			int idx = arr[i] - '0';
			if (pCrawl.node[idx] == null) {
				pCrawl.node[idx] = new TrieNode();

			}
			pCrawl = pCrawl.node[idx];

		}
		pCrawl.isEnd = true;
	}

	public boolean search(byte[] arr) {
		int len = arr.length;

		TrieNode pCrawl = root;
		for (int i = 0; i < len; i++) {
			int idx = arr[i] - '0';
			if (pCrawl.node[idx] == null) {
				return false;
			}
			pCrawl = pCrawl.node[idx];
		}
		return (pCrawl != null && pCrawl.isEnd == true);
	}

	public boolean delete(byte[] arr) {
		int len = arr.length;

		TrieNode pCrawl = root;
		for (int i = 0; i < len; i++) {
			int idx = arr[i] - '0';
			if (pCrawl.node[idx] == null) {
				return false;
			}
			pCrawl = pCrawl.node[idx];
		}
		if (pCrawl != null && pCrawl.isEnd == true) {
			pCrawl.isEnd = false;
			return true;
		}
		return false;
	}

	public char[][] readTrie(byte[] prefix) {

		char[][] data = new char[10][10];

		TrieNode pCrawl = root;
		char[] str = new char[10];

		int strIdx = 0;
		if (prefix == null || prefix.length == 0) {
			readTr(pCrawl, data, str, strIdx);
		} else {
			int i = 0;
			for (i = 0; i < prefix.length; i++) {
				int idx = prefix[i] - '0';
				if (pCrawl.node[idx] != null) {
					pCrawl = pCrawl.node[idx];
					str[i] = (char) prefix[i];

				} else {
					return null;
				}

			}
			strIdx = i;
			readTr(pCrawl, data, str, strIdx);

		}
		return null;
	}

	private void readTr(TrieNode node, char[][] data, char[] arr, int strIdx) {
		if (node != null && node.isEnd) {

			for (int i = 0; i < strIdx; i++) {
				data[index][i] = arr[i];
			}

			System.out.println(index + " " + new String(arr, 0, strIdx));

			index++;
		}
		for (int i = 0; i < TrieNode.ALPHA; i++) {
			if (node.node[i] != null) {
				char val = (char) (i + '0');
				arr[strIdx] = val;
				readTr(node.node[i], data, arr, strIdx + 1);
			}
		}

	}

	public static void main(String args[]) {
		// System.out.println('z'-'0');

		Trie tr = new Trie();
		tr.insert("randeep".getBytes());
		tr.insert("randeep1".getBytes());
		tr.delete("randeep".getBytes());
		tr.insert("randeep".getBytes());
		System.out.println(tr.search("randeep".getBytes()));
		tr.readTrie("randeep".getBytes());
		System.out.println(tr.index);

	}

}
