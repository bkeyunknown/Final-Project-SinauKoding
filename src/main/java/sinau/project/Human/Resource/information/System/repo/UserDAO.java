package sinau.project.Human.Resource.information.System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sinau.project.Human.Resource.information.System.entity.User;

public interface UserDAO extends JpaRepository<User, Long> {
}
