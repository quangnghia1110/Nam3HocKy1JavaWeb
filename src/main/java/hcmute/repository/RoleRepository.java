package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hcmute.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, String>{
    
}
