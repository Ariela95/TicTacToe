package tree;

public class Node {
	private int count;
	private Node[] children;

	/*
	 * A constructor for Node, since there will be no option to initialize
	 * otherwise.
	 */
	
	public Node() 
	{
		count = 0;
		children = new Node['z' - 'a' + 1];
	}

	/* Calls a private function to add the given string into the tree */
	
	public void add(String s) 
	{
		if (s.isEmpty())
			this.count++;
		else {
			if(this.children[s.codePointAt(0) - 'a'] == null)	this.children[s.codePointAt(0) - 'a'] = new Node();
			(this.children[s.codePointAt(0) - 'a']).add(s.substring(1, s.length()));
		}
	}

	/*
	 * A private function, adds a string into the tree, recursively looping on the
	 * characters of the string
	 */

	/*
	 * private void recAdd(String s, int i) { if (i >= s.length() - 1) {
	 * this.count++; } else this.children[s.codePointAt(i)].recAdd(s, i + 1); }
	 */

	/*
	 * Calls a private function to determine the amount of times the given string
	 * exists in the tree.
	 */

	public int num(String s) 
	{
		if (s.isEmpty())
			return this.count;
		else if (this.children[s.codePointAt(0) - 'a'] == null)
			return 0;
		else
			return (this.children[s.codePointAt(0) - 'a']).num(s.substring(1, s.length()));
	}

	/*
	 * A private function. Tries to find the string in the tree. if exists, will
	 * return the amount of times it shows. else will return 0.
	 */

	/*
	 * private int Exists(String s, int i) { if (i >= s.length() - 1) return
	 * this.count; else if (this.children[s.codePointAt(i)] == null) return 0; else
	 * return this.children[s.codePointAt(i)].Exists(s, i + 1); }
	 * 
	 * 
	 * private int Exists(String s) { if (s.isEmpty()) return this.count; else { //s
	 * = s.substring(1, s.length()) return
	 * this.children[s.codePointAt(0)-'a'].Exists(s.substring(1, s.length())); } }
	 */
}
