package hcmute.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import hcmute.entity.BranchEntity;
import hcmute.entity.OrderEntity;

public interface IOrderService {

	<S extends OrderEntity> S save(S entity);

	List<OrderEntity> findAll();

	OrderEntity getById(Integer id);
	
	int count();
	
	List<Object[]> getRevenueByDay();
	List<Object[]> getRevenueByMonth();
	List<OrderEntity> findAllOrdersByUserId(Integer userId);
	Optional<OrderEntity> findById(Integer id);
	List<OrderEntity> findByBranchByOrder(BranchEntity branchEntity);
}
