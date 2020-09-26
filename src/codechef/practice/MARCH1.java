package codechef.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

public class MARCH1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int sum = scan.nextInt();
            int []arr = new int[n];

            for(int i=0; i < n; i++){
                arr[i] = scan.nextInt();

            }

            boolean result = isSumAmtOfMoneyAvailable(arr, 0, sum);

            System.out.println(result?"Yes":"No");
        }
    }

    private static boolean isSumAmtOfMoneyAvailable(int[] arr, int index, int sum) {
        while( index < arr.length){
            if( arr[index] == sum ){
                // tail case
                return true;
            } else if ( arr[index] < sum ){
                //find result from sub structure

                return isSumAmtOfMoneyAvailable(arr, index+1, sum-arr[index]) ||
                        isSumAmtOfMoneyAvailable(arr, index+1, sum);
            }

            index++;
        }
        return false;
    }
}
