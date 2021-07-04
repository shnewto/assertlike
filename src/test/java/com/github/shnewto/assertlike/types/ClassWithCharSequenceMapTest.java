package com.github.shnewto.assertlike.types;

import com.google.common.collect.ImmutableMap;
import org.apache.avro.util.Utf8;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static com.github.shnewto.assertlike.matchers.CharSequenceEq.charSequenceEq;
import static com.github.shnewto.assertlike.matchers.CharSequenceMapEq.charSequenceMapEq;
import static com.github.shnewto.assertlike.matchers.ClassWithCharSequenceMapEq.typeAEq;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class ClassWithCharSequenceMapTest {
    Map<CharSequence, CharSequence> actuallyUtf8Map = ImmutableMap.<CharSequence, CharSequence>builder()
            .put(new Utf8("Event"), "Russia - The Rest of the World")
            .put(new Utf8("Site"), new Utf8("Moscow RUS"))
            .put(new Utf8("Date"), new Utf8("2002.09.09"))
            .put(new Utf8("EventDate"), new Utf8("2002.09.08"))
            .put(new Utf8("Round"), new Utf8("5"))
            .put(new Utf8("Result"), new Utf8("1-0"))
            .put(new Utf8("White"), new Utf8("Judit Polgar"))
            .put(new Utf8("Black"), new Utf8("Garry Kasparov"))
            .put(new Utf8("ECO"), new Utf8("C67"))
            .put(new Utf8("WhiteElo"), new Utf8("2681"))
            .put(new Utf8("BlackElo"), new Utf8("2838"))
            .put(new Utf8("PlyCount"), new Utf8("84"))
            .build();

    Map<CharSequence, CharSequence> actuallyStringMap = ImmutableMap.<CharSequence, CharSequence>builder()
            .put("Event", "Russia - The Rest of the World")
            .put("Site", "Moscow RUS")
            .put("Date", "2002.09.09")
            .put("EventDate", "2002.09.08")
            .put("Round", "5")
            .put("Result", "1-0")
            .put("White", "Judit Polgar")
            .put("Black", "Garry Kasparov")
            .put("ECO", "C67")
            .put("WhiteElo", "2681")
            .put("BlackElo", "2838")
            .put("PlyCount", "84")
            .build();

    @Test
    void assertCustomEqualityOfAnInternalJavaStringAndAnInternalAvroUtf8CharSequence() {
        ClassWithCharSequenceMap classWithCharSequenceMapWithAvroCharSequence = ClassWithCharSequenceMap.builder()
                .charSequenceMap(actuallyUtf8Map)
                .build();

        ClassWithCharSequenceMap classWithCharSequenceMapWithJavaStringCharSequence = ClassWithCharSequenceMap.builder()
                .charSequenceMap(actuallyStringMap)
                .build();

        // Will fail
        // assertThat(classWithCharSequenceMapWithAvroCharSequence, is(equalTo(classWithCharSequenceMapWithJavaStringCharSequence)));

        assertThat(classWithCharSequenceMapWithAvroCharSequence, is(typeAEq(classWithCharSequenceMapWithJavaStringCharSequence)));
    }

    @Test
    void assertCustomEqualityOfAJavaStringMapAndAnAvroUtf8CharSequenceMap() {
        assertThat(actuallyUtf8Map, is(charSequenceMapEq(actuallyStringMap)));

        // Will fail
        // assertThat(actuallyUtf8Map, is(equalTo(actuallyStringMap)));

         assertThat(actuallyUtf8Map, is(charSequenceMapEq(actuallyStringMap)));
    }

    @Test
    void assertCustomEqualityOfAJavaStringAndAnAvroUtf8() {
        CharSequence actuallyUtf8 = new Utf8("42. Rxg7 Kc8 1-0");
        CharSequence actuallyString = "42. Rxg7 Kc8 1-0";

        // Will fail
        // assertThat(actuallyUtf8, is(equalTo(actuallyString)));

        assertThat(actuallyUtf8, is(charSequenceEq(actuallyString)));
    }
}