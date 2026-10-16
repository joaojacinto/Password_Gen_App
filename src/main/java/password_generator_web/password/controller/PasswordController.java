package password_generator_web.password.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import password_generator_web.password.service.PasswordService;

@RestController
@RequestMapping("/api")
public class PasswordController {

    private final PasswordService service;

    public PasswordController(PasswordService service) {
        this.service = service;
    }

    // default values for the password generation in case no args are passed by the caller
    @GetMapping("/password")
    public String generate(
            @RequestParam(defaultValue = "16") int length,
            @RequestParam(defaultValue = "true") boolean lower,
            @RequestParam(defaultValue = "true") boolean upper,
            @RequestParam(defaultValue = "true") boolean digits,
            @RequestParam(defaultValue = "true") boolean symbols) {

        return service.generate(length, lower, upper, digits, symbols);
    }
}
