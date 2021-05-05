package codechef.practice.dpairs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        
        Map<Long, List<Integer>> aMap = new HashMap<>();
        str = br.readLine().split(" ");
        for(int i = 0 ; i < str.length; i++) {
        	long num = Long.parseLong(str[i]);
        	aMap.putIfAbsent(num, new LinkedList<>());
        	aMap.get(num).add(i);
        }
        

        Map<Long, List<Integer>> bMap = new HashMap<>();
        str = br.readLine().split(" ");
        for(int i = 0 ; i < str.length; i++) {
        	long num = Long.parseLong(str[i]);
        	bMap.putIfAbsent(num, new LinkedList<>());
        	bMap.get(num).add(i);
        }
        
        Set<Long> aPlusBSet = new HashSet<>();
        
        List<Integer> pairA = new LinkedList<>();
        List<Integer> pairB = new ArrayList<>();
        
        outer:
        for(Map.Entry<Long, List<Integer>> aEntry : aMap.entrySet()){
            long a = aEntry.getKey();
            List<Integer> aIndexList = aEntry.getValue();
            
            for(Map.Entry<Long, List<Integer>> bEntry : bMap.entrySet()){
                long b = bEntry.getKey();
                List<Integer> bIndexList = bEntry.getValue();
                if( !aPlusBSet.contains(a+b)) {
                	pairA.add(aIndexList.get(0));
                	pairB.add(bIndexList.get(0));
                	
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
