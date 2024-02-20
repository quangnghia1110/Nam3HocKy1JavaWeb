package hcmute.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.entity.MilkTeaTypeEntity;

@Repository
public interface MilkTeaTypeRepository extends JpaRepository<MilkTeaTypeEntity, Integer> {
	@Query("SELECT mt FROM MilkTeaTypeEntity mt WHERE mt.milkTeaCategoryByMilkTeaType.idCategory = :categoryId")
	List<MilkTeaTypeEntity> findAllByCategoryId(int categoryId);
	
	long count();
	Page<MilkTeaTypeEntity> findByidTypeContaining(int idType, Pageable pageable);
	Page<MilkTeaTypeEntity> findAll(Pageable pageable);
}
