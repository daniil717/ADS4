import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeightedGraph<T> {
    private Set<Vertex<T>> vertices;

    public WeightedGraph() {
        this.vertices = new HashSet<>();
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public Set<Vertex<T>> getVertices() {
        return vertices;
    }

    public Set<Vertex<T>> adjacencyList(Vertex<T> vertex) {
        return vertex.getAdjacentVertices().keySet();
    }

    public Set<Map.Entry<Vertex<T>, Double>> getEdges(Vertex<T> vertex) {
        return vertex.getAdjacentVertices().entrySet();
    }
}
