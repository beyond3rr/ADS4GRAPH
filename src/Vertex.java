import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class Vertex<T> {
    private T data;
    private Map<Vertex<T>, Double> adjacentVertices;

    public Vertex(T data){
        this.data = data;
        this.adjacentVertices = new HashMap<>();
    }
    // getters&setters constructors
    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }


    public Map<Vertex<T>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void addAdjacentVertex(Vertex<T> vertex, double weight) {
        adjacentVertices.put(vertex, weight);
    }
    // equals
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }
}