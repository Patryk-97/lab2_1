package edu.iis.mto.bsearch;

import static edu.iis.mto.bsearch.IsNotFound.notFound;
import static edu.iis.mto.bsearch.IsPositionOf.positionOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private static int[] emptySeq = new int[0];
    private static int[] oneElementSeq = {1};
    private static int[] multipleElementSeq = {10, 20, 30, 40, 50};
    private static final int MULTIPLE_ELEMENT_SEQ_FIRST_POSITION = 0;
    private static final int MULTIPLE_ELEMENT_SEQ_MIDDLE_POSITION = multipleElementSeq.length / 2;
    private static final int MULTIPLE_ELEMENT_SEQ_LAST_POSITION = multipleElementSeq.length - 1;
    private static int[] seqOfSameElements = {100, 100, 100, 100, 100};
    private static final int SEQ_OF_SAME_ELEMENTS_MIDDLE_POSITION = seqOfSameElements.length / 2;
    private static int[] unorderedSeq = {500, 200, 100, 400, 300};
    private BinarySearch binarySearch;

    @BeforeEach
    void setup() {
        binarySearch = BinarySearch.create();
    }

    @Test
    void searchOneElementSeqWhichHasKeyTest() {
        int key = 1;
        SearchResult searchResult = binarySearch.search(key, oneElementSeq);
        assertThat(searchResult.isFound(), is(true));
        int position = searchResult.getPosition();
        assertThat(position, is(positionOf(0)));
        assertThat(key, is(equalTo(oneElementSeq[position])));
    }

    @Test
    void searchOneElementSeqWhichHasNotKeyTest() {
        int key = 2;
        SearchResult searchResult = binarySearch.search(key, oneElementSeq);
        assertThat(searchResult.isFound(), is(false));
        int position = searchResult.getPosition();
        assertThat(position, is(notFound()));
    }

    @Test
    void searchMultipleElementSeqWhichHasKeyInFirstPositionTest() {
        int key = 10;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertThat(searchResult.isFound(), is(true));
        int position = searchResult.getPosition();
        assertThat(position, is(positionOf(MULTIPLE_ELEMENT_SEQ_FIRST_POSITION)));
        assertThat(key, is(equalTo(multipleElementSeq[position])));
    }

    @Test
    void searchMultipleElementSeqWhichHasKeyInLastPositionTest() {
        int key = 50;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertThat(searchResult.isFound(), is(true));
        int position = searchResult.getPosition();
        assertThat(position, is(positionOf(MULTIPLE_ELEMENT_SEQ_LAST_POSITION)));
        assertThat(key, is(equalTo(multipleElementSeq[position])));
    }

    @Test
    void searchMultipleElementSeqWhichHasKeyInMiddlePositionTest() {
        int key = 30;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertThat(searchResult.isFound(), is(true));
        int position = searchResult.getPosition();
        assertThat(position, is(positionOf(MULTIPLE_ELEMENT_SEQ_MIDDLE_POSITION)));
        assertThat(key, is(equalTo(multipleElementSeq[position])));
    }

    @Test
    void searchMultipleElementSeqWhichHasNotKeyTest() {
        int key = 60;
        SearchResult searchResult = binarySearch.search(key, multipleElementSeq);
        assertThat(searchResult.isFound(), is(false));
        int position = searchResult.getPosition();
        assertThat(position, is(notFound()));
    }

    @Test
    void searchEmptySeqTest() {
        int key = 1;
        assertThrows(IllegalArgumentException.class, () -> binarySearch.search(key, emptySeq));
    }

    @Test
    void nullInsteadSeqTest() {
        int key = 1;
        assertThrows(NullPointerException.class, () -> binarySearch.search(key, null));
    }

    @Test
    void searchSeqOfSameElementsWhichHasKeyInMiddlePositionTest() {
        int key = 100;
        SearchResult searchResult = binarySearch.search(key, seqOfSameElements);
        assertThat(searchResult.isFound(), is(true));
        int position = searchResult.getPosition();
        assertThat(position, is(positionOf(SEQ_OF_SAME_ELEMENTS_MIDDLE_POSITION)));
        assertThat(key, is(equalTo(seqOfSameElements[position])));
    }

    @Test
    void searchElementWhichIsInUnorderedSeq() {
        int key = 500;
        SearchResult searchResult = binarySearch.search(key, unorderedSeq);
        assertThat(searchResult.isFound(), is(false));
        int position = searchResult.getPosition();
        assertThat(position, is(notFound()));
    }
}
