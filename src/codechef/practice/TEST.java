package codechef.practice;

import java.io.*;

public class TEST {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = System.in;

        Reader reader = new InputStreamReader(inputStream);

        BufferedReader br = new BufferedReader(reader);

        String s;

        while ((s = br.readLine()) != null && !s.isEmpty()) {
            int num = Integer.parseInt(s);
            if (num == 42) {
                break;
            } else {
                System.out.println(num);
            }
        }
    }
}
