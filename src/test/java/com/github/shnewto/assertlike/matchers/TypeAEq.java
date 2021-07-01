package com.github.shnewto.assertlike.matchers;

import com.github.shnewto.assertlike.types.TypeA;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.github.shnewto.assertlike.matchers.CharSequenceMapEq.compareCharSequenceMap;

public class TypeAEq  extends TypeSafeMatcher<TypeA> {
    private final TypeA typeA;

    public TypeAEq(TypeA typeA) {
        this.typeA = typeA;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("TypeA Equality");
    }

    @Override
    protected boolean matchesSafely(TypeA typeA) {

        if (this.typeA.integerVal != typeA.integerVal) {
            return false;
        }

        if (this.typeA.stringVal != typeA.stringVal) {
            return false;
        }

        if (this.typeA.utf8Val != typeA.utf8Val) {
            return false;
        }

        if(!compareCharSequenceMap(this.typeA.charSequenceMap, typeA.charSequenceMap)) {
            return false;
        }

        return true;
    }

    public static TypeAEq typeAEq(TypeA typeA) {
        return new TypeAEq(typeA);
    }
}
