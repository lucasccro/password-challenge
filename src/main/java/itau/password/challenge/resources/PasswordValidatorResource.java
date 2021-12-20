package itau.password.challenge.resources;

import itau.password.challenge.domain.entity.PasswordStatus;
import itau.password.challenge.resources.entity.PasswordDTO;
import itau.password.challenge.service.PasswordValidatorService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/password")
@Tag(name = "Valida Password")
public class PasswordValidatorResource {

    @Autowired
    PasswordValidatorService passwordValidatorService;

    @PostMapping("/valida")
    public ResponseEntity<PasswordStatus> validatePassword(@NonNull @RequestBody PasswordDTO passwordDTO) {

        if (passwordDTO.isInvalidInput()) {
            log.error("Password inputado invalido. O password nao pode ser nulo!");
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(passwordValidatorService.isValidPasswordWithAllCriteria(passwordDTO));
    }
}
