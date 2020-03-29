package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private static final int[] oneElementSeq = {1};
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

}
