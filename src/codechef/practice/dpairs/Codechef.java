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
        
        
        int aMin = Integer.MAX_VALUE;
        int aIndex = 0;
        str = br.readLine().split(" ");
        for(int i = 0 ; i < str.length; i++) {
        	int num = Integer.parseInt(str[i]);
        	if( num < aMin) {
        		aMin = num;
        		aIndex = i;
        	}
        }
        
        int bMax = Integer.MIN_VALUE;
        int bIndex = 0;
        str = br.readLine().split(" ");
        for(int i = 0 ; i < str.length; i++) {
        	int num = Integer.parseInt(str[i]);
        	if( num > bMax) {
        		bMax = num;
        		bIndex = i;
        	}
        }        
        
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < m; i++){
            result.append(aIndex+" "+i+"\n");
        }

        for(int i = 0; i < n; i++){
        	if( i == aIndex) continue;
            result.append(i+" "+bIndex+"\n");
        }
        
        System.out.print(result.toString());
	}
}
