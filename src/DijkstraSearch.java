import java.util.*;

public class DijkstraSearch<T> {
    public Map<Vertex<T>, Double> dijkstra(Vertex<T> start) {
        Map<Vertex<T>, Double> distances = new HashMap<>();
        PriorityQueue<VertexDistance<T>> priorityQueue = new PriorityQueue<>(Comparator.comparingDouble(VertexDistance::getDistance));
        Set<Vertex<T>> visited = new HashSet<>();
        distances.put(start, 0.0);
        priorityQueue.add(new VertexDistance<>(start, 0.0));

        while (!priorityQueue.isEmpty()) {
            VertexDistance<T> current = priorityQueue.poll();
            Vertex<T> currentVertex = current.getVertex();

            if (visited.contains(currentVertex)) {
                continue;
            }
            visited.add(currentVertex);

            for (Map.Entry<Vertex<T>, Double> entry : currentVertex.getAdjacentVertices().entrySet()) {
                Vertex<T> neighbor = entry.getKey();
                double edgeWeight = entry.getValue();
                double newDist = distances.get(currentVertex) + edgeWeight;

                if (newDist < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                    distances.put(neighbor, newDist);
                    priorityQueue.add(new VertexDistance<>(neighbor, newDist));
                }
            }
        }
        return distances;
    }

    private static class VertexDistance<T> {
        private final Vertex<T> vertex;
        private final double distance;

        public VertexDistance(Vertex<T> vertex, double distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public Vertex<T> getVertex() {
            return vertex;
        }

        public double getDistance() {
            return distance;
        }
    }
}

