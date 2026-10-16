package password_generator_web.password.service;

import org.springframework.stereotype.Service;
import password_generator_web.password.generator.PasswordGenerator;

@Service
public class PasswordService {
    // min rule length to prevent impossible requests
    private static final int MIN_LENGTH = 16;
    // max rule length to prevent impossible requests
    private static final int MAX_LENGTH = 128;

    private final PasswordGenerator generator;


    public PasswordService(PasswordGenerator generator) {
        this.generator = generator;
    }


    public String generate(int length, boolean lower, boolean upper,
                           boolean digits, boolean symbols) {
        // length limits, max and min
        if (length > MAX_LENGTH){
            throw new IllegalArgumentException("Length cannot exceed " + MAX_LENGTH + " characters.");
        } else if (length < MIN_LENGTH){
            throw new IllegalArgumentException("Length must be at least " + MIN_LENGTH + " characters.");
        }

        return generator.generate(length, lower, upper, digits, symbols);
    }

}
