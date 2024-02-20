package hcmute.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.entity.CityEntity;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, String>{

}
