package com.github.shnewto.assertlike.types;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.avro.util.Utf8;

import java.math.BigInteger;
import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeA {
    public Integer integerVal;
    public Utf8 utf8Val;
    public String stringVal;
    public Map<CharSequence, CharSequence> charSequenceMap;
}
