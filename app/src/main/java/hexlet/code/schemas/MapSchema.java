package hexlet.code.schemas;

import hexlet.code.BaseSchema;

import java.util.Map;
import java.util.function.Predicate;

public class MapSchema extends BaseSchema<Map> {

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        super.addCheck("checkNull", s -> s != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        super.addCheck("checkSize", s -> Integer.compare(s.size(), size) == 0);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addCheck(
                "shape",
                map -> {
                    return schemas.entrySet().stream()
                            .allMatch(e -> {
                                var key = e.getKey();
                                var value = e.getValue();

                                return value.isValid(s -> {
                                    for (Map.Entry<String, String> item: s.entrySet()) {
                                        if (s.getKey().equals(key) {
                                            return s.getValue();
                                        }
                                    }

                                    return false;
                                });
                            });
                });
        return this;
    }

}
