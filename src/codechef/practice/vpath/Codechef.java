package codechef.practice.vpath;
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
	private static final int MOD = 1000_000_007;
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		InputReader ir = new InputReader(br);
		int t = ir.readInt();
		
		while(t-->0) {
			int n = ir.readInt();
			Node[] nodes = new Node[n+1];
			Map<Node, Integer> sum = new HashMap<>();
			Map<Integer, Integer> lr = new HashMap<>(); 
			lr.put(0, 0);
			lr.put(1, 0);
			for(int i = 0 ; i < n-1; i++) {
				int n1 = ir.firstInt();
				int n2 = ir.secondInt();
				if( nodes[n1] == null ) {
					nodes[n1] = new Node(n1);
				}
				if( nodes[n2] == null ) {
					nodes[n2] = new Node(n2);
				}
				nodes[n1].addNeighbour(nodes[n2]);
				nodes[n2].addNeighbour(nodes[n1]);
			}
			
			for(int i = 1; i < n ; i++) {
				Node node = nodes[i];
				
				if(sum.containsKey(node)) {
					continue;
				}
				dfs(sum, lr, node);
			}
			
			long result = n 
					+ lr.get(0) + lr.get(1);
			
			result = result % MOD;
			
			System.out.println(result);
			
		}
	}
	
	private static int dfs(Map<Node, Integer> sum, Map<Integer, Integer> lr, Node node) {
		if( sum.containsKey(node)) {
			return sum.get(node);
		}
		
		sum.put(node, 0);
		int clr = 1;
		int visited = 0;
		for(Node ne : node.neighbours) {
			if( sum.containsKey(ne)) continue;
			int dSum = dfs(sum, lr, ne) * 2 + 1;
			sum.computeIfPresent(node, (k,v)-> v+dSum);
			clr *= dSum;
			visited++;
		}
		
		if( visited > 1 ) {
			lr.put(1, (lr.get(1)+ clr*2));
		}
		
		lr.put(0, (lr.get(0) + sum.get(node)) );
		return sum.get(node);
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
