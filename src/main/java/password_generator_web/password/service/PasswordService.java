package password_generator_web.password.service;

import org.springframework.stereotype.Service;
import password_generator_web.password.generator.PasswordGenerator;

@Service
public class PasswordService {
    private final PasswordGenerator generator;


    public PasswordService(PasswordGenerator generator) {
        this.generator = generator;
    }


    public String generate(int length, boolean lower, boolean upper,
                           boolean digits, boolean symbols) {
        return generator.generate(length, lower, upper, digits, symbols);
    }

}
