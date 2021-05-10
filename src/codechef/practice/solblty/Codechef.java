package codechef.practice.solblty;
/* package codechef; // don't place package name! */

/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int t = Integer.valueOf(br.readLine());
        
        while( t-->0){
            String str[] = br.readLine().split(" ");
            int x = Integer.valueOf(str[0]);
            int a = Integer.valueOf(str[1]);
            int b = Integer.valueOf(str[2]);
            
            int result = a + (100-x)*b;
            result *= 10;
            
            System.out.println(result);
        }
	}
}
