package password_generator_web.password;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import password_generator_web.password.generator.PasswordGenerator;

@SpringBootApplication
public class PasswordApplication {

	public static void main(String[] args) {
		//SpringApplication.run(PasswordApplication.class, args);

		// ConfigurableApplicationContext for a container in order to test the class functionality
		ConfigurableApplicationContext ctx = SpringApplication.run(PasswordApplication.class, args);
		System.out.println(ctx.getBean(PasswordGenerator.class).generate(16, true, true, true, true));
	}

}
