package itau.password.challenge.domain.rules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import itau.password.challenge.domain.interfaces.PasswordInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Component
public class HasAtLeastOneSpecialCharacter implements PasswordInterface {

    private final String VALID_SPECIAL_CHARACTERS_REGEX = "!|@|#|$|%|^|&|*|(|)|\\-|+";

    @Override
    public boolean verify(String password) {
        log.info("Verificando se o password tem no minimo um caracter especial");

        final String hasAtLeastOneSpecialCharacterRegex = "^(?=.*[" + VALID_SPECIAL_CHARACTERS_REGEX + "]).*$";

        if (haveAInvalidSpecialCharacter(password)) {
            log.info("O password tem um caracter especial invalido.");
            return false;
        }

        return password.matches(hasAtLeastOneSpecialCharacterRegex);
    }

    private boolean haveAInvalidSpecialCharacter(String password) {
        final String specialCharactersBlacklistRegex = "(?=[\\p{P}\\p{S}])(?![" + VALID_SPECIAL_CHARACTERS_REGEX +
                "])[\\w\\p{P}\\p{S}]";

        Pattern pattern = Pattern.compile(specialCharactersBlacklistRegex);

        Matcher matcher = pattern.matcher(password);

        return matcher.find();
    }
}
