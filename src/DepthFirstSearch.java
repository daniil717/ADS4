import java.util.HashSet;
import java.util.Stack;

public class DepthFirstSearch<T> extends Search<T> {
    public DepthFirstSearch(MyGraph<T> graph, Vertex<T> source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<T> graph, Vertex<T> current) {
        marked.add(current);

        Stack<Vertex<T>> stack = new Stack<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            Vertex<T> v = stack.pop();

            for (Vertex<T> vertex : graph.getAdjacentVertices(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    stack.push(vertex);
                }
            }
        }
    }
}
