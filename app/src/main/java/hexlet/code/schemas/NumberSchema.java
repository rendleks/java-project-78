package hexlet.code.schemas;

import hexlet.code.BaseSchema;


public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        super.setCheck("checkNull", num -> num != null);
        return this;
    }

    public NumberSchema positive() {
        super.setCheck("positive",  (num) -> {
            if (num == null) {
                return true;
            }

            return num > 0;
        });
        return this;
    }

    public NumberSchema range(int start, int end) {
        super.setCheck("range", num -> ((num >= start) && (num <= end)));
        return this;
    }


}
