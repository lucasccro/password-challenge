package itau.password.challenge.service;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import itau.password.challenge.domain.entity.PasswordStatus;
import itau.password.challenge.resources.entity.PasswordDTO;

@SpringBootTest
class PasswordValidatorServiceTest {

    @Autowired
    PasswordValidatorService passwordValidatorService;

    static Stream<Arguments> passwordsAndExpectedOutputDataProvider() {
        return Stream.of(
                arguments(" ", false),
                arguments("", false),
                arguments("Aiushda 123!", false),
                arguments("AbTp9!fok", true),
                arguments("asoid!Pj@", true),
                arguments("ab", false),
                arguments("12125", false),
                arguments("!@#", false),
                arguments("AbTp9 fok", false),
                arguments("AbTp9!foo", false),
                arguments("AbTp9!foA", false),
                arguments("AAAbbbCc", false)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsAndExpectedOutputDataProvider")
    void isValidPasswordWithAllCriteriaTest(String password, boolean expectedOutput) {
        PasswordDTO passwordDTO = new PasswordDTO();
        passwordDTO.setPassword(password);

        PasswordStatus result = passwordValidatorService.isValidPasswordWithAllCriteria(passwordDTO);

        Assert.assertEquals(result.isValid(), expectedOutput);
    }
}