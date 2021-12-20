package itau.password.challenge.domain.enumeration;

import itau.password.challenge.domain.interfaces.PasswordInterface;
import itau.password.challenge.domain.rules.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Criteria {

    AT_LEAST_ONE_UPPERCASE_LETTER(new HasAtLeastOneUppercaseLetter()),

    AT_LEAST_ONE_LOWERCASE_LETTER(new HasAtLeastOneLowercaseLetter()),

    AT_LEAST_ONE_SPECIAL_CHARACTER(new HasAtLeastOneSpecialCharacter()),

    AT_LEAST_NINE_CHARACTERS(new HasAtLeastNineCharacters()),

    HAVE_NON_REPEATING_CHARACTERS(new HaveNonRepeatingCharacters()),

    AT_LEAST_ONE_DIGIT(new HasAtLeastOneDigit()),

    HAVE_NON_SPACES(new HaveNonSpaces());

    private final PasswordInterface passwordInterface;

}
