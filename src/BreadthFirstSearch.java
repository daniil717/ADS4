import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(WeightedGraph<T> graph, Vertex<T> source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<T> graph, Vertex<T> current) {
        marked.add(current);

        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.remove();

            for (Vertex<T> vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
