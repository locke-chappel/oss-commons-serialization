package io.github.lc.oss.commons.serialization;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class JsonMessage implements Message, Jsonable {
    private final Category category;
    private final Severity severity;
    private final int number;
    private final String text;

    public JsonMessage(Category category, Severity severity, int number, String text) {
        this.category = category;
        this.severity = severity;
        this.number = number;
        this.text = text;
    }

    public JsonMessage(Category category, Severity severity, int number) {
        this(category, severity, number, null);
    }

    public JsonMessage(Message message) {
        this(message.getCategory(), message.getSeverity(), message.getNumber(), message.getText());
    }

    @Override
    public Category getCategory() {
        return this.category;
    }

    @Override
    public Severity getSeverity() {
        return this.severity;
    }

    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public String getText() {
        return this.text;
    }
}
