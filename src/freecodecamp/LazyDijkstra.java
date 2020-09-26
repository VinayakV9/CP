package freecodecamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LazyDijkstra {
    public static void main(String[] args) throws IOException {
        //Input readers
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

//        start target dist
        String s;

        int sentinelNode = -1;
        Map<Integer, List<Edge>> graph = new HashMap<>();

        int t = Integer.parseInt(br.readLine());
        while( t--> 0 && (s = br.readLine()) != null && !s.isEmpty() ){
            String[] arr = s.split(" ");
            int source = Integer.parseInt(arr[0]);
            int target = Integer.parseInt(arr[1]);
            int dist = Integer.parseInt(arr[2]);

            Edge edge = new Edge(source, target, dist);

            graph.computeIfAbsent(source, (sn)-> new LinkedList<>());
            graph.computeIfAbsent(target, (sn)-> new LinkedList<>());
            graph.get(source).add(edge);
        }

        Map<Integer, Integer> bestDistForNode = graph.entrySet().stream()
                .map(Map.Entry::getKey)
                .collect(Collectors.toMap(Function.identity(), (v)->Integer.MAX_VALUE));

        int source = Integer.parseInt(br.readLine());

        Queue<Edge> queue = new PriorityQueue<>(Comparator.comparing(Edge::getDistance));

        Set<Integer> visited = new HashSet<>();

        bestDistForNode.put(sentinelNode, 0);
        queue.add(new Edge(sentinelNode ,source, 0));

        Edge edge;
        while( (edge = queue.poll()) != null ){
            if( visited.contains(edge.getTarget())){
                continue;
            } else{
                visited.add(edge.getTarget());
            }

            int newDistance = bestDistForNode.get(edge.getSource()) + edge.getDistance();
            if( newDistance < bestDistForNode.get(edge.getTarget())){
                bestDistForNode.put(edge.getTarget(), newDistance);
            }

            queue.addAll(graph.get(edge.target));
        }

        bestDistForNode.entrySet()
                .stream()
                .map(entry-> "Node: "+entry.getKey()+", Dist: "+entry.getValue())
                .forEach(System.out::println);
    }

    static class Edge{
        private int source;
        private int target;
        private int distance;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return source == edge.source &&
                    target == edge.target &&
                    distance == edge.distance;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, target, distance);
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getTarget() {
            return target;
        }

        public void setTarget(int target) {
            this.target = target;
        }

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Edge(int source, int target, int distance) {
            this.source = source;
            this.target = target;
            this.distance = distance;
        }
    }
}
