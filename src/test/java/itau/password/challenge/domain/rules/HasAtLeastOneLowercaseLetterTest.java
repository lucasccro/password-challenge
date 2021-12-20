package itau.password.challenge.domain.rules;

import itau.password.challenge.domain.enumeration.Criteria;
import itau.password.challenge.domain.mappers.PasswordMapper;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class HasAtLeastOneLowercaseLetterTest {

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments("zxc12345678", true),
                arguments("123456789", false),
                arguments("aszs", true),
                arguments("!@#%zxc12354", true),
                arguments("123", false),
                arguments("!@", false),
                arguments("", false),
                arguments(" ", false),
                arguments("              ", false),
                arguments("AAAAAAAAA", false),
                arguments("!@%!@%!@%!*&(z", true),
                arguments("ZZZZzZZZZZ", true)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void verificaSePasswordTemNoMinimoUmaLetraMinusculaTest(String password, boolean expectedOutput) {
        boolean result = PasswordMapper.isValid(password, Criteria.AT_LEAST_ONE_LOWERCASE_LETTER);

        Assert.assertEquals(result, expectedOutput);
    }

}