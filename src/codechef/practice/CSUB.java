package codechef.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CSUB {
    public static void main(String[] args) throws IOException {
        Reader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            br.readLine();
            String line = br.readLine();
            char[] chars = line.toCharArray();
            long num = 0 ;
            for(char c : chars){
                if( c == '1'){
                    num++;
                }
            }

            long result = ( num * (num+1))/2;

            System.out.println(result);
        }
    }
}
