package codechef.practice;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NUKES {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int n = scan.nextInt();
        int k = scan.nextInt();

        int[] arr = new int[k];

        for(int i = 0 ; i < arr.length && a > 0 ; i++){
            arr[i] = a % (n+1);
            a = a / (n+1);
        }

        String result = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
