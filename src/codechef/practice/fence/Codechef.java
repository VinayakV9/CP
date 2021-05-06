package codechef.practice.fence;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str[] = null;
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder result = new StringBuilder();
        while(t-->0) {
        	str = br.readLine().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);
        	int k = Integer.parseInt(str[2]);
        	int n1 = n-1;
        	int m1 = m-1;
        	
        	boolean grid[][] = new boolean[n][m];
        	long fences = 0;
        	while(k-->0) {
        		str = br.readLine().split(" ");
        		int ri = Integer.parseInt(str[0]) - 1;
        		int ci = Integer.parseInt(str[1]) - 1;
        		
        		grid[ri][ci] = true;
        		long fenceToAdd = 4;
        		if(ri>0 && grid[ri-1][ci]) fenceToAdd -= 2;
        		if(ri<n1 && grid[ri+1][ci]) fenceToAdd -= 2;
        		if(ci>0 && grid[ri][ci-1]) fenceToAdd -= 2;
        		if(ci<m1 && grid[ri][ci+1]) fenceToAdd -=2;
        		
        		fences += fenceToAdd;
        	}
        	
        	result.append(fences+"\n");
        }
        System.out.print(result.toString());
	}
}
