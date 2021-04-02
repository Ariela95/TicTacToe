package tree;

import java.util.Scanner;

public class ReversedWords{
	
	
	public static int checkReversed()
	{
		int cur, rev, res=0;
		String word, revWord = "";
		Node wordTree = new Node();
		System.out.println("Please enter a sentance.\n");
		Scanner userInput = new Scanner(System.in);
		
		while(!(word = userInput.next()).equals("X"))
		{
			
			StringBuilder revInput = new StringBuilder(); 
			  
	        // append a string into StringBuilder input1 
			revInput.append(word); 
	  
	        // reverse StringBuilder input1 
			revInput = revInput.reverse(); 
			
			revWord = revInput.toString();
			
			System.out.println(revWord);
			
			wordTree.add(word);
			
			if(word.equals(revWord))	continue;
			cur = wordTree.num(word);
			rev = wordTree.num(revWord);
			
			
			if(rev!=0)	res++;
			
		}
		
		userInput.close();
		return res;
	}
	
}
