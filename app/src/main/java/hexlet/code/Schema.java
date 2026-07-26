package hexlet.code;

public interface Schema {
    Schema required();
    Schema minLength(int length);
    Schema contains(String subString);
    boolean isValid();
    boolean isValid(String text);
}
