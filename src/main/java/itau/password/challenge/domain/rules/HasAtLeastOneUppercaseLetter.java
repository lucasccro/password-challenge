package itau.password.challenge.domain.rules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import itau.password.challenge.domain.interfaces.PasswordInterface;

@Slf4j
@Component
public class HasAtLeastOneUppercaseLetter implements PasswordInterface {

    @Override
    public boolean verify(String password) {
        final String atLeastOneUpperCaseLetterRegex = "^(?=.*[A-Z]).*$";

        log.info("Verificando se o password tem no minimo uma letra maiuscula");

        return password.matches(atLeastOneUpperCaseLetterRegex);
    }
}
