package sinau.project.Human.Resource.information.System;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.context.SecurityContextHolder;
import sinau.project.Human.Resource.information.System.entity.User;

@SpringBootApplication
public class HumanResourceInformationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HumanResourceInformationSystemApplication.class, args);
	}

	public static User getCurrentUser() {
		try {
			Object pricipal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (pricipal != null && pricipal.getClass().equals(User.class)) {
				return (User) pricipal;
			}
		} catch (Exception ignore) {}

		return null;
	}

}
