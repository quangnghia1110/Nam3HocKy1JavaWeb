package hcmute.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import hcmute.entity.BranchEntity;
import hcmute.model.BranchModel;

public interface IBranchService {

	List<BranchEntity> findAll();

	BranchEntity getById(Integer id);

	void deleteAll();

	void deleteAllById(Iterable<? extends Integer> ids);

	void deleteById(Integer id);

	long count();

	Optional<BranchEntity> findById(Integer id);

	List<BranchEntity> findAll(Sort sort);

	Page<BranchEntity> findAll(Pageable pageable);

	<S extends BranchEntity> S save(S entity);

	


}
