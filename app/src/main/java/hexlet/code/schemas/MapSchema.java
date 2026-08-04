package hexlet.code.schemas;

import hexlet.code.BaseSchema;

import java.util.Map;

public class MapSchema  extends BaseSchema<Map> {

    public MapSchema() {
        super();
    }

    public MapSchema required() {
        super.setCheck("checkNull", s -> s != null);
        return this;
    }

    public MapSchema sizeof(int size) {
        super.setCheck("checkSize", s -> Integer.compare(s.size(), size) == 0);
        return this;
    }
}
