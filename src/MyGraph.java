import java.util.HashMap;
import java.util.Map;

public class MyGraph<T> {
    private Map<Vertex<T>, Map<Vertex<T>, Double>> adjList;

    public MyGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest) {
        addVertex(source);
        addVertex(dest);
        adjList.get(source).put(dest, 1.0); // default weight for unweighted edge
    }

    public Map<Vertex<T>, Double> getAdjacentVertices(Vertex<T> vertex) {
        return adjList.getOrDefault(vertex, new HashMap<>());
    }
}
