package hcmute.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hcmute.entity.BranchEntity;
import hcmute.entity.OrderEntity;
import hcmute.repository.OrderRepository;
import hcmute.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{
	@Autowired
	OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@Override
	public <S extends OrderEntity> S save(S entity) {
		return orderRepository.save(entity);
	}

	@Override
	public List<OrderEntity> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public OrderEntity getById(Integer id) {
		return orderRepository.getById(id);
	}

	@Override
	public int count() {
		return (int) orderRepository.count();
	}

	@Override
	public List<Object[]> getRevenueByDay() {
		return orderRepository.getRevenueByDay();
	}

	@Override
	public List<Object[]> getRevenueByMonth() {
		return orderRepository.getRevenueByMonth();
	}
	
	@Override
	public List<OrderEntity> findAllOrdersByUserId(Integer userId) {
		return orderRepository.findAllOrdersByUserId(userId);
	}

	@Override
	public Optional<OrderEntity> findById(Integer id) {
		return orderRepository.findById(id);
	}
	
	@Override
	public List<OrderEntity> findByBranchByOrder(BranchEntity branchEntity) {
		return orderRepository.findByBranchByOrder(branchEntity);
	}
	
	
}
