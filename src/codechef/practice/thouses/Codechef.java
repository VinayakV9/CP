package codechef.practice.thouses;
/* package codechef; // don't place package name! */



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef {
	private static long MOD = 1000_000_007;

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		InputReader ir = new InputReader(br);

		int t = ir.readInt();

		StringBuilder result = new StringBuilder();
		while (t-- > 0) {
			int e = ir.firstInt();
			long x = ir.secondInt();

			Map<Integer, Node> graph = new HashMap<>();

			e--;
			while (e-- > 0) {
				int k1 = ir.firstInt();
				int k2 = ir.secondInt();
				graph.putIfAbsent(k1, new Node(k1));
				graph.putIfAbsent(k2, new Node(k2));

				Node n1 = graph.get(k1);
				Node n2 = graph.get(k2);

				n1.addNeighbour(n2);
				n2.addNeighbour(n1);
			}

			decendent(graph.get(1), new HashSet<>());

			
			
			long sum = 0;
			Map<Node, Long> nodesXValue = new HashMap<>();
			nodesXValue.put(graph.get(1), x);
			Queue<Node> queue = new LinkedList<>();
			Set<Node> visited = new HashSet<>();

			visited.add(graph.get(1));
			queue.add(graph.get(1));
			Collections.sort(graph.get(1).neighbours,
					Comparator.comparing(Node::getDecendents).reversed());
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				long xValue = nodesXValue.get(node);
				sum += xValue;
				sum %= MOD;

				List<Node> list = node.neighbours;
				if (list.size() > 2)
					Collections.sort(list,
							Comparator.comparing(Node::getDecendents).reversed()
							.thenComparing(Node::getDecendents2)
							);

				int i = 1;
				for (Node d : list) {
					if (!visited.contains(d)) {
						nodesXValue.put(d, xValue * i++);
						queue.add(d);
						visited.add(d);
					}
				}
			}

//			graph.values().stream().forEach(no-> System.out.println(no.key+" : "+no.getDecendents()+" : "+nodesXValue.get(no)));
			
			result.append(sum + "\n");
		}

		System.out.print(result.toString());
	}

	private static long decendent(Node node, final Set<Node> visited) {
		visited.add(node);
		long decendents = 0;
		long decendents2 = 0;
		for(Node d : node.neighbours) {
			if( !visited.contains(d)) {
				decendents += decendent(d, visited);
				decendents2 += d.decendents2;
			}
		}	
		decendents %= MOD;

		node.decendents = decendents;
		node.decendents2 = decendents2 + ((node.neighbours.size()>2)?node.neighbours.size()-2:0);
		return node.decendents + 1;
	}

	private static class InputReader {
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
			for (int i = 0; i < nums.length; i++)
				nums[i] = Integer.parseInt(str[i]);
			return nums;
		}

		public long[] readLongs() throws IOException {
			String str[] = readLine().split(" ");
			long[] nums = new long[str.length];
			for (int i = 0; i < nums.length; i++)
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

	private static class Node {
		final int key;
		long decendents;
		long decendents2;
		List<Node> neighbours;

		public int getKey() {
			return this.key;
		}

		public long getDecendents() {
			return this.decendents;
		}

		public long getDecendents2() {
			return this.decendents2;
		}

		public Node(int key) {
			this.key = key;
			this.decendents = 0;
			this.neighbours = new LinkedList<>();
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
