package password_generator_web.password.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import password_generator_web.password.generator.PasswordGenerator;

class PasswordServiceTest {

    private PasswordService service;

    @BeforeEach
    void setUp() {
        service = new PasswordService(new PasswordGenerator());
    }

    @Test
    void rejectsLengthBelowMinimum() {
        assertThrows(IllegalArgumentException.class,
                () -> service.generate(15, true, true, true, true));
    }

    @Test
    void rejectsLengthAboveMaximum() {
        assertThrows(IllegalArgumentException.class,
                () -> service.generate(129, true, true, true, true));
    }

    @Test
    void acceptsBothBoundaryLengths() {
        assertEquals(16,  service.generate(16,  true, true, true, true).length());
        assertEquals(128, service.generate(128, true, true, true, true).length());
    }
}