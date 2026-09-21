package hexlet.code.schemas;


public class NumberSchema extends BaseSchema<Integer> {

    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        super.required = true;
        return this;
    }

    public NumberSchema positive() {
        super.addCheck("positive",  (num -> {
            if (!required && num == null) {
                return true;
            }
            return num > 0;
        }));
        return this;
    }

    public NumberSchema range(int start, int end) {
        super.addCheck("range", num -> ((num >= start) && (num <= end)));
        return this;
    }


}
