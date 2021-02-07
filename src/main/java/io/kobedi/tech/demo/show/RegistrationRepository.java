package io.kobedi.tech.demo.show;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


@Repository
public interface RegistrationRepository extends JpaRepository<Registration, Long>
{
	
	@Query("SELECT max(r.id) FROM Registration r") 
	Integer getRegistrationMaxCount();
	
	@Query("SELECT r FROM Registration r where r.cellPhone = :cellphone") 
	Registration getRecordByCellPhoneNum(@Param("cellphone") String cellphone);

}
