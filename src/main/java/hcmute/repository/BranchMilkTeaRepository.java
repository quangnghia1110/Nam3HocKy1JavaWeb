package hcmute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import hcmute.embeddedId.BranchMilkTeaId;
import hcmute.entity.BranchMilkTea;

@Repository
public interface BranchMilkTeaRepository extends JpaRepository<BranchMilkTea, BranchMilkTeaId> {
	@Query("SELECT COALESCE(b.remainQuantity, 0) FROM BranchMilkTea b WHERE b.branchMilkTeaId.idBranch = :idBranch AND b.branchMilkTeaId.idMilkTea = :idMilkTea AND b.branchMilkTeaId.size = :size")
	Optional<Integer> findRemainQuantityByBranchIdAndMilkTeaId(int idBranch, int idMilkTea, String size);
}
