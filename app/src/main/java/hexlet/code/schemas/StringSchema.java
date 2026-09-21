package hexlet.code.schemas;


public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        super.required = true;
        super.addCheck("lengthZero", text -> text.length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        super.addCheck("minLength", text -> text.length() > length);
        return this;
    }

    public BaseSchema<String> contains(String subString) {
        super.addCheck("contains", text -> text.contains(subString));
        return this;
    }

}
