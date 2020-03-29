package edu.iis.mto.bsearch;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class IsNotFound extends TypeSafeMatcher<Integer> {

    private static final int NOT_FOUND = -1;

    @Override
    public boolean matchesSafely(Integer position) {
        return position.equals(NOT_FOUND);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(String.valueOf(NOT_FOUND));
    }

    public static Matcher<Integer> notFound() {
        return new IsNotFound();
    }
}
