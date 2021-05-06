package codechef.practice.stacks;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		int t = Integer.parseInt(br.readLine());
		
		while(t-->0) {
			String s = br.readLine();
			String str[] = br.readLine().split(" ");
		
			TreeMap<Integer, Integer> tree = new TreeMap<>();
			
			for(String num : str) {
				int n = Integer.valueOf(num);
				Integer ceilingNum = tree.higherKey(n);
				if( ceilingNum != null) {
					if( tree.get(ceilingNum) > 1 ) {
						tree.compute(ceilingNum, (k,v)->--v);
					} else {
						tree.remove(ceilingNum);
					}
				}
				tree.computeIfPresent(n, (k,v)->++v);
				tree.putIfAbsent(n,1 );
			}
			
			StringBuilder result = new StringBuilder();
			int count = 0;
			for(Map.Entry<Integer, Integer> n : tree.entrySet()) {
				int occ = n.getValue();
				int key = n.getKey();
				count += occ;
				while(occ-->0)
				result.append(" "+key);
			}
			
			System.out.println(count+result.toString());
		}
        
	}
}
