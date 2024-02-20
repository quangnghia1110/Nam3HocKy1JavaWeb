package hcmute.service;

import java.util.List;
import java.util.Optional;

import hcmute.embeddedId.OrderDetailId;
import hcmute.entity.OrderDetailEntity;

public interface IOrderDetailService {

	<S extends OrderDetailEntity> List<S> saveAll(Iterable<S> entities);

	<S extends OrderDetailEntity> S save(S entity);

	OrderDetailEntity getById(OrderDetailId id);

	List<Object[]> getQuantityByMilkTeaType();


}
