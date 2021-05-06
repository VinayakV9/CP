package codechef.practice.fence;
/* package codechef; // don't place package name! */

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		InputStream inputStream=System.in;
	    InputReader scan=new InputReader(inputStream);
	    
//		Scanner scan = new Scanner(System.in);
        String str[] = null;
        int t = scan.nextInt();
        
        StringBuilder result = new StringBuilder();
        while(t-->0) {
        	int n = scan.nextInt();
        	int m = scan.nextInt();
        	int k = scan.nextInt();
        	int n1 = n-1;
        	int m1 = m-1;
        	
        	boolean grid[][] = new boolean[n][m];
        	long fences = 0;
        	while(k-->0) {
        		int ri = scan.nextInt() - 1;
        		int ci = scan.nextInt() - 1;
        		
        		grid[ri][ci] = true;
        		long fenceToAdd = 4;
        		if(ri>0 && grid[ri-1][ci]) fenceToAdd -= 2;
        		if(ri<n1 && grid[ri+1][ci]) fenceToAdd -= 2;
        		if(ci>0 && grid[ri][ci-1]) fenceToAdd -= 2;
        		if(ci<m1 && grid[ri][ci+1]) fenceToAdd -=2;
        		
        		fences += fenceToAdd;
        	}
        	
        	result.append(fences+"\n");
        }
        System.out.print(result.toString());
	}
	

	  static class InputReader {
	    private boolean finished = false;

	    private InputStream stream;
	    private byte[] buf = new byte[1024];
	    private int curChar;
	    private int numChars;
	    private SpaceCharFilter filter;

	    public InputReader(InputStream stream) {
	      this.stream = stream;
	    }

	    public int read() {
	      if (numChars == -1) {
	        throw new InputMismatchException();
	      }
	      if (curChar >= numChars) {
	        curChar = 0;
	        try {
	          numChars = stream.read(buf);
	        } catch (IOException e) {
	          throw new InputMismatchException();
	        }
	        if (numChars <= 0) {
	          return -1;
	        }
	      }
	      return buf[curChar++];
	    }

	    public int peek() {
	      if (numChars == -1) {
	        return -1;
	      }
	      if (curChar >= numChars) {
	        curChar = 0;
	        try {
	          numChars = stream.read(buf);
	        } catch (IOException e) {
	          return -1;
	        }
	        if (numChars <= 0) {
	          return -1;
	        }
	      }
	      return buf[curChar];
	    }

	    public int nextInt() {
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      int sgn = 1;
	      if (c == '-') {
	        sgn = -1;
	        c = read();
	      }
	      int res = 0;
	      do {
	        if (c < '0' || c > '9') {
	          throw new InputMismatchException();
	        }
	        res *= 10;
	        res += c - '0';
	        c = read();
	      } while (!isSpaceChar(c));
	      return res * sgn;
	    }

	    public long nextLong() {
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      int sgn = 1;
	      if (c == '-') {
	        sgn = -1;
	        c = read();
	      }
	      long res = 0;
	      do {
	        if (c < '0' || c > '9') {
	          throw new InputMismatchException();
	        }
	        res *= 10;
	        res += c - '0';
	        c = read();
	      } while (!isSpaceChar(c));
	      return res * sgn;
	    }

	    public String nextLine() {
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      StringBuilder res = new StringBuilder();
	      do {
	        if (Character.isValidCodePoint(c)) {
	          res.appendCodePoint(c);
	        }
	        c = read();
	      } while (!isSpaceChar(c));
	      return res.toString();
	    }

	    public boolean isSpaceChar(int c) {
	      if (filter != null) {
	        return filter.isSpaceChar(c);
	      }
	      return isWhitespace(c);
	    }

	    public static boolean isWhitespace(int c) {
	      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	    }

	    private String readLine0() {
	      StringBuilder buf = new StringBuilder();
	      int c = read();
	      while (c != '\n' && c != -1) {
	        if (c != '\r') {
	          buf.appendCodePoint(c);
	        }
	        c = read();
	      }
	      return buf.toString();
	    }

	    public String readLine() {
	      String s = readLine0();
	      while (s.trim().length() == 0) {
	        s = readLine0();
	      }
	      return s;
	    }

	    public String readLine(boolean ignoreEmptyLines) {
	      if (ignoreEmptyLines) {
	        return readLine();
	      } else {
	        return readLine0();
	      }
	    }

	    public BigInteger readBigInteger() {
	      try {
	        return new BigInteger(nextLine());
	      } catch (NumberFormatException e) {
	        throw new InputMismatchException();
	      }
	    }

	    public char nextCharacter() {
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      return (char) c;
	    }

	    public double nextDouble() {
	      int c = read();
	      while (isSpaceChar(c)) {
	        c = read();
	      }
	      int sgn = 1;
	      if (c == '-') {
	        sgn = -1;
	        c = read();
	      }
	      double res = 0;
	      while (!isSpaceChar(c) && c != '.') {
	        if (c == 'e' || c == 'E') {
	          return res * Math.pow(10, nextInt());
	        }
	        if (c < '0' || c > '9') {
	          throw new InputMismatchException();
	        }
	        res *= 10;
	        res += c - '0';
	        c = read();
	      }
	      if (c == '.') {
	        c = read();
	        double m = 1;
	        while (!isSpaceChar(c)) {
	          if (c == 'e' || c == 'E') {
	            return res * Math.pow(10, nextInt());
	          }
	          if (c < '0' || c > '9') {
	            throw new InputMismatchException();
	          }
	          m /= 10;
	          res += (c - '0') * m;
	          c = read();
	        }
	      }
	      return res * sgn;
	    }

	    public boolean isExhausted() {
	      int value;
	      while (isSpaceChar(value = peek()) && value != -1) {
	        read();
	      }
	      return value == -1;
	    }

	    public String next() {
	      return nextLine();
	    }

	    public SpaceCharFilter getFilter() {
	      return filter;
	    }

	    public void setFilter(SpaceCharFilter filter) {
	      this.filter = filter;
	    }

	    public interface SpaceCharFilter {
	      public boolean isSpaceChar(int ch);
	    }
	    public int[] nextIntArray(int n){
	      int[] array=new int[n];
	      for(int i=0;i<n;++i)array[i]=nextInt();
	      return array;
	    }
	    public int[] nextSortedIntArray(int n){
	      int array[]=nextIntArray(n);
	      Arrays.sort(array);
	      return array;
	    }
	    public ArrayList<Integer> nextIntArrayList(int n){
	      ArrayList<Integer> ar= new ArrayList<>();
	      for(int i=0;i<n;i++)
	        ar.add(nextInt());
	      return ar;
	    }
			public ArrayList<Long> nextLongArrayList(int n){
	      ArrayList<Long> ar= new ArrayList<>();
	      for(int i=0;i<n;i++)
	        ar.add(nextLong());
	      return ar;
	    }

	    public int[] nextSumIntArray(int n){
	      int[] array=new int[n];
	      array[0]=nextInt();
	      for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
	      return array;
	    }
	    public long[] nextLongArray(int n){
	      long[] array=new long[n];
	      for(int i=0;i<n;++i)array[i]=nextLong();
	      return array;
	    }
	    public long[] nextSumLongArray(int n){
	      long[] array=new long[n];
	      array[0]=nextInt();
	      for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
	      return array;
	    }
	    public long[] nextSortedLongArray(int n){
	      long array[]=nextLongArray(n);
	      Arrays.sort(array);
	      return array;
	    }
	    public int[][] nextIntMatrix(int n,int m){
	      int[][] matrix=new int[n][m];
	      for(int i=0;i<n;++i)
	      for(int j=0;j<m;++j)
	      matrix[i][j]=nextInt();
	      return matrix;
	    }

	    public int[][] nextIntMatrix(int n){
	      return nextIntMatrix(n,n);
	    }

	    public long[][] nextLongMatrix(int n,int m){
	      long[][] matrix=new long[n][m];
	      for(int i=0;i<n;++i)
	      for(int j=0;j<m;++j)
	      matrix[i][j]=nextLong();
	      return matrix;
	    }

	    public long[][] nextLongMatrix(int n){
	      return nextLongMatrix(n,n);
	    }

	    public char[][] nextCharMatrix(int n,int m){
	      char[][] matrix=new char[n][m];
	      for(int i=0;i<n;++i)
	      matrix[i]=next().toCharArray();
	      return matrix;
	    }

	    public char[][] nextCharMatrix(int n){
	      return nextCharMatrix(n,n);
	    }
	  }

}
