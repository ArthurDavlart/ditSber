package duplicatessearcher;

import java.util.Collection;
import java.util.Set;

public interface DuplicatesSearcher<T> {
    Set<T> search(Collection<T> c1, Collection<T> c2);
}
