import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private Map<Vertex<T>, Map<Vertex<T>, Double>> adjList;
    private boolean directed;

    public WeightedGraph() {
        this(false);
    }

    public WeightedGraph(boolean directed) {
        this.directed = directed;
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new HashMap<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest, double weight) {
        addVertex(source);
        addVertex(dest);
        adjList.get(source).put(dest, weight);
        if (!directed) {
            adjList.get(dest).put(source, weight);
        }
    }

    public Set<Vertex<T>> getVertices() {
        return adjList.keySet();
    }

    public Set<Vertex<T>> adjacencyList(Vertex<T> vertex) {
        return adjList.getOrDefault(vertex, new HashMap<>()).keySet();
    }

    public Map<Vertex<T>, Double> getEdges(Vertex<T> vertex) {
        return adjList.getOrDefault(vertex, new HashMap<>());
    }
}
