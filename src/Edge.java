import java.util.Objects;

public class Edge<T> {
    private Vertex<T> source;
    private Vertex<T> dest;
    private Double weight;

    public Edge(Vertex<T> source, Vertex<T> dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex<T> getSource() {
        return source;
    }

    public Vertex<T> getDest() {
        return dest;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(dest, edge.dest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, dest);
    }
}

