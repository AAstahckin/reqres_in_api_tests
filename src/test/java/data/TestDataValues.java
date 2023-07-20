package data;

import com.github.javafaker.Faker;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

import static constans.ErrorsTexts.*;
import static utils.RandomUtils.getRandomText;

public class TestDataValues {

    public static Stream<Arguments> parameterizedNegativeData() {
        Faker faker = new Faker();
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

    public static Stream<Arguments> loginSubmitIncorrectParameters() {
        Faker faker = new Faker();
        return Stream.of(
                Arguments.of(faker.internet().emailAddress(), faker.artist().name(), USER_NOT_FOUND.getValue()),
                Arguments.of(faker.internet().emailAddress(), "", MISSING_PASSWORD.getValue()),
                Arguments.of("", faker.artist().name(), MISSING_EMAIL_OR_USERNAME.getValue()));
    }

    public static Stream<Arguments> getUsersOutputParamsForPage() {
        return Stream.of(
                Arguments.of(1, 6),
                Arguments.of(2, 6));
    }

}
