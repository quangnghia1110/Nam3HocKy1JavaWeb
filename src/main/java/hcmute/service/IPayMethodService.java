package hcmute.service;

import java.util.List;
import java.util.Optional;

import hcmute.entity.PayMethodEntity;

public interface IPayMethodService {

	List<PayMethodEntity> findAll();

	List<PayMethodEntity> findAllById(Iterable<String> ids);

	Optional<PayMethodEntity> findById(String id);

	<S extends PayMethodEntity> S save(S entity);

}
