package io.kobedi.tech.demo.show;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>
{
	
	

}
