package itau.password.challenge.domain.rules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import itau.password.challenge.domain.interfaces.PasswordInterface;

@Slf4j
@Component
public class HasAtLeastOneLowercaseLetter implements PasswordInterface {
    @Override
    public boolean verify(String password) {
        final String atLeastOneLowerCaseLetterRegex = "^(?=.*[a-z]).*$";

        log.info("Verificando se o password tem no minimo uma letra minuscula");

        return password.matches(atLeastOneLowerCaseLetterRegex);
    }
}
