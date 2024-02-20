package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hcmute.entity.CartEntity;
import hcmute.repository.CartRepository;
import hcmute.service.ICartService;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired
	CartRepository cartRepository;

	public CartServiceImpl(CartRepository cartRepository) {
		super();
		this.cartRepository = cartRepository;
	}

	@Override
	public <S extends CartEntity> S save(S entity) {
		return cartRepository.save(entity);
	}

	@Override
	public List<CartEntity> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public Page<CartEntity> findAll(Pageable pageable) {
		return cartRepository.findAll(pageable);
	}

	@Override
	public List<CartEntity> findAll(Sort sort) {
		return cartRepository.findAll(sort);
	}

	@Override
	public List<CartEntity> findAllById(Iterable<Integer> ids) {
		return cartRepository.findAllById(ids);
	}

	@Override
	public Optional<CartEntity> findById(Integer id) {
		return cartRepository.findById(id);
	}

	@Override
	public long count() {
		return cartRepository.count();
	}

	@Override
	public void delete(CartEntity entity) {
		cartRepository.delete(entity);
	}

	@Override
	public void deleteAllById(Iterable<? extends Integer> ids) {
		cartRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAll() {
		cartRepository.deleteAll();
	}

	@Override
	public void deleteById(Integer id) {
		cartRepository.deleteById(id);
	}
	
	@Override
	public Optional<CartEntity> findCartsByUserId(int userId) {
		return cartRepository.findCartsByUserId(userId);
	}
	
}
