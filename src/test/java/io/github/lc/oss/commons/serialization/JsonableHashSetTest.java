package io.github.lc.oss.commons.serialization;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.lc.oss.commons.testing.AbstractTest;

public class JsonableHashSetTest extends AbstractTest {
    @Test
    public void test_constructors() {
        JsonableHashSet<Jsonable> set = new JsonableHashSet<>();
        Assertions.assertTrue(set.isEmpty());

        Jsonable a = new Jsonable() {
        };

        set = new JsonableHashSet<>(Arrays.asList(a));
        Assertions.assertEquals(1, set.size());
        Assertions.assertSame(a, set.iterator().next());

        Object oa = new Object();
        set = new JsonableHashSet<>(Arrays.asList(oa), i -> a);
        Assertions.assertEquals(1, set.size());
        Assertions.assertSame(a, set.iterator().next());
    }
}
