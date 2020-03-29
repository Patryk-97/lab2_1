package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private static int[] emptySeq = new int[0];
    private static int[] oneElementSeq = {1};
    private static int[] multipleElementSeq = {10, 20, 30, 40, 50};
    private static final int MULTIPLE_ELEMENT_SEQ_FIRST_POSITION = 0;
    private static final int MULTIPLE_ELEMENT_SEQ_MIDDLE_POSITION = multipleElementSeq.length / 2;
    private static final int MULTIPLE_ELEMENT_SEQ_LAST_POSITION = multipleElementSeq.length - 1;
    private BinarySearch binarySearch;
    private static final int NOT_FOUND = -1;

    @BeforeEach
    void setup() {
        binarySearch = BinarySearch.create();
    }

    @Test
    void oneElementSeqWhichHasKeyTest() {
        int key = 1;
        SearchResult searchResult = binarySearch.search(key, oneElementSeq);
        assertTrue(searchResult.isFound());
        int position = searchResult.getPosition();
        assertEquals(position, 0);
        assertEquals(key, oneElementSeq[position]);
    }

    @Test
    void oneElementSeqWhichHasNotKeyTest() {
        int key = 2;
        SearchResult searchResult = binarySearch.search(key, oneElementSeq);
        assertFalse(searchResult.isFound());
        int position = searchResult.getPosition();
        assertEquals(position, NOT_FOUND);
    }

    @Test
    void multipleElementSeqWhichHasKeyInFirstPositionTest() {
        int key = 10;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertTrue(searchResult.isFound());
        int position = searchResult.getPosition();
        assertEquals(position, MULTIPLE_ELEMENT_SEQ_FIRST_POSITION);
        assertEquals(key, multipleElementSeq[position]);
    }

    @Test
    void multipleElementSeqWhichHasKeyInLastPositionTest() {
        int key = 50;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertTrue(searchResult.isFound());
        int position = searchResult.getPosition();
        assertEquals(position, MULTIPLE_ELEMENT_SEQ_LAST_POSITION);
        assertEquals(key, multipleElementSeq[position]);
    }

    @Test
    void multipleElementSeqWhichHasKeyInMiddlePositionTest() {
        int key = 30;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertTrue(searchResult.isFound());
        int position = searchResult.getPosition();
        assertEquals(position, MULTIPLE_ELEMENT_SEQ_MIDDLE_POSITION);
        assertEquals(key, multipleElementSeq[position]);
    }

    @Test
    void multipleElementSeqWhichHasNotKeyTest() {
        int key = 60;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertFalse(searchResult.isFound());
        int position = searchResult.getPosition();
        assertEquals(position, NOT_FOUND);
    }

    @Test
    void emptySeqTest() {
        int key = 1;
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(key, emptySeq));
    }

    @Test
    void nullInsteadSeqTest() {
        int key = 1;
        assertThrows(NullPointerException.class, () -> binarySearch.search(key, null));
    }
}
