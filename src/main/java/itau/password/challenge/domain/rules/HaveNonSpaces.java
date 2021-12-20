package itau.password.challenge.domain.rules;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import itau.password.challenge.domain.interfaces.PasswordInterface;

@Slf4j
@Component
public class HaveNonSpaces implements PasswordInterface {
    @Override
    public boolean verify(String password) {
        final String haveNonSpacesRegex = "^(?!.*\\h).*$";

        log.info("Verificando se o password nao tem espacos");

        return password.matches(haveNonSpacesRegex);
    }
}
