package hexlet.code;

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
        assertThat(schema).isInstanceOf(Schema.class);
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

}
