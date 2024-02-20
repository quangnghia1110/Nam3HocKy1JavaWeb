package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.entity.PayMethodEntity;

@Repository
public interface PayMethodRepository extends JpaRepository<PayMethodEntity, String>{
	
}
