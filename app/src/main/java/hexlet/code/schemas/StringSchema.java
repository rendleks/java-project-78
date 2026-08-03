package hexlet.code.schemas;

import hexlet.code.BaseSchema;


public class StringSchema extends BaseSchema<String> {

    public StringSchema() {
        super();
    }

    public StringSchema required() {
        super.setCheck("checkNull", text -> text != null);
        super.setCheck("lengthZero", text -> text.length() > 0);
        return this;
    }

    public StringSchema minLength(int length) {
        super.setCheck("minLength", text -> text.length() > length);
        return this;
    }

    public BaseSchema<String> contains(String subString) {
        super.setCheck("contains", text -> text.contains(subString));
        return this;
    }

}
