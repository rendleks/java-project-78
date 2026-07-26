package hexlet.code.schemas;

import java.util.Optional;
import java.util.ArrayList;
import hexlet.code.Schema;


public class StringSchema implements Schema {

    private ArrayList<Boolean> fluent = new ArrayList<>();
    private Optional<String> text = Optional.empty();

    public StringSchema required() {
        fluent.add(text.isPresent());
        fluent.add(text.map(String::length).orElse(0) > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        fluent.add(text.map(String::length).orElse(0) > length);
        return this;
    }

    public StringSchema contains(String subString) {
        fluent.add(text.map(t -> t.contains(subString)).orElse(false));
        return this;
    }

    public void setText(String text) {
        this.text = Optional.ofNullable(text);
    }

    public boolean isValid() {
        return fluent.stream()
                .allMatch(Boolean::booleanValue);
    }

    public boolean isValid(String value) {
        setText(value);
        return fluent.stream()
                .allMatch(Boolean::booleanValue);
    }
}
