package hcmute.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hcmute.entity.BranchEntity;
@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Integer>{ 
}
