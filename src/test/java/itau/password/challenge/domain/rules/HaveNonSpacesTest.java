package itau.password.challenge.domain.rules;


import itau.password.challenge.domain.enumeration.Criteria;
import itau.password.challenge.domain.mappers.PasswordMapper;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HaveNonSpacesTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments(" ", false),
                arguments("", true),
                arguments("Aiushda 123!", false),
                arguments("asoid!Pajs%", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void verificaSePasswordNaoTemEspacoTest(String password, boolean expectedOutput) {
        boolean result = PasswordMapper.isValid(password, Criteria.HAVE_NON_SPACES);

        Assert.assertEquals(result, expectedOutput);
    }
}