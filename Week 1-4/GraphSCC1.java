import java.io.*;
import java.util.*;

class GraphSCC1
{
	static ArrayList<ArrayList<Integer>> a1
			=new ArrayList<ArrayList<Integer>>();
	static ArrayList<ArrayList<Integer>> a2
			=new ArrayList<ArrayList<Integer>>();
			
	    static int f[];
		static int time;
		static int visit[];
		static int visit1[];
		
		static int l[]; 
		static int s=0;	
		
	public static void DepthFirstLookUp(){
		
		for(int i=f.length-1;i>=0;i--)
		{
			if(visit1[f[i]] == 0)
			{
				s=f[i];
				DepthFirst(f[i]);
				
			}
		}
		
	}
	
	public static void DepthFirst(int i){
	            visit1[i]=1;
				l[s]++;
				for (int h : a1.get(i)){
				if (visit1[h] == 0){
				DepthFirst(h);
				}
				}
				
				
	}
		
	public static void main(String ar[])
	{
		try{
			
			File f=new File("D:\\algo\\SCC.txt");
			Scanner s=new Scanner(f);
			
			
			while(s.hasNextInt())
			{
				int t=s.nextInt();
				int h=s.nextInt();
				
				
				int max;
				if(h>t)
				{
					max=h;
				}
				else
				{
					max=t;
				}
				while(a1.size()< max)
				{
					a1.add(new ArrayList<Integer>());
					a2.add(new ArrayList<Integer>());
					
				}
				a1.get(t-1).add(h-1);//real arraylist
				a2.get(h-1).add(t-1);//a2 arraylist
			}
			
			//comment code for print the Graph
			
		/*	Iterator itr=a1.iterator();
			while(itr.hasNext())
			{
				System.out.println(itr.next());
			}
			
			System.out.println("Reverese Graph");
			Iterator itr2=a2.iterator();
			while(itr2.hasNext())
			{
				System.out.println(itr2.next());
			}
		*/
		}
		catch(Exception E)
		{
			System.out.println(E);
		}
		
		 f=new int[a2.size()];
		 time=0;
		 visit=new int[a1.size()];
		 visit1=new int[a2.size()];
		 l= new int[a2.size()];
		 
		
		int[] SCC = new int[5];
		DepthFirstLookUpReverse();
		DepthFirstLookUp();
		
		Arrays.sort(l);
		for (int i = 0; i < 5; i++){
			int length=l.length-i-1;
			SCC[i] = l[length];
			System.out.print(SCC[i]+" ");
		}
		
		
		
	}
	
	public static void DepthFirstLookUpReverse(){
		
		for(int i=a2.size()-1;i>=0;i--)
		{
			if(visit[i] == 0)
			{
				DepthFirstReverse(i);
			}
		}
		
	}
	
	public static void DepthFirstReverse(int i){
	            visit[i]=1;
				for (int h : a2.get(i)){
				if (visit[h] == 0){
				DepthFirstReverse(h);
				}
				}
				f[time++] = i;
				
	}
	
	
	
	
	
	
}