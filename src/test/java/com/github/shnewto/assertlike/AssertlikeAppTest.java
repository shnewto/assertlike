package com.github.shnewto.assertlike;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AssertlikeAppTest {
    @Test void appHasAGreeting() {
        AssertlikeApp classUnderTest = new AssertlikeApp();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
