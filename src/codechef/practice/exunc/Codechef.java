package codechef.practice.exunc;
/* package codechef; // don't place package name! */
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int q = Integer.parseInt(str[1]);
        int n1 = n-1;
        int[] arr = new int[n];
        str = br.readLine().split(" ");
        for(int i=0; i <n; i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        
        TreeSet<Integer> minIndexList = new TreeSet<>();
        minIndexList.add(0);
        for(int i=0; i < n1; i++){
            if( arr[i+1] % arr[i] != 0 ){
                minIndexList.add(i+1);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while(q-->0){
            str = br.readLine().split(" ");
            int type = Integer.parseInt(str[0]);
            if( type == 1 ){
                int index = Integer.parseInt(str[1]) - 1;
                int value = Integer.parseInt(str[2]);
                
                arr[index] = value;
                
                int iIndex = getMinIndex(minIndexList, index);
                if( index < n1 ){
                    int iP1Index = getMinIndex(minIndexList, index+1);
                    if( isValid(arr, index, index+1) && iIndex != iP1Index ){
                        minIndexList.remove(iP1Index);
                    } else if( !isValid(arr, index, index+1) && iIndex == iP1Index ){
                        minIndexList.add(index+1);
                    }
                }
                
                if( index > 0 ){
                    int iM1Index = getMinIndex(minIndexList, index-1);
                    if( isValid(arr, index-1, index) && iIndex != iM1Index ){
                        minIndexList.remove(iIndex);
                    } else if( !isValid(arr, index-1, index) && iIndex == iM1Index ){
                        minIndexList.add(index);
                    }
                }
            } else {
                int index = Integer.parseInt(str[1]) - 1;
                int rIndex = getMinIndex(minIndexList, index);
                rIndex++;
                result.append(rIndex+"\n");
            }
        }
        
        System.out.print(result.toString());
	}
	
	public static boolean isValid(int[] arr, int i1, int i2){
	    return ( arr[i2]%arr[i1] == 0);
	}
	
	
	public static int getMinIndex(TreeSet<Integer> minIndexList, int element){
	    if( minIndexList.contains(element) ) {
	    	return element;
	    } else {
	    	return minIndexList.floor(element);
	    }
	}
}
