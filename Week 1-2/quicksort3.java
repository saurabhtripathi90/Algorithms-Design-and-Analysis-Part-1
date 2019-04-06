import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
//median of first,middile and last element 
class quicksort3
{
static int sum=0;
public static void main(String ar[])
{
	int size=10000;
	int a[]=new int[size+1];
	
try
{
	File f= new File("D:\\algo\\QuickSort.txt");
	
        Scanner s=new Scanner(f);
        int i=0;
        
        while(s.hasNextLine())
        {
                a[i++] = Integer.parseInt(s.nextLine());
        }
	
       
}
catch(Exception e)
{
    
    System.out.print("exception");
}


quicksort(a,0,size-1);
for(int j=0;j<size;j++)
	{
				System.out.println(a[j]);
	}
	System.out.println("Number of Inversion "+sum);

}
static int quicksort(int a[],int l,int r)
{
	if(l >= r)
	{
		return 1;
		
	}
	sum=sum+(r-l);
	
	int p=partition(a,l,r);
	
	quicksort(a,l,p-1);
	quicksort(a,p+1,r);
	return 0;
	
}
static int partition(int a[],int l,int r)
{
	
	int pivot;
	int mid=(l+r)/2;
	
	
	if(a[l]>a[mid])
	{
		if(a[l]<a[r])
		{
			pivot=l;
		}
		else if(a[mid]>a[r])
		{
			pivot=mid;
			
		}
		else
		{
			pivot=r;
			
		}
	}
	else
	{
		if(a[mid]<a[r])
		{
			pivot=mid;
		}
		else if(a[l]>a[r])
		{
			pivot=l;
		}
		else
		{
			pivot=r;
		}
	}
	
	int temp=a[pivot];//replacing mid element with the first element
	a[pivot]=a[l];
	a[l]=a[pivot];
	
	int i=l+1;
	
	
	
	for(int j=l+1;j<=r;j++)
	{
		if(a[j]<pivot)
		{
			int swap=a[j];
			a[j]=a[i];
			a[i]=swap;
			i++;
		}
		else if(a[j]>pivot)
		{
			
			
		}
	}
	int s=a[i-1];
	a[i-1]=a[l];
	a[l]=s;
	return i-1;
	
}
}