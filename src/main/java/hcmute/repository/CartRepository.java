package hcmute.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.entity.CartEntity;
@Repository
public interface CartRepository extends JpaRepository<CartEntity, Integer>{
	@Query("SELECT c FROM CartEntity c WHERE c.customerByCart.id = :userId")
    Optional<CartEntity> findCartsByUserId(int userId);
}
