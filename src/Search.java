import java.util.*;

public class Search<T> {
    protected Set<T> marked;
    protected Map<T, T> edgeTo;
    protected final T source;

    public Search(T source) {
        this.source = source;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(T v) {
        return marked.contains(v);
    }

    public Iterable<T> pathTo(T v) {
        if (!hasPathTo(v)) return Collections.emptyList(); // Return an empty iterable if no path exists

        LinkedList<T> ls = new LinkedList<>();
        for (T i = v; i != source; i = edgeTo.get(i)) {
            ls.push(i); // inverted adding
        }
        ls.push(source);
        return ls;
    }
}
