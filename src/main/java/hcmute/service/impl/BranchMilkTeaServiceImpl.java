package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.embeddedId.BranchMilkTeaId;
import hcmute.entity.BranchMilkTea;
import hcmute.repository.BranchMilkTeaRepository;
import hcmute.service.IBranchMilkTeaService;

@Service
public class BranchMilkTeaServiceImpl implements IBranchMilkTeaService{
	@Autowired
	BranchMilkTeaRepository branchMilkTeaRepository;

	public BranchMilkTeaServiceImpl(BranchMilkTeaRepository branchMilkTeaRepository) {
		this.branchMilkTeaRepository = branchMilkTeaRepository;
	}
	
	@Override
	public Optional<Integer> findRemainQuantityByBranchIdAndMilkTeaId(int idBranch, int idMilkTea, String size) {
		return branchMilkTeaRepository.findRemainQuantityByBranchIdAndMilkTeaId(idBranch, idMilkTea, size);
	}

	@Override
	public List<BranchMilkTea> findAll() {
		return branchMilkTeaRepository.findAll();
	}

	@Override
	public Optional<BranchMilkTea> findById(BranchMilkTeaId id) {
		return branchMilkTeaRepository.findById(id);
	}

	@Override
	public void deleteAll() {
		branchMilkTeaRepository.deleteAll();
	}

	@Override
	public <S extends BranchMilkTea> S save(S entity) {
		return branchMilkTeaRepository.save(entity);
	}

	public void deleteById(BranchMilkTeaId id) {
		branchMilkTeaRepository.deleteById(id);
	}
	
}
