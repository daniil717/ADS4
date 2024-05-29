import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<T> extends Search<T> {
    public BreadthFirstSearch(MyGraph<T> graph, Vertex<T> source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<T> graph, Vertex<T> current) {
        marked.add(current);

        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.remove();

            for (Vertex<T> neighbor : graph.getAdjacentVertices(v).keySet()) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    edgeTo.put(neighbor, v);
                    queue.add(neighbor);
                }
            }
        }
    }
}
