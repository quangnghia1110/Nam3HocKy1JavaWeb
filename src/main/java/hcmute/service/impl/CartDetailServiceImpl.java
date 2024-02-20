package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import hcmute.embeddedId.CartDetailId;
import hcmute.entity.CartDetailEntity;
import hcmute.entity.MilkTeaEntity;
import hcmute.repository.CartDetailRepository;
import hcmute.repository.CartRepository;
import hcmute.service.ICartDetailService;

import org.springframework.data.jpa.repository.Query;

@Service
public class CartDetailServiceImpl implements ICartDetailService {
	@Autowired
	CartDetailRepository cartDetailRepository;

	public CartDetailServiceImpl(CartDetailRepository cartDetailRepository) {
		this.cartDetailRepository = cartDetailRepository;
	}

	@Override
	public <S extends CartDetailEntity> S save(S entity) {
		return cartDetailRepository.save(entity);
	}

	@Override
	public List<CartDetailEntity> findAll() {
		return cartDetailRepository.findAll();
	}

	@Override
	public Page<CartDetailEntity> findAll(Pageable pageable) {
		return cartDetailRepository.findAll(pageable);
	}

	@Override
	public List<CartDetailEntity> findAll(Sort sort) {
		return cartDetailRepository.findAll(sort);
	}

	@Override
	public void delete(CartDetailEntity entity) {
		cartDetailRepository.delete(entity);
	}

	@Override
	public long count() {
		return cartDetailRepository.count();
	}

	@Override
	public void deleteAll() {
		cartDetailRepository.deleteAll();
	}
	
	@Override
	public Optional<CartDetailEntity> findById(CartDetailId id) {
		return cartDetailRepository.findById(id);
	}

	@Override
	public List<CartDetailEntity> findByCartByCartDetailIdCart(int idCart) {
		return cartDetailRepository.findByCartByCartDetailIdCart(idCart);
	}

    @Override
	public List<CartDetailId> findMilkTeaByCartId(int idCart) {
    	return cartDetailRepository.findMilkTeaByCartId(idCart);
    }

	@Override
	public void addProductToCart(int idCart, int idMilkTea, String size) {
		cartDetailRepository.addProductToCart(idCart, idMilkTea, size);		
	}
	@Override
	public void addProductToFavorite(int idCart, int idMilkTea) {
		cartDetailRepository.addProductToFavorite(idCart, idMilkTea);		
	}

}
