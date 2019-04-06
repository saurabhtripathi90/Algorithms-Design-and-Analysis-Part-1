import java.io.*;
import java.util.*;

class Dijkistra
{
	static ArrayList<ArrayList<int[]>> al=new ArrayList<ArrayList<int[]>>();
	static HashSet<Integer> h=new HashSet<Integer>();
	static int path[];
	public static void main(String ar[])
	{
		try{
			File f=new File("D:\\algo\\sample.txt");
			Scanner s=new Scanner(f);
			int n=0;
			while(s.hasNextLine())
			{
				String s1=s.nextLine();
				//System.out.println(s1);
				n++;
				
				String e[]=s1.split("\\t");
				int node=Integer.parseInt(e[0]);
				 //vertices.add(new ArrayList<int[]>());
				al.add(new ArrayList<int[]>());
				for(int i=1;i<e.length;i++)
				{
					String csv[]=e[i].split(",");
					int csv1[]=new int[2];
					csv1[0]=Integer.parseInt(csv[0]);
					csv1[1]=Integer.parseInt(csv[1]);
					al.get(node-1).add(csv1);
					//System.out.println(al.get(node-1).toString());
				}
				
			}
			System.out.println(al.size());
			path=new int[al.size()];
			h=new HashSet(al.size());
			h.add(1);
			int len=1000000;
			int v=-1;
			while(h.size() < n)
			{
				for (int x : h){				
				for (int[] e : al.get(x - 1)){	
					if(!h.contains(e[0]))
					{
						if(path[x - 1]+ e[1] < len)
						{
							v = e[0];
							len = path[x - 1]+e[1];
							//path[e[0]]=len;
						}
					}
				}
				}
				if(v == -1)
				{
					for(int i=0;i<n;i++)
					{
						if (!h.contains(i+1)){
						path[i] = 1000000;
						}

					}
				}
				else
				{
					h.add(v);
					path[v-1]=len;
					
				}
			}
			for(int i=0;i<path.length;i++)
			{
				System.out.println(path[i]);
			}
			
				
				
			//print the arraylist
			/*int k = 1;
		    for (ArrayList<int[]> a : al){
			System.out.print(k + ": {");
			for (int[] i : a){
				System.out.print(Arrays.toString(i));
			}
			System.out.println("}");
			k++;
			}*/
			
			
			
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
}