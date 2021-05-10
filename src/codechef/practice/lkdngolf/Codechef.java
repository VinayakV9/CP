package codechef.practice.lkdngolf;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.List;
import java.util.Set;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.valueOf(br.readLine());

		StringBuilder result = new StringBuilder();
		while (t-- > 0) {
			String str[] = br.readLine().split(" ");
			int n = Integer.parseInt(str[0]);
			int x = Integer.parseInt(str[1]);
			int k = Integer.parseInt(str[2]);
			
			if( x%k == 0 || (n-x+1) % k == 0 ) {
				result.append("YES\n");
			}else {
				result.append("NO\n");
			}
			
		}
		
		System.out.print(result.toString());
	}
}
