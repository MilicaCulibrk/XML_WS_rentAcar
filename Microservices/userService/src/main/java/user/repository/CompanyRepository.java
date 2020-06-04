package user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import user.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {

	boolean existsByUsername(String username);
	Company findByUsername(String username);

}
