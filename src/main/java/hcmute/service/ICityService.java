package hcmute.service;

import java.util.List;
import java.util.Optional;

import hcmute.entity.CityEntity;

public interface ICityService {

	List<CityEntity> findAll();

	<S extends CityEntity> S save(S entity);

	Optional<CityEntity> findById(String id);

	void deleteById(String id);
	

}
