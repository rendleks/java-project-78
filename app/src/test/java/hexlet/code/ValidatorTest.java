package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static  org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    private static Validator validator;

    @BeforeAll
    public static void beforeAllTest() {
        validator = new Validator();
    }

    @Test
    public void testStringSchema() {
        assertThat(validator).isInstanceOf(Validator.class);
        var schema = validator.string();
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

        var schema1 = validator.string();
        assertThat(schema1.minLength(10).minLength(4).isValid("Hexlet")).isEqualTo(true);
    }

    @Test
    public void testNumberSchema() {
        var schema2 = validator.number();
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
}
