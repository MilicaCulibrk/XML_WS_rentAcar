package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import user.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long> {

	boolean existsByUsername(String username);
	Administrator findByUsername(String username);
}
