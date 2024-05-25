import java.util.*;

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
}
