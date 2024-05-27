public class Main {

    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>();
        fillWithWeights(weightedGraph);

        System.out.println("Dijkstra:");
        DijkstraSearch<String> djk = new DijkstraSearch<>(weightedGraph, new Vertex<>("Almaty"));
        outputPath(djk, new Vertex<>("Kyzylorda"));


        System.out.println("--------------------------------");

        MyGraph<String> graph = new MyGraph<>();
        fillWithoutWeights(graph);

        System.out.println("DFS:");
        DepthFirstSearch<String> dfs = new DepthFirstSearch<>(graph, new Vertex<>("Almaty"));
        outputPath(dfs, new Vertex<>("Kyzylorda"));

        System.out.println("--------------------------------");

        System.out.println("BFS:");
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>(graph, new Vertex<>("Almaty"));
        outputPath(bfs, new Vertex<>("Kyzylorda"));
    }

    public static void fillWithoutWeights(MyGraph<String> graph) {
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> atyrau = new Vertex<>("Atyrau");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addVertex(almaty);
        graph.addVertex(astana);
        graph.addVertex(shymkent);
        graph.addVertex(atyrau);
        graph.addVertex(kostanay);
        graph.addVertex(kyzylorda);

        graph.addEdge(almaty, astana);
        graph.addEdge(shymkent, atyrau);
        graph.addEdge(atyrau, astana);
        graph.addEdge(almaty, shymkent);
        graph.addEdge(shymkent, astana);
        graph.addEdge(astana, kostanay);
        graph.addEdge(shymkent, kyzylorda);
    }

    public static void fillWithWeights(WeightedGraph<String> graph) {
        Vertex<String> almaty = new Vertex<>("Almaty");
        Vertex<String> astana = new Vertex<>("Astana");
        Vertex<String> shymkent = new Vertex<>("Shymkent");
        Vertex<String> atyrau = new Vertex<>("Atyrau");
        Vertex<String> kostanay = new Vertex<>("Kostanay");
        Vertex<String> kyzylorda = new Vertex<>("Kyzylorda");

        graph.addVertex(almaty);
        graph.addVertex(astana);
        graph.addVertex(shymkent);
        graph.addVertex(atyrau);
        graph.addVertex(kostanay);
        graph.addVertex(kyzylorda);

        graph.addEdge(almaty, astana, 2.1);
        graph.addEdge(shymkent, atyrau, 7.8);
        graph.addEdge(atyrau, astana, 7.1);
        graph.addEdge(almaty, shymkent, 7.2);
        graph.addEdge(shymkent, astana, 3.9);
        graph.addEdge(astana, kostanay, 3.5);
        graph.addEdge(shymkent, kyzylorda, 5.4);
    }

    public static void outputPath(Search<String> search, Vertex<String> key) {
        for (Vertex<String> v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }

        System.out.println();
    }
}
