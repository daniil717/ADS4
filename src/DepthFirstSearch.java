public class DepthFirstSearch<T> extends Search<T> {

    public DepthFirstSearch(MyGraph<T> graph, Vertex<T> source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<T> graph, Vertex<T> current) {
        marked.add(current);

        for (Vertex<T> neighbor : graph.getAdjacentVertices(current).keySet()) {
            if (!marked.contains(neighbor)) {
                edgeTo.put(neighbor, current);
                dfs(graph, neighbor);
            }
        }
    }
}
