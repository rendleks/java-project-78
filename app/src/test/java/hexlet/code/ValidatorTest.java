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
    public void testEmptySchema() {
        assertThat(validator).isInstanceOf(Validator.class);
        var schema = validator.string();
        assertThat(schema).isInstanceOf(Schema.class);
        assertThat(schema.isValid("")).isEqualTo(true);
        assertThat(schema.isValid()).isEqualTo(true);
    }
}
