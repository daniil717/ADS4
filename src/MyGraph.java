import java.util.*;

public class MyGraph<T> {
    private Map<Vertex<T>, List<Vertex<T>>> adjList;

    public MyGraph() {
        adjList = new HashMap<>();
    }

    public void addVertex(Vertex<T> vertex) {
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(Vertex<T> source, Vertex<T> dest) {
        adjList.get(source).add(dest);
        adjList.get(dest).add(source); // Assuming undirected graph
    }

    public List<Vertex<T>> getAdjacentVertices(Vertex<T> vertex) {
        return adjList.getOrDefault(vertex, Collections.emptyList());
    }

    public Set<Vertex<T>> getVertices() {
        return adjList.keySet();
    }
}

