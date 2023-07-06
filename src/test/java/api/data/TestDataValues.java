package api.data;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static api.utils.RandomUtils.getRandomText;

public class TestDataValues {

    static Faker faker = new Faker();

    public static Stream<Arguments> parameterizedNegativeData() {
        return Stream.of(
                Arguments.of("!@%&^%*(!@(&*", "()*^*&%&*^@)"),
                Arguments.of("КУАГУРУСУПЕР", "КУАГУРУСУПЕР"),
                Arguments.of("qa.guru super", "qa.guru super"),
                Arguments.of(" ", " "),
                Arguments.of(getRandomText(100), getRandomText(100)),
                Arguments.of(getRandomText(500), getRandomText(500)),
                Arguments.of(null, null),
                Arguments.of(null, faker.job().position()),
                Arguments.of(faker.job().position(), null),
                Arguments.of("-999", "-999"),
                Arguments.of("4124123", "41251253"));
    }

}
