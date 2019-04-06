import java.io.*;
import java.util.*;

public class MergeInvert {
   
        
        public static void main(String args[]) {
                
                int [] nums = new int[200000];
                int index = -1;
         try{ 
		File f=new File("D:\\algo\\IntegerArray.txt");
	    Scanner s=new Scanner(f);
    	
    	
    	while (s.hasNextInt()) {
    		
			nums[++index] = s.nextInt();
    	}
		System.out.println(MergeSort(nums, 0, index));
        }
		catch(Exception e)
		{
			System.out.println(e);
		}
        
		}   
        
        public static long MergeSort(int[] nums, int start, int end) {                
                int[] tmp = new int[200000];
                return MergeSort(nums, tmp, start, end);
        }
        
        private static long MergeSort(int[] num, int[] tmp, int start, int end) {
                long Left, Right, Split; 
                int middle = (start + end) / 2;
                if (start >= end)
                        return 0;                
                Left = MergeSort(num, tmp, start, middle);
                Right = MergeSort(num, tmp, middle+1, end);
                Split = Merge(num, tmp, start, middle+1, end);
				long countInversion=Left + Right + Split;
                return (countInversion);
        }
        
        private static long Merge(int[] num, int[] tmp, int i, 
                        int j, int end) {
                int EndOfFirstArray = j - 1;
                int retain = i;
                int numElem = end - i + 1;
                long Inversion = 0;
                
                while (i <= EndOfFirstArray && j <= end) {
                        if (num[i] <= num[j]) {
                                tmp[retain++] = num[i++];
                        } else {
                                tmp[retain++] = num[j++]; 
                                Inversion += EndOfFirstArray - i + 1;
                        }
                }                
                while (i <= EndOfFirstArray) {
                        tmp[retain++] = num[i++];
                }                
                while (j <= end) {
                        tmp[retain++] = num[j++];
                }
                
                for (int k = 0; k < numElem; k++, end--) {
                        num[end] = tmp[end];
                }
                
                return Inversion;
        }
}