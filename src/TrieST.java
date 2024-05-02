public class TrieST<Value> {
	private static final int R = 256;
	private Node root = new Node();

	private static class Node {
		private Object val;
		private Node[] next = new Node[R];
	}

	public void put(String key, Value val) {
		root = put(root, key, val, 0);
	}

	public void Search(String key) {
		System.out.println(contains(key));
	}

	private Node put(Node x, String key, Value val, int d) {
		if (x == null)
			x = new Node();
		if (d == key.length()) {
			x.val = val;
			return x;
		}
		char c = key.charAt(d);
		x.next[c] = put(x.next[c], key, val, d + 1);
		return x;
	}

	public Iterable<String> keys() {
		Queue<String> queue = new Queue<String>();
		collect(root, "", queue);
		return queue;
	}

	private void collect(Node x, String prefix, Queue<String> q) {
		if (x == null)
			return;
		if (x.val != null)
			q.enqueue(prefix);
		for (char c = 0; c < R; c++)
			collect(x.next[c], prefix + c, q);
	}

	public Iterable<String> keysWithPrefix(String prefix) {
		Queue<String> queue = new Queue<String>();
		Node x = get(root, prefix, 0);
		collect(x, prefix, queue);
		return queue;
	}

	public void countPrefix() {
		for(String s:keys()) {
			Queue<String> q = (Queue<String>) keysWithPrefix(s);
			int count =-1;
			while (!q.isEmpty()) {
				q.dequeue();
				count++;
			}
			System.out.println(s+": "+count);
			
		}
		
		
	}
	  public void reverseFind(String suffix) {
	        reverseFind(root, "", suffix);
	    }

	    private void reverseFind(Node x, String current, String suffix) {
	        if (x == null)
	            return;

	        if (x.val != null && current.endsWith(suffix)) {
	            System.out.println(current);
	        }

	        for (char c = 0; c < R; c++) {
	            reverseFind(x.next[c], current + c, suffix);
	        }
	    }
	    public void ShortestUniquePrefix(TrieST trie) {
	        if (trie == null) {
	            return;
	        }
	        for (String word : (Queue<String>)trie.keys()) {
	            int count = 0;
	            for (String otherWord : (Queue<String>)trie.keys()) {
	                if (word != otherWord && otherWord.startsWith(word)) {
	                    count++;
	                }
	            }
	            if (count == 1) {
	                System.out.println(word);
	            } else {
	                System.out.println("not exists");
	            }
	        }
	    }
	    public void LongestCommonPrefix() {
	        String lcp = findLongestCommonPrefix(root, "");
	        if (lcp.isEmpty()) {
	            System.out.println("not exists");
	        } else {
	            System.out.println(lcp);
	        }
	    }

	    private String findLongestCommonPrefix(Node x, String current) {
	        if (x == null || x.val != null) {
	            return current;
	        }

	        int childCount = 0;
	        char commonChar = 0;

	        for (char c = 0; c < R; c++) {
	            if (x.next[c] != null) {
	                childCount++;
	                commonChar = c;
	            }
	        }

	        if (childCount == 1) {
	            return findLongestCommonPrefix(x.next[commonChar], current + commonChar);
	        } else {
	            return current;
	        }
	    }
	
	public boolean contains(String key) {
		return get(key) != null;
	}

	public Value get(String key) {
		Node x = get(root, key, 0);
		if (x == null)
			return null;
		return (Value) x.val;
	}

	private Node get(Node x, String key, int d) {
		if (x == null)
			return null;
		if (d == key.length())
			return x;
		char c = key.charAt(d);
		return get(x.next[c], key, d + 1);
	}

}
