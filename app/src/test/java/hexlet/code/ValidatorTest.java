package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static  org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @Test
    public void testStringSchema() {
        var v = new Validator();
        assertThat(v).isInstanceOf(Validator.class);
        var schema = v.string();
        assertThat(schema).isInstanceOf(StringSchema.class);
        assertThat(schema.isValid(null)).isEqualTo(true);
        assertThat(schema.isValid("")).isEqualTo(true);

        schema.required();

        assertThat(schema.isValid(null)).isEqualTo(false);
        assertThat(schema.isValid("")).isEqualTo(false);
        assertThat(schema.isValid("what does the fox say")).isEqualTo(true);
        assertThat(schema.isValid("hexlet")).isEqualTo(true);

        assertThat(schema.contains("wh").isValid("what does the fox say")).isEqualTo(true);
        assertThat(schema.contains("what").isValid("what does the fox say")).isEqualTo(true);
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isEqualTo(false);

        assertThat(schema.isValid("what does the fox say")).isEqualTo(false);

        var schema1 = v.string();
        assertThat(schema1.minLength(10).minLength(4).isValid("Hexlet")).isEqualTo(true);
    }

    @Test
    public void testNumberSchema() {
        var v = new Validator();
        var schema2 = v.number();
        assertThat(schema2).isInstanceOf(NumberSchema.class);

        assertThat(schema2.isValid(5)).isEqualTo(true);
        assertThat(schema2.isValid(null)).isEqualTo(true);
        assertThat(schema2.positive().isValid(null)).isEqualTo(true);

        schema2.required();

        assertThat(schema2.isValid(null)).isEqualTo(false);
        assertThat(schema2.isValid(10)).isEqualTo(true);
        assertThat(schema2.isValid(-10)).isEqualTo(false);
        assertThat(schema2.isValid(0)).isEqualTo(false);

        schema2.range(5, 10);

        assertThat(schema2.isValid(5)).isEqualTo(true);
        assertThat(schema2.isValid(10)).isEqualTo(true);
        assertThat(schema2.isValid(4)).isEqualTo(false);
        assertThat(schema2.isValid(11)).isEqualTo(false);

    }

    @Test
    public void testMapValidator() {
        var v = new Validator();
        var schema = v.map();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        schema.required();
        assertThat(schema.isValid(null)).isFalse();
        assertThat(schema.isValid(new HashMap<>())).isTrue();

        schema.sizeof(2);
        assertThat(schema.isValid(new HashMap<>())).isFalse();
        Map<String, String> actual1 = new HashMap<>();
        actual1.put("key1", "value1");
        assertThat(schema.isValid(actual1)).isFalse();
        actual1.put("key2", "value2");
        assertThat(schema.isValid(actual1)).isTrue();

        Map<String, BaseSchema<String>> schemas = new HashMap<>();
        schemas.put("firstName", v.string().required().contains("ya"));
        schemas.put("lastName", v.string().required().contains("ov"));
        schema.shape(schemas);

        Map<String, String> actual2 = new HashMap<>();
        actual2.put("firstName", "Kolya");
        actual2.put("lastName", "Ivanov");
        assertThat(schema.isValid(actual2)).isTrue();

        Map<String, String> actual3 = new HashMap<>();
        actual3.put("firstName", "Maya");
        actual3.put("lastName", "Krasnova");
        assertThat(schema.isValid(actual3)).isTrue();

        Map<String, String> actual4 = new HashMap<>();
        actual4.put("firstName", "John");
        actual4.put("age", "B");
        assertThat(schema.isValid(actual4)).isFalse();
    }
}
