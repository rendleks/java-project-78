package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    public Map<String, Predicate<T>> fluent;
    protected boolean required = false;

    public BaseSchema() {
        this.fluent = new HashMap<String, Predicate<T>>();
    }

    public void addCheck(String name, Predicate<T> check) {
        fluent.put(name, check);
    }

    public boolean isValid(T item) {
        if (required && item == null) {
            return false;
        }

        return fluent.entrySet().stream()
                .allMatch(s -> s.getValue().test(item));
    }

}
