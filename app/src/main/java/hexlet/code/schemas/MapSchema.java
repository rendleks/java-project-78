package hexlet.code.schemas;

import java.util.Map;

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
        addCheck("shape", map -> {
            return schemas.entrySet().stream()
                    .allMatch(e -> {
                        var checkKey = e.getKey();
                        var checkStatment = e.getValue();
                        T valueTest = (T) map.get(checkKey);
                        return checkStatment.isValid(valueTest);
                    });
        });

        return this;
    }
}
