package itau.password.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class PasswordChallengeApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(PasswordChallengeApplication.class);
        Environment env = app.run(args).getEnvironment();

        String port = env.getProperty("server.port");

        log.info("\n================================================\n" +
                        "\n\tAcesse: http://localhost:{}\n" +
                        "\tSwagger: http://localhost:{}/itau-password-challenge\n" +
                        "\n================================================\n",
                port, port
        );

    }

}
