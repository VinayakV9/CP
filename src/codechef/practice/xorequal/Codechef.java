package codechef.practice.xorequal;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());
        
        long[] dp = new long[1000_00];
        long MOD = 1000_000_007;
        
        dp[0] = 1;
        
        for(int i =1; i < 1000_00; i++) {
        	dp[i] = dp[i-1] * 2;
        	dp[i] %= MOD;
        }
        
        StringBuilder result = new StringBuilder();
        while(t-->0) {
        	int n = Integer.parseInt(br.readLine());
        	
        	n--;

        	long o = dp[n];
        	
        	result.append(o+"\n");
        }
        
        System.out.print(result.toString());
	}
}
