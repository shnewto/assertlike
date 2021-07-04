package com.github.shnewto.assertlike.matchers;

import com.github.shnewto.assertlike.types.ClassWithCharSequenceMap;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import static com.github.shnewto.assertlike.matchers.CharSequenceMapEq.compareCharSequenceMap;

public class ClassWithCharSequenceMapEq extends TypeSafeMatcher<ClassWithCharSequenceMap> {
    private final ClassWithCharSequenceMap classWithCharSequenceMap;

    public ClassWithCharSequenceMapEq(ClassWithCharSequenceMap classWithCharSequenceMap) {
        this.classWithCharSequenceMap = classWithCharSequenceMap;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("TypeA Equality");
    }

    @Override
    protected boolean matchesSafely(ClassWithCharSequenceMap classWithCharSequenceMap) {

        if(!compareCharSequenceMap(this.classWithCharSequenceMap.charSequenceMap, classWithCharSequenceMap.charSequenceMap)) {
            return false;
        }

        return true;
    }

    public static ClassWithCharSequenceMapEq typeAEq(ClassWithCharSequenceMap classWithCharSequenceMap) {
        return new ClassWithCharSequenceMapEq(classWithCharSequenceMap);
    }
}
