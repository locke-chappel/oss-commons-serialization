package io.github.lc.oss.commons.serialization;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import io.github.lc.oss.commons.testing.AbstractTest;

public class JsonMessageTest extends AbstractTest {
    private enum Category implements Message.Category {
        C
    }

    private enum Severity implements Message.Severity {
        S
    }

    @Test
    public void test_constructor_v1() {
        JsonMessage m = new JsonMessage(Category.C, Severity.S, 1);
        Assertions.assertSame(Category.C, m.getCategory());
        Assertions.assertSame(Severity.S, m.getSeverity());
        Assertions.assertEquals(1, m.getNumber());
        Assertions.assertNull(m.getText());
    }

    @Test
    public void test_constructor_v2() {
        JsonMessage m = new JsonMessage(Category.C, Severity.S, 1, "text");
        Assertions.assertSame(Category.C, m.getCategory());
        Assertions.assertSame(Severity.S, m.getSeverity());
        Assertions.assertEquals(1, m.getNumber());
        Assertions.assertEquals("text", m.getText());
    }

    @Test
    public void test_constructor_v3() {
        JsonMessage m = new JsonMessage(new Message() {
            @Override
            public Category getCategory() {
                return JsonMessageTest.Category.C;
            }

            @Override
            public Severity getSeverity() {
                return JsonMessageTest.Severity.S;
            }

            @Override
            public int getNumber() {
                return 1;
            }

            @Override
            public String getText() {
                return "text";
            }
        });
        Assertions.assertSame(Category.C, m.getCategory());
        Assertions.assertSame(Severity.S, m.getSeverity());
        Assertions.assertEquals(1, m.getNumber());
        Assertions.assertEquals("text", m.getText());
    }
}
