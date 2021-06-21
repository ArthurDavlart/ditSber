package duplicatessearcher;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class BruteForceDuplicatesSearcher<T> implements DuplicatesSearcher<T> {
    // O(n^2)
    @Override
    public Set<T> search(Collection<T> c1, Collection<T> c2) {
        Set<T> result = new HashSet<>();
        c1.forEach(element1 ->
            c2.forEach(element2 ->{
                if (element1 == element2){
                    result.add(element1);
                }
            }));
        return result;
    }
}
