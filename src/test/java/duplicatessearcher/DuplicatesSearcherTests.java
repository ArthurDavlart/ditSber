package duplicatessearcher;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DuplicatesSearcherTests {

    @ParameterizedTest
    @MethodSource("generator")
    void when_firstCollectionAndSecondCollectionAreEmpty_expect_emptySet(
            DuplicatesSearcher<Integer> duplicatesSearcher){
        Collection<Integer> c1 = new ArrayList<>();
        Collection<Integer> c2 = new ArrayList<>();
        Set<Integer> expected = new HashSet<>();

        Collection<Integer> actual = duplicatesSearcher.search(c1, c2);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("generator")
    void when_HasNotDuplicatesInCollections_expect_emptySet(
            DuplicatesSearcher<Integer> duplicatesSearcher){
        Collection<Integer> c1 = new ArrayList<Integer>(){{add(1);}};
        Collection<Integer> c2 = new ArrayList<Integer>(){{add(2);}};
        Set<Integer> expected = new HashSet<>();

        Collection<Integer> actual = duplicatesSearcher.search(c1, c2);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("generator")
    void when_HasOneDuplicatesInCollections_expect_SetWithOneElement(
            DuplicatesSearcher<Integer> duplicatesSearcher){
        Collection<Integer> c1 = new ArrayList<Integer>(){{add(1);}};
        Collection<Integer> c2 = new ArrayList<Integer>(){{add(1);}};
        Set<Integer> expected = new HashSet<Integer>(){{add(1);}};

        Collection<Integer> actual = duplicatesSearcher.search(c1, c2);

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("generator")
    void when_HasTwoDuplicatesInCollections_expect_SetWithOneElement(
            DuplicatesSearcher<Integer> duplicatesSearcher){
        Collection<Integer> c1 = new ArrayList<Integer>(){{add(1);add(1);}};
        Collection<Integer> c2 = new ArrayList<Integer>(){{add(1);add(1);}};
        Set<Integer> expected = new HashSet<Integer>(){{add(1);}};

        Collection<Integer> actual = duplicatesSearcher.search(c1, c2);

        assertEquals(expected, actual);
    }

    private static Stream<DuplicatesSearcher<Integer>> generator() {

        return Stream.of(new BruteForceDuplicatesSearcher<>(),
                new HashSetDuplicatesSearcher<>());
                // Arguments.of(new BruteForceDuplicatesSearcher(..)),
                //Arguments.of(new BruteForceDuplicatesSearcher<Integer>()));
    }
}
