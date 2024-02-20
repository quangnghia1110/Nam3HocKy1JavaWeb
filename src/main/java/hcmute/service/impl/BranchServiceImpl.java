package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import hcmute.entity.BranchEntity;
import hcmute.repository.BranchRepository;
import hcmute.service.IBranchService;
@Service
public class BranchServiceImpl implements IBranchService{
	@Autowired
	BranchRepository branchRepository;
	@Override
	public List<BranchEntity> findAll() {
		return branchRepository.findAll();
	}
	@Override
	public BranchEntity getById(Integer id) {
		return branchRepository.getById(id);
	}
	@Override
	public <S extends BranchEntity> S save(S entity) {
		if (entity.getIdBranch() == 0) {
			return branchRepository.save(entity);
		} else {
			Optional<BranchEntity> opt = findById(entity.getIdBranch());
			if (opt.isPresent()) {
				if (StringUtils.isEmpty(entity.getImage())) {
					entity.setImage(opt.get().getImage());
				} else {
					entity.setImage(entity.getImage());
				}
			}
			return branchRepository.save(entity);
		}
	}
	@Override
	public Page<BranchEntity> findAll(Pageable pageable) {
		return branchRepository.findAll(pageable);
	}
	@Override
	public List<BranchEntity> findAll(Sort sort) {
		return branchRepository.findAll(sort);
	}
	@Override
	public Optional<BranchEntity> findById(Integer id) {
		return branchRepository.findById(id);
	}
	@Override
	public long count() {
		return branchRepository.count();
	}
	@Override
	public void deleteById(Integer id) {
		branchRepository.deleteById(id);
	}
	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		branchRepository.deleteAllById(ids);
	}
	@Override
	public void deleteAll() {
		branchRepository.deleteAll();
	}

	
	

	
	
}
