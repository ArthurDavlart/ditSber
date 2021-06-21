package customiterator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomArrayIteratorTests {
    @Test
    void when_collectionIsNull_expect_hasNext_returnFalse(){
        CustomArrayIterator customArrayIterator = new CustomArrayIterator(null);

        boolean actual = customArrayIterator.hasNext();

        assertFalse(actual);
    }

    @Test
    void when_collectionIsEmpty_expect_hasNext_returnFalse(){
        Integer[][] testData = {};
        CustomArrayIterator customArrayIterator = new CustomArrayIterator(testData);

        boolean actual = customArrayIterator.hasNext();

        assertFalse(actual);
    }

    @Test
    void when_emptyArrayInCollection_expect_hasNext_returnFalse(){
        Integer[][] testData = {{}};
        CustomArrayIterator customArrayIterator = new CustomArrayIterator(testData);

        boolean actual = customArrayIterator.hasNext();

        assertFalse(actual);
    }

    @Test
    void when_collectionHasOneDimensionalArray_expect_walkThroughEntireArray(){
        Integer[][] testData = {{1, 3}};
        CustomArrayIterator<Integer> customArrayIterator = new CustomArrayIterator<>(testData);

        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][0], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][1], customArrayIterator.next());
        assertFalse(customArrayIterator.hasNext());
    }

    @Test
    void when_collectionHasTwoArrayFirstHasOneElementSecondIsEmpty_expect_walkThroughEntireArray(){
        Integer[][] testData = {{1}, {}};
        CustomArrayIterator<Integer> customArrayIterator = new CustomArrayIterator<>(testData);

        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][0], customArrayIterator.next());
        assertFalse(customArrayIterator.hasNext());
    }

    @Test
    void when_collectionHasTwoArrayFirstIsEmptySecondHasOneElement_expect_walkThroughEntireArray(){
        Integer[][] testData = {{}, {1}};
        CustomArrayIterator<Integer> customArrayIterator = new CustomArrayIterator<>(testData);

        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[1][0], customArrayIterator.next());
        assertFalse(customArrayIterator.hasNext());
    }

    @Test
    void when_collectionHasThreeArrayFirstAndThirdHasOneElementSecondIsEmpty_expect_walkThroughEntireArray(){
        Integer[][] testData = {{1}, {}, {2}};
        CustomArrayIterator<Integer> customArrayIterator = new CustomArrayIterator<>(testData);

        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][0], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[2][0], customArrayIterator.next());
        assertFalse(customArrayIterator.hasNext());
    }

    @Test
    void when_collectionHasFourArrayFirstAndFourthHasOneElementSecondAnsThirdIsEmpty_expect_walkThroughEntireArray(){
        Integer[][] testData = {{1}, {}, {}, {2}};
        CustomArrayIterator<Integer> customArrayIterator = new CustomArrayIterator<>(testData);

        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][0], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[3][0], customArrayIterator.next());
        assertFalse(customArrayIterator.hasNext());
    }

    @Test
    void when_collectionHasTwoArraysBothHasTwoElements_expect_walkThroughEntireArray(){
        Integer[][] testData = {{1, 2}, {3, 4}};
        CustomArrayIterator<Integer> customArrayIterator = new CustomArrayIterator<>(testData);

        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][0], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][1], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[1][0], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[1][1], customArrayIterator.next());
        assertFalse(customArrayIterator.hasNext());
    }

    @Test
    void when_collectionHasTwoArraysFirstHasOneElementSecondHasTwoElements_expect_walkThroughEntireArray(){
        Integer[][] testData = {{1}, {3, 4}};
        CustomArrayIterator<Integer> customArrayIterator = new CustomArrayIterator<>(testData);

        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[0][0], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[1][0], customArrayIterator.next());
        assertTrue(customArrayIterator.hasNext());
        assertEquals(testData[1][1], customArrayIterator.next());
        assertFalse(customArrayIterator.hasNext());
    }
}
