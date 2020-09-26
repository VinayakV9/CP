package codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class FCTRL {
    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int t = Integer.parseInt(br.readLine());

        while( t-- > 0 ){
            int num = Integer.parseInt(br.readLine());
            int trailingZeros = trailingZeros(num, 5);
            System.out.println(trailingZeros);
        }

    }

    public static int trailingZeros(int num , int pow){
        int result = num / pow;
        if (result > 0 ) {
            result += trailingZeros(num, pow * 5);
        }
        return result;
    }
}
