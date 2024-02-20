package hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.entity.MilkTeaCategoryEntity;
import hcmute.entity.MilkTeaEntity;

@Repository
public interface MilkTeaCategoryRepository extends JpaRepository<MilkTeaCategoryEntity, Integer>{
	List<MilkTeaCategoryEntity> findAll();
}
