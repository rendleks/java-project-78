package hexlet.code.schemas;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import hexlet.code.Schema;


public class StringSchema implements Schema {

    private Map<String, Predicate<String>> fluent;

    public StringSchema() {
        this.fluent = new HashMap<>();
    }

    public StringSchema required() {
        fluent.put("checkNull", text -> text != null);
        fluent.put("lengthZero", text -> text.length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        fluent.put("minLength", text -> text.length() > length);
        return this;
    }

    public StringSchema contains(String subString) {
        fluent.put("contains", text -> text.contains(subString));
        return this;
    }

    public boolean isValid(String value) {
        return fluent.entrySet().stream()
                .allMatch(s -> s.getValue().test(value));
    }
}
