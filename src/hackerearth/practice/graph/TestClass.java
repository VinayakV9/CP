package hackerearth.practice.graph;

//imports for BufferedReader
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        InputReader ir = new InputReader(br);
        int v = ir.firstInt();
        int e = ir.secondInt();
        
        Map<Integer, WNode> graph = Arrays.stream(ir.readIntegers())
        	.mapToObj(WNode::new)
        	.collect(Collectors.toMap(WNode::getKey, Function.identity()));
        
        while(e-->0) {
        	WNode n1 = graph.get(ir.firstInt());
        	WNode n2 = graph.get(ir.secondInt());
        	
        	n1.addNeighbour(n2, ir.thirdInt());
        }
        
        final StringBuilder result = new StringBuilder();
        graph.values().stream()
        	.forEach(node->{
        		String neighbours = node.neighbours.entrySet().stream()
        		.map(entry-> entry.getKey().getKey()+":"+entry.getValue())
				.collect(Collectors.joining(" "));
        		result.append(node.getKey()+" - "+neighbours+"\n");
        	});
        
        System.out.println(result.toString());
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
