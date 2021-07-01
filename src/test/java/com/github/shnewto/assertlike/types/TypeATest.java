package com.github.shnewto.assertlike.types;

import org.apache.avro.util.Utf8;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import static com.github.shnewto.assertlike.matchers.CharSequenceEq.charSequenceEq;
import static com.github.shnewto.assertlike.matchers.CharSequenceMapEq.charSequenceMapEq;
import static com.github.shnewto.assertlike.matchers.TypeAEq.typeAEq;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class TypeATest {

    @Test
    void assertEqualityOfAnInternalJavaStringAndAnInternalAvroUtf8CharSequence() {
        // The smallest palindromic beastly prime
        Integer integerVal = 16661;
        Utf8 utf8Val = new Utf8("16661");
        String stringVal = "16661";
        Map<CharSequence, CharSequence> utf8Map = new HashMap<>();
        utf8Map.put("a", "0");
        utf8Map.put("b", "1");
        utf8Map.put("c", "2");
        utf8Map.put("d", "3");

        Map<CharSequence, CharSequence> stringMap = new HashMap<>();
        stringMap.put("a", "0");
        stringMap.put("b", "1");
        stringMap.put("c", "2");
        stringMap.put("d", "3");

        TypeA typeAWithAvroCharSequence = TypeA.builder()
                .integerVal(integerVal)
                .utf8Val(utf8Val)
                .stringVal(stringVal)
                .charSequenceMap(utf8Map)
                .build();

        TypeA typeAWithJavaStringCharSequence = TypeA.builder()
                .integerVal(integerVal)
                .utf8Val(utf8Val)
                .stringVal(stringVal)
                .charSequenceMap(stringMap)
                .build();

        assertThat(typeAWithAvroCharSequence, is(equalTo(typeAWithJavaStringCharSequence)));
    }

    @Test
    void assertCustomEqualityOfAnInternalJavaStringAndAnInternalAvroUtf8CharSequence() {
        // The smallest palindromic beastly prime
        Integer integerVal = 16661;
        Utf8 utf8Val = new Utf8("16661");
        String stringVal = "16661";
        Map<CharSequence, CharSequence> utf8Map = new HashMap<>();
        utf8Map.put("a", "0");
        utf8Map.put("b", "1");
        utf8Map.put("c", "2");
        utf8Map.put("d", "3");

        Map<CharSequence, CharSequence> stringMap = new HashMap<>();
        stringMap.put("a", "0");
        stringMap.put("b", "1");
        stringMap.put("c", "2");
        stringMap.put("d", "3");

        TypeA typeAWithAvroCharSequence = TypeA.builder()
                .integerVal(integerVal)
                .utf8Val(utf8Val)
                .stringVal(stringVal)
                .charSequenceMap(utf8Map)
                .build();

        TypeA typeAWithJavaStringCharSequence = TypeA.builder()
                .integerVal(integerVal)
                .utf8Val(utf8Val)
                .stringVal(stringVal)
                .charSequenceMap(stringMap)
                .build();

        assertThat(typeAWithAvroCharSequence, is(typeAEq(typeAWithJavaStringCharSequence)));
    }

    @Test
    void assertEqualityOfAJavaStringMapAndAnAvroUtf8CharSequenceMap() {
        Map<CharSequence, CharSequence> actuallyUtf8Map = new HashMap<>();
        actuallyUtf8Map.put("a", "0");
        actuallyUtf8Map.put("b", "1");
        actuallyUtf8Map.put("c", "2");
        actuallyUtf8Map.put("d", "3");

        Map<CharSequence, CharSequence> actuallyStringMap = new HashMap<>();
        actuallyStringMap.put("a", "0");
        actuallyStringMap.put("b", "1");
        actuallyStringMap.put("c", "2");
        actuallyStringMap.put("d", "3");

        assertThat(actuallyUtf8Map, is(charSequenceMapEq(actuallyStringMap)));
    }

    @Test
    void assertEqualityOfAJavaStringMapAndAJavaStringMap() {
        String key = "16661";
        String value = "palindromic beastly prime";

        Map<CharSequence, CharSequence> actuallyStringMapA = new HashMap<>();
        actuallyStringMapA.put(key, value);

        Map<CharSequence, CharSequence> actuallyStringMapB = new HashMap<>();
        actuallyStringMapB.put(key, value);

        assertThat(actuallyStringMapA, is(equalTo(actuallyStringMapB)));
    }

    @Test
    void assertEqualityOfAJavaStringAndAnAvroUtf8() {
        String stringValue = "palindromic beastly prime";
        CharSequence charSequenceUtf8 = new Utf8(stringValue);
        CharSequence charSequenceString = stringValue;

        assertThat(charSequenceUtf8, is(equalTo(charSequenceString)));
    }

    @Test
    void assertCustomEqualityOfAJavaStringAndAnAvroUtf8() {
        String stringValue = "palindromic beastly prime";
        CharSequence charSequenceUtf8 = new Utf8(stringValue);
        CharSequence charSequenceString = stringValue;

        assertThat(charSequenceUtf8, is(charSequenceEq(charSequenceString)));
    }
}