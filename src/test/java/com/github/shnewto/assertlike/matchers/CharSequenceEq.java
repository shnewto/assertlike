package com.github.shnewto.assertlike.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class CharSequenceEq extends TypeSafeMatcher<CharSequence> {

    private final CharSequence charSequence;

    public CharSequenceEq(CharSequence charSequence) {
        this.charSequence = charSequence;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("CharSequence Equality");
    }

    public static boolean compareCharSequence(CharSequence a, CharSequence b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.toString() != b.toString()) {
            return false;
        }

        return true;
    }

    @Override
    protected boolean matchesSafely(CharSequence charSequence) {
        return compareCharSequence(this.charSequence, charSequence);
    }

    public static CharSequenceEq charSequenceEq(CharSequence charSequence) {
        return new CharSequenceEq(charSequence);
    }
}