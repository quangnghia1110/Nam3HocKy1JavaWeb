package hcmute.service;

import java.util.List;
import java.util.Optional;

import hcmute.entity.MilkTeaCategoryEntity;

public interface IMilkTeaCategoryService {

	List<MilkTeaCategoryEntity> findAll();
	
	Optional<MilkTeaCategoryEntity> findById(int id);
	
	<S extends MilkTeaCategoryEntity> S save(S entity);
}

	
