package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import hcmute.entity.CartEntity;

public interface ICartService {

	void deleteAll();

	void deleteAllById(Iterable<? extends Integer> ids);

	void delete(CartEntity entity);

	long count();

	Optional<CartEntity> findById(Integer id);

	List<CartEntity> findAllById(Iterable<Integer> ids);

	List<CartEntity> findAll(Sort sort);

	Page<CartEntity> findAll(Pageable pageable);

	List<CartEntity> findAll();

	<S extends CartEntity> S save(S entity);

	void deleteById(Integer id);
	
	public Optional<CartEntity> findCartsByUserId(int userId);
}
