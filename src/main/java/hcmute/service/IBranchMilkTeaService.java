package hcmute.service;

import java.util.List;
import java.util.Optional;

import hcmute.embeddedId.BranchMilkTeaId;
import hcmute.entity.BranchMilkTea;

public interface IBranchMilkTeaService {

	Optional<Integer> findRemainQuantityByBranchIdAndMilkTeaId(int idBranch, int idMilkTea, String size);

	Optional<BranchMilkTea> findById(BranchMilkTeaId id);

	List<BranchMilkTea> findAll();

	<S extends BranchMilkTea> S save(S entity);

	void deleteAll();
}
