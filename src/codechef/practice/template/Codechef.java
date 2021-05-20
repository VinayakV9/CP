package codechef.practice.template;
/* package codechef; // don't place package name! */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
		InputReader ir = new InputReader(br);
		
		
	}
	private static class InputReader{
    	private BufferedReader br;
    	private int[] integers;
    	public InputReader(BufferedReader br) {
    		this.br = br;
    	}
    	
    	public String readLine() throws IOException {
    		return br.readLine();
    	}
    	
    	public int readInt() throws NumberFormatException, IOException {
    		return Integer.parseInt(readLine());
    	}
    	
    	public int[] readIntegers() throws IOException {
    		String str[] = readLine().split(" ");
    		int[] nums = new int[str.length];
    		for(int i = 0; i < nums.length; i++)
    			nums[i] = Integer.parseInt(str[i]);
    		return nums;
    	}
    	
    	public long[] readLongs() throws IOException {
    		String str[] = readLine().split(" ");
    		long[] nums = new long[str.length];
    		for(int i = 0; i < nums.length; i++)
    			nums[i] = Long.parseLong(str[i]);
    		return nums;
    	}
    	
    	public int firstInt() throws IOException {
    		integers = readIntegers();
    		return integers[0];
    	}
    	public int secondInt() {
    		return integers[1];
    	}
    	public int thirdInt() {
    		return integers[2];
    	}
    }
    
    private static class WNode{
    	final int key;
    	Map<WNode, Integer> neighbours;
    	
    	public WNode(int key) {
    		this.key = key;
    		this.neighbours = new HashMap<>();
		}
    	
    	public void addNeighbour(WNode n, int weight) {
    		neighbours.put(n, weight);
    	}

		public int getKey() {
			return key;
		}
    }
    
    private static class Node {
    	final int key;
    	Set<Node> neighbours;
    	
    	public int getKey() {
    		return this.key;
    	}
    	
    	public Node(int key) {
    		this.key = key;
    		this.neighbours = new HashSet<>();
    	}
    	
    	public void addNeighbour(Node n) {
    		this.neighbours.add(n);
    	}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + key;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (key != other.key)
				return false;
			return true;
		}
    	
    	
    }
}
