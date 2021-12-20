package itau.password.challenge.domain.mappers;

import itau.password.challenge.domain.enumeration.Criteria;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass
public class PasswordMapper {

    public boolean isValid(String password, Criteria... criterias) {

        for (Criteria criteria : criterias) {
            boolean umPasswordInvalido = !criteria.getPasswordInterface().verify(password);

            if (umPasswordInvalido) {
                log.info("Password é invalido!");
                return false;
            }
        }

        log.info("Password é valido!");

        return true;
    }

}
