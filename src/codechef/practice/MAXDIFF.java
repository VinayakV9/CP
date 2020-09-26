package codechef.practice;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.function.Function;

public class MAXDIFF {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        while(t-->0){
            int n = scan.nextInt();
            int k = scan.nextInt();

            if( k > n-k){
                k = n-k;
            }

            long parentSum = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

            while(n-->0){
                int num = scan.nextInt();

                queue.add(num);
                if( queue.size() > k){
                    Integer maxWeight = queue.poll();
                    parentSum += maxWeight;
                }
            }

            long childSum = queue.stream()
                    .mapToLong(Integer::longValue)
                    .sum();

            long diff = Math.abs(parentSum - childSum);

            System.out.println(diff);
        }
    }
}
