package hcmute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hcmute.entity.BranchEntity;
import hcmute.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer>{
	// Statistics for each day of the current month
	@Query(value="SELECT CAST(order_day AS DATE) AS order_date, SUM(final_price) AS total_price\r\n"
			+ "FROM user_order\r\n"
			+ "WHERE MONTH(order_day) = MONTH(GETDATE()) AND YEAR(order_day) = YEAR(GETDATE())\r\n"
			+ "GROUP BY CAST(order_day AS DATE);" , nativeQuery = true)
	List<Object[]> getRevenueByDay();
	
	// Statistics for each month of the current year
	@Query("SELECT MONTH(o.orderDay), SUM(o.finalPrice)FROM OrderEntity o "
			+ "WHERE YEAR(o.orderDay) = YEAR(GETDATE()) "
			+ "GROUP BY MONTH(o.orderDay)")
	List<Object[]> getRevenueByMonth();
	
	@Query("SELECT o FROM OrderEntity o WHERE o.customerByOrder.id = :userId")
    List<OrderEntity> findAllOrdersByUserId(Integer userId);
	
	List<OrderEntity> findByBranchByOrder(BranchEntity branchEntity);
}
