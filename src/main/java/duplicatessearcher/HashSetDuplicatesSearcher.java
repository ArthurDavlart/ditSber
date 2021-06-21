package duplicatessearcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class HashSetDuplicatesSearcher<T> implements DuplicatesSearcher<T> {
    // O(n)
    @Override
    public Set<T> search(Collection<T> c1, Collection<T> c2) {
        Set<T> uniques = new HashSet<>(c1);
        return c2.stream()
                .filter(e -> !uniques.add(e))
                .collect(Collectors.toSet());
    }
}
