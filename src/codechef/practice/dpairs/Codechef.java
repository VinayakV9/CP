package codechef.practice.dpairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str[] = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int max = n+m-1;
        
        
        Map<Long, Integer> aMap = new HashMap<>();
        str = br.readLine().split(" ");
        for(int i = 0 ; i < str.length; i++) {
        	long num = Long.parseLong(str[i]);
        	aMap.put(num, i);
        }
        

        Map<Long, Integer> bMap = new HashMap<>();
        str = br.readLine().split(" ");
        for(int i = 0 ; i < str.length; i++) {
        	long num = Long.parseLong(str[i]);
        	bMap.put(num, i);
        }
        
        Set<Long> aPlusBSet = new HashSet<>();
        
        List<Integer> pairA = new LinkedList<>();
        List<Integer> pairB = new ArrayList<>();
        
        Long aList[] = new Long[aMap.size()];
        Long bList[] = new Long[bMap.size()];

        aMap.keySet().toArray(aList);
        bMap.keySet().toArray(bList);
        
        Arrays.sort(aList);
        Arrays.sort(bList, Comparator.reverseOrder());
        
        outer:
        for(long a : aList){
            
            for(long b : bList){
                if( !aPlusBSet.contains(a+b)) {
                	pairA.add(aMap.get(a));
                	pairB.add(bMap.get(b));
                	
                	aPlusBSet.add(a+b);
                	if( pairB.size() == max){
                        break outer;
                    }
                	
                }
                
            }
            
        }
        
        int i = 0;
        for(int x : pairA){
            System.out.println(x +" "+pairB.get(i));
            i++;
        }
	}
}
