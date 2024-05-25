import java.util.*;

public class DijkstraSearch<T> extends Search<T> {
    private final Set<Vertex<T>> unsettledNodes;
    private final Map<Vertex<T>, Double> distances;
    private final WeightedGraph<T> graph;

    public DijkstraSearch(WeightedGraph<T> graph, T sourceData) {
        super((T) graph.getVertex(sourceData));
        this.graph = graph;
        this.unsettledNodes = new HashSet<>();
        this.distances = new HashMap<>();
        dijkstra();
    }

    public void dijkstra() {
        distances.put((Vertex<T>) source, 0D);
        unsettledNodes.add((Vertex<T>) source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<T> currentNode = getVertexWithMinimumWeight(unsettledNodes);

            marked.add((T) currentNode);
            unsettledNodes.remove(currentNode);

            for (Vertex<T> neighbor : graph.adjacencyList(currentNode)) {
                double newDistance = getShortestDistance(currentNode) + getDistance(currentNode, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put((T) neighbor, (T) currentNode); // inverted adding
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }

    private double getDistance(Vertex<T> node, Vertex<T> target) {
        for (Map.Entry<Vertex<T>, Double> entry : node.getAdjacentVertices().entrySet()) {
            if (entry.getKey().equals(target)) {
                return entry.getValue();
            }
        }
        return Double.MAX_VALUE;
    }

    private double getShortestDistance(Vertex<T> destination) {
        return distances.getOrDefault(destination, Double.MAX_VALUE);
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;
        for (Vertex<T> vertex : vertices) {
            if (minimum == null || getShortestDistance(vertex) < getShortestDistance(minimum))
                minimum = vertex;
        }
        return minimum;
    }
}
