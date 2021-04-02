package tasks;

public class NamedTasks extends Tasks {
	private String names[];
	private int orderArr[];
	private int num;

	public NamedTasks(String[] names) {
		super(names.length);
		this.names = names;
		num = names.length;
	}
	
	public boolean dependsOn(String task1, String task2)
	{
		int i, t1=-1, t2=-1;
		
		for(i=0; i<num;i++)
		{
			if(names[i].equals(task1))	t1 = i;
			if(names[i].equals(task2))	t2 = i;
		}
		
		if(t1 == -1 || t2 == -1)	return false;
		
		this.dependsOn(t1, t2);
		return true;
	}
	
	public String[] nameOrder()
	{
		String[] res = new String[num];
		
		orderArr = this.order();
		for(int i=0; i<this.num;i++)	res[i] = names[orderArr[i]];
		
		return res;
	}

}
