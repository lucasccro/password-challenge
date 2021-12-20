package itau.password.challenge.domain.entity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PasswordStatus {

    private boolean isValid;

}
