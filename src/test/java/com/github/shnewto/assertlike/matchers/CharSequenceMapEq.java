package com.github.shnewto.assertlike.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.github.shnewto.assertlike.matchers.CharSequenceEq.compareCharSequence;

public class CharSequenceMapEq extends TypeSafeMatcher<Map<CharSequence, CharSequence>> {

    private final Map<CharSequence, CharSequence> charSequenceMap;

    public CharSequenceMapEq(Map<CharSequence, CharSequence> charSequenceMap) {
        this.charSequenceMap = charSequenceMap;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("Map<CharSequence,CharSequence> Equality");
    }

    public static boolean compareCharSequenceMap(Map<CharSequence, CharSequence> a, Map<CharSequence, CharSequence> b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        List<CharSequence> keysA  = a.keySet().stream().sorted().collect(Collectors.toList());
        List<CharSequence> keysB = b.keySet().stream().sorted().collect(Collectors.toList());

        if (keysA.size() != keysB.size()) {
            return false;
        }

        for(int i = 0; i < keysA.size(); i++) {
            CharSequence keyA = keysA.get(i);
            CharSequence keyB = keysB.get(i);

            if(keyA.toString() != keyB.toString()){
                return false;
            }

            if(!compareCharSequence(a.get(keyA), b.get(keyB))){
                return false;
            }
        }

        return true;
    }

    @Override
    protected boolean matchesSafely(Map<CharSequence, CharSequence> charSequenceMap) {
        return compareCharSequenceMap(this.charSequenceMap, charSequenceMap);
    }

    public static CharSequenceMapEq charSequenceMapEq(Map<CharSequence, CharSequence> charSequenceMap) {
        return new CharSequenceMapEq(charSequenceMap);
    }
}
