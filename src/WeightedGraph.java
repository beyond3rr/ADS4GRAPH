import java.util.*;

public class WeightedGraph<T> {
    private final Map<T, Vertex<T>> vertices;
    private final boolean undirected;

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    public void addVertex(T data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(T sourceData, T destData, double weight) {
        addVertex(sourceData);
        addVertex(destData);
        Vertex<T> source = vertices.get(sourceData);
        Vertex<T> dest = vertices.get(destData);
        source.addAdjacentVertex(dest, weight);

        if (undirected) {
            dest.addAdjacentVertex(source, weight);
        }
    }

    public Vertex<T> getVertex(T data) {
        return vertices.get(data);
    }

    public List<Vertex<T>> adjacencyList(Vertex<T> v) {
        List<Vertex<T>> adjVertices = new ArrayList<>();
        for (Vertex<T> adj : v.getAdjacentVertices().keySet()) {
            adjVertices.add(adj);
        }
        return adjVertices;
    }
}
