package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.OrderDetailEntity;
import hcmute.repository.OrderDetailRepository;
import hcmute.service.IOrderDetailService;

@Service
public class OrderDetailServiceImpl implements IOrderDetailService{
	@Autowired
	OrderDetailRepository orderDetailRepository;

	public OrderDetailServiceImpl(OrderDetailRepository orderDetailRepository) {
		super();
		this.orderDetailRepository = orderDetailRepository;
	}

	@Override
	public <S extends OrderDetailEntity> S save(S entity) {
		return orderDetailRepository.save(entity);
	}

	@Override
	public <S extends OrderDetailEntity> List<S> saveAll(Iterable<S> entities) {
		return orderDetailRepository.saveAll(entities);
	}

	@Override
	public OrderDetailEntity getById(OrderDetailId id) {
		return orderDetailRepository.getById(id);
	}

	@Override
	public List<Object[]> getQuantityByMilkTeaType() {
		return orderDetailRepository.getQuantityByMilkTeaType();
	}

	
}
