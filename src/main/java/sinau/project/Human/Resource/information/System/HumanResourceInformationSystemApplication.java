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
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal != null && principal.getClass().equals(User.class)) {
				return (User) principal;
			}
		} catch (Exception ignore) {}

		return null;
	}

}
