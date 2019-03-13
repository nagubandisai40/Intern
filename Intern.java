import java.util.*;
//class for declarations
class Listex{
	String name;
	float cgpa;
	int unqkey;
}
//Main class from where the program starts
public class Intern{
	public static void main(String[] args) {
		Test h=new Test();
		h.intern();
	}
}
//class that produces the output result(all input mismatch errors are handled)
class Test{
	public void intern(){
		int n;
		String str;
		Scanner s=new Scanner(System.in);
		try
		{
			n=s.nextInt();
		//Listex t=new Listex();	
		Comparator<Listex> comparators = new MyComparator();
		PriorityQueue<Listex> q=new PriorityQueue<Listex>(15,comparators);
		for(int i=0;i<n;i++)
		{
			Listex l=new Listex();
			str=s.next();
			if(str.equals("ENTER".trim()))
			{
				l.name=s.next();
				l.cgpa=s.nextFloat();
				l.unqkey=s.nextInt();
				q.offer(l);			
			}
			else if(str.equals("SERVED".trim())){
				q.poll();

				}
		}
			//System.out.println(q);
			if(q.isEmpty())
			{
				System.out.println("EMPTY");
			}
			else
			{	
				while(!q.isEmpty())
				{
					Listex d=q.poll();
					System.out.println(d.name);		
				}
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
//class for Customized sorting order
class MyComparator implements Comparator<Listex>{
	public int compare(Listex ob1,Listex ob2)
	{
		if(ob1.cgpa>ob2.cgpa)
		{
			return -1;
		}
		else if(ob1.cgpa<ob2.cgpa)
		{
			return 1;
		}
		else
		{
			if((ob1.name).compareTo(ob2.name)<0)
			{
				return -1;
			}
			else if((ob1.name).compareTo(ob2.name)>0)
			{
				return 1;
			}
			else{
				if(ob1.unqkey>ob2.unqkey)
				{
					return 1;		
				}
				else if(ob1.unqkey<ob2.unqkey)
				{
					return -1;
				}
				else
				{
					return 0;
				}
			}
		}
	}
}