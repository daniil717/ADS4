import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Vertices
        Vertex<String> v1 = new Vertex<>("A");
        Vertex<String> v2 = new Vertex<>("B");
        Vertex<String> v3 = new Vertex<>("C");
        Vertex<String> v4 = new Vertex<>("D");

        //Edges
        v1.addAdjacentVertex(v2, 1);
        v1.addAdjacentVertex(v3, 4);
        v2.addAdjacentVertex(v3, 2);
        v2.addAdjacentVertex(v4, 5);
        v3.addAdjacentVertex(v4, 1);

        //Graph and vertices
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);

        //BFS
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, v1);
        System.out.print("BFS traversal starting from A: ");
        for (Vertex<String> vertex : bfs.pathTo(v4)) {
            System.out.print(vertex + " ");
        }
        System.out.println();

        //Dijkstra
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>(graph, v1);
        Map<Vertex<String>, Double> distances = dijkstra.getDistances();

        System.out.println("Dijkstra's shortest paths from A:");
        for (Map.Entry<Vertex<String>, Double> entry : distances.entrySet()) {
            System.out.println("Distance to " + entry.getKey() + " is " + entry.getValue());
        }
    }
}
