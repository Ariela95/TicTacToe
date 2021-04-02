package game; 

	public class Player
	{
		private String name;
		private char mark;
		
		public Player (String name, char mark)
		{
			this.name = new String (name);
			this.mark = mark;
		}
		
		public String getName()
		{
			return name;
		}
		
		public char getMark()
		{
			return mark;			
		}
		
		public String toString()
		{
			return (this.name + "(" + this.mark + ")");
		}
	}
	

/*
public class Player {
	private String name;
	private char mark;
	
	public Player(String name, char mark)
	{
		this.name = name;
		this.mark = mark;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public char getMark()
	{
		return this.mark;
	}
	
	public String toString()
	{
		return this.name+"("+this.mark+")";
	}
	
}
*/