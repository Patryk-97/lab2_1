package edu.iis.mto.bsearch;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsPositionOf extends TypeSafeMatcher<Integer> {

    private int position;

    public IsPositionOf(int position) {
        this.position = position;
    }

    @Override
    public boolean matchesSafely(Integer position) {
        return position.equals(this.position);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(String.valueOf(position));
    }

    public static Matcher<Integer> positionOf(Integer position) {
        return new IsPositionOf(position);
    }
}
