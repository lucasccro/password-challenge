package itau.password.challenge.domain.rules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import itau.password.challenge.domain.interfaces.PasswordInterface;

import java.util.regex.Pattern;

@Slf4j
@Component
public class HaveNonRepeatingCharacters implements PasswordInterface {
    @Override
    public boolean verify(String password) {
        final String haveNonRepeatingCharactersRegex = "^(?!.*(.).*\\1).*$";

        log.info("Verificando se o password nao tem caracter repetido");

        Pattern haveNonRepeatingCharactersPattern = Pattern.compile(haveNonRepeatingCharactersRegex,
                Pattern.CASE_INSENSITIVE);

        return haveNonRepeatingCharactersPattern.matcher(password).find();
    }
}
