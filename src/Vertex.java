import java.util.HashMap;
import java.util.Map;
public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex<T data>{
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }

    public T getData() {
        return data;
    }

    public void addAdjacentVertex(Vertex<T> vertex, double weight) {
        adjacentVertices.put(vertex, weight);
    }

    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
