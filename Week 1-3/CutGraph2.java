import java.util.*;
import java.io.*;

class CutGraph2
{
	static Hashtable<Integer, Vert> ve= new Hashtable<Integer,Vert>();
	static ArrayList<Edges> ed=new ArrayList<Edges>();
    public static void main(String ar[])
    {
	
       
	    try{
		
		File f= new File("D:\\algo\\MinCut.txt");
		Scanner s = new Scanner(f);
        while (s.hasNextLine()){
			 Scanner Everyline = new Scanner(s.nextLine());
			 int Vertvalue = Everyline.nextInt();
			 //System.out.println(Vertvalue);
			 Vert v1 = new Vert(Vertvalue);
			 ve.put(Vertvalue, v1);//key-vaue pair
		}
		//add ed in the graph
		Scanner s1 = new Scanner(f);
		while (s1.hasNextLine()){
			 
			 Scanner Everyline = new Scanner(s1.nextLine());
			 int v1 = Everyline.nextInt();
			 Vert ve1=ve.get(v1);
			 while(Everyline.hasNextInt())
			 {
				int v2=Everyline.nextInt();
				Vert ve2=ve.get(v2);
				if(ve1.value < ve2.value)
				{
					add(ve1,ve2,1);
				}
			 }
			 
		}		
		}
		catch(Exception E)
		{
			System.out.println(E);
		}	 
		
		int a=findminimumcut();
		System.out.println("Probable Min Cut ,Hello saurabh ,you have to rum many times to get 17 since result is based on random Edges selection");
		System.out.println(a);
}


public static int remove(Vert u, Vert v){
		int count = 0;
		int v1 = u.value;
		int v2 = v.value;
		Vert min=ve.get(Math.min(v1, v2));
		Vert max=ve.get(Math.max(v1, v2));
		Edges e = new Edges(min,max);
		for (int i = 0; i < u.al.size(); i++){
			if (u.al.get(i).same(e)){
				u.al.remove(i);
				i--;
			}
		}
		for (int i = 0; i < v.al.size(); i++){
			if (v.al.get(i).same(e)){
				v.al.remove(i);
				i--;
			}
		}
		for (int i = 0; i < ed.size(); i++){
			if (ed.get(i).same(e)){
				ed.remove(i);
				i--;
				count++;
			}
		}
		return count;
	}
	
public static void add(Vert u, Vert v, int count){
		int v1 = u.value;
		int v2 = v.value;
		Vert min=ve.get(Math.min(v1, v2));
		Vert max=ve.get(Math.max(v1, v2));
		Edges e = new Edges(min,max);
		for (int i = 0; i < count; i++){
			ve.get(v1).al.add(e);
			ve.get(v2).al.add(e);
			ed.add(e);
		}
	}

	
	public static int findminimumcut() {
		int n = ve.size();
		int minimumcut = n;
		
		
		for (int i = 0; i < n; i++){
			
					Random r = new Random();
					while (ve.size() > 2){
						int index = r.nextInt(ed.size());
						Edges e = ed.get(index);
						int valueV = e.v.value;
						Vert u = e.u;
						Vert v = e.v;
						remove(u, v);
						while (v.al.size() > 0){
							Vert w = v.al.get(0).different(v);
							add(u, w, remove(v, w));
						}
						ve.remove(valueV);
					}
			int c = ed.size();
			if (c < minimumcut){
				minimumcut = c;
			}
		}
		return minimumcut;
	}
}	


class Vert{
	public int value;
	public ArrayList<Edges> al;
	
	public Vert(int value){
		this.value = value;
		al = new ArrayList<Edges>();
	}	
}

class Edges{
	public Vert u;
	public Vert v;
	public Edges(Vert u, Vert v){
		this.u = u;
		this.v = v;
	}
	
	public Vert different(Vert u){
		if (u == this.u){
			return v;
		} else {
			return this.u;
		}
	}
	
	public boolean same(Edges e){
		if (e.u == this.u && e.v == this.v){
			return true;
		} else {
			return false;
		}
	}
	
	
}