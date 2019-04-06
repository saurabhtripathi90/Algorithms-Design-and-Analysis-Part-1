import java.util.*;
import java.io.*;

public class TwoSum
{
    
    public static void main(String ar[])
    {
        ArrayList<Long> al = new ArrayList<Long>();
		int result = 0;
		try{
		File f=new File("sum.txt");
        Scanner s=new Scanner(f); 
		while(s.hasNextLong())
		{
			long a=s.nextLong();
			al.add(a);
			
		}
		
		Collections.sort(al);
        
        for(int i = -10000; i <= 10000; i++)
        {
			System.out.println(i);
            int start = 0;
            int end = al.size() - 1;
	
            int flag = 0;
	
            while ((flag==0) && (start < end))
            {
				long a=al.get(start);
				long b=al.get(end);
		        if((a+b == i)&&(a != b))
                {
                        flag = 1;
				}
				else if(a+b > i){
							end--;
						}
				else if(a+b < i){
							start++;
						}
            }
	
            if(flag == 1){
                result++;
            }
        }
        
        System.out.println("result " + result );
    
		}
		catch(Exception E)
		{
			System.out.println(E);
		}		
        
    }
}
