package codechef.practice.lowsum;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0) {
        	String str[] = br.readLine().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int q = Integer.parseInt(str[1]);
        	
        	str = br.readLine().split(" ");
        	long[] arr = new long[n];
        	int i = 0;
        	for(String s : str) {
        		arr[i++] = Long.parseLong(s);
        	}
        	
        	str = br.readLine().split(" ");
        	long[] brr = new long[n];
        	i = 0;
        	for(String s : str) {
        		brr[i++] = Long.parseLong(s);
        	}
        	
        	Map<Long, Integer> map = new HashMap<>();
        	for(long a : arr) {
        		for(long b : brr) {
        			long sum = a+b;
        			map.computeIfPresent(sum, (k,v)->++v);
        			map.putIfAbsent(sum, 1);
        		}
        	}
        	
        	List<Map.Entry<Long,Integer>> set = new LinkedList<>(map.entrySet());
        	Collections.sort(set, Comparator.comparingLong(Map.Entry::getKey));
        	
        	int cum = 0;
        	TreeMap<Integer, Long> tree = new TreeMap<>();
        	for(Map.Entry<Long, Integer> entry : set) {
        		cum += entry.getValue();
        		tree.put(cum, entry.getKey());
        	}
        	
        	int index = 0;
        	StringBuilder result = new StringBuilder();
        	while(q-->0) {
        		index = Integer.parseInt(br.readLine());
        		result.append(tree.ceilingEntry(index).getValue()+"\n");
        	}
        	
        	System.out.print(result.toString());
        }
        
	}
}
