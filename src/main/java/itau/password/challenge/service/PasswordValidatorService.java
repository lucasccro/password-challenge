package itau.password.challenge.service;

import org.springframework.stereotype.Service;

import itau.password.challenge.domain.entity.PasswordStatus;
import itau.password.challenge.domain.enumeration.Criteria;
import itau.password.challenge.domain.mappers.PasswordMapper;
import itau.password.challenge.resources.entity.PasswordDTO;


@Service
public class PasswordValidatorService {

    public PasswordStatus isValidPasswordWithAllCriteria(PasswordDTO passwordDTO) {
        String password = passwordDTO.getPassword();

        boolean isValidStatus = PasswordMapper.isValid(password,
                Criteria.AT_LEAST_ONE_LOWERCASE_LETTER,
                Criteria.AT_LEAST_ONE_UPPERCASE_LETTER,
                Criteria.AT_LEAST_NINE_CHARACTERS,
                Criteria.AT_LEAST_ONE_SPECIAL_CHARACTER,
                Criteria.HAVE_NON_REPEATING_CHARACTERS,
                Criteria.HAVE_NON_SPACES);

        return PasswordStatus.builder()
                .isValid(isValidStatus)
                .build();
    }
}
