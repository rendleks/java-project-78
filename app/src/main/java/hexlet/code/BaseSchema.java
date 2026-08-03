package hexlet.code;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    public Map<String, Predicate<T>> fluent;

    public BaseSchema() {
        this.fluent = new HashMap<String, Predicate<T>>();
    }

    public void setCheck(String name, Predicate<T> check) {
        fluent.put(name, check);
    }

    public boolean isValid(T item) {
        return fluent.entrySet().stream()
                .allMatch(s -> s.getValue().test(item));
    }

}
