<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User</title>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<div class="orderr">
		<div class="container p-3" style="margin-top: 92px">
			<div class="row gx-5">
				<div class="col-4">
					<h2 class="order-title">Đơn hàng của bạn</h2>
					<c:if test="${message != null }">
						<c:if test="${'success' eq status }">
							<div class="alert alert-success" role="alert">${message }</div>
						</c:if>
						<c:if test="${'fail' eq status }">
							<div class="alert alert-danger" role="alert">${message }</div>
						</c:if>
					</c:if>
					<div class="list-group">
						<c:if test="${not empty orders }">
							<!-- Đơn hàng 1 -->
							<c:forEach var="order" items="${orders}">
								<a
									class="btn btn-outline-dark order-item ${order.idOrder == idOrder ? 'order-item-active' : '' }"
									href="/order/order-detail/${order.idOrder}" role="button">
									<div class="d-flex w-100 justify-content-between">
										<h5 class="mb-1">Mã đơn: ${order.idOrder}</h5>
										<small>Giao hàng tận nơi</small>
									</div>
									<div class="d-flex w-100 justify-content-between">
										<p class="mb-1">${order.totalProduct}món</p>
										<h5 class="mb-1">${order.finalPrice}đ</h5>
									</div>
								</a>
							</c:forEach>
						</c:if>
						<c:if test="${empty orders}">
							<div class="alert alert-info" role="alert">Không có đơn
								hàng nào.</div>
						</c:if>
					</div>
				</div>
				<c:if test="${userOrder != null}">
					<div class="col-8">
						<h2 class="order-title">Chi tiết đơn hàng</h2>
						<div>
							<!-- Thông tin khách hàng -->
							<div class="card border">
								<div class="card-header">
									<h5>Khách hàng</h5>
								</div>
								<div class="card-body">
									<div class="card-text" style="color: #707070;">
										<p style="font-weight: bold">Tên khách hàng:
											${userOrder.customerByOrder.surname}
											${userOrder.customerByOrder.name}</p>
										<p class="text-danger" style="font-weight: 700">Số điện
											thoại: ${userOrder.phoneNumber}</p>
										<p class="bold-text">Địa chỉ giao hàng: ${addressOrder}</p>
										<p class="bold-text">Địa chỉ nhận hàng:
											${userOrder.address}</p>
									</div>
								</div>
							</div>

							<!-- Thông tin đơn hàng -->
							<div class="card border">
								<div class="card-header">
									<h5>Đơn hàng: ${userOrder.idOrder}</h5>
									<h5>Trạng thái: <i class="text-danger">${userOrder.orderState == 0 ? "Chờ xử lý" : userOrder.orderState == 1 ? "Đã xác nhận" : userOrder.orderState == 2 ? "Đang giao hàng" : "Đã nhận hàng" }</i></h5>
								</div>
								<div class="card-body">
									<!-- Danh sách món -->
									<div class="card-text" style="color: #707070;">
										<c:forEach var="orderDetail" items="${userOrder.orderDetails}">
											<div class="listproduct">
												<div class="d-flex justify-content-between">
													<p style="font-weight: bold">${orderDetail.quantity}x
														${orderDetail.milkTeaByOrderDetail.name}</p>
													<h5 class="text-danger">${orderDetail.milkTeaByOrderDetail.cost}đ</h5>
												</div>
												<div class="d-flex justify-content-between">
													<p style="font-weight: bold">${orderDetail.idOrderDetail.size}</p>
													<h5 class="text-danger">${orderDetail.idOrderDetail.size == 'Lớn' ? '+ 5000đ' : '+ 0đ'}</h5>
												</div>
												<hr style="border: thin solid #D6D6D6;">
											</div>
										</c:forEach>
										<div class="d-flex justify-content-between">
											<p style="font-weight: bold">Phí giao hàng</p>
											<h5 class="text-danger">+ ${userOrder.fee }đ</h5>
										</div>
										<hr style="border: thin solid #D6D6D6;">
										<!-- Tổng giá -->
										<div class="total_price">
											<div class="d-flex justify-content-between">
												<p style="font-weight: 700">Tổng đơn</p>
												<h3 class="text-danger">${userOrder.finalPrice}đ</h3>
											</div>
										</div>
									</div>
								</div>
							</div>

							<!-- Thông tin thanh toán -->
							<div class="card border">
								<div class="card-header">
									<h5>Thanh toán</h5>
								</div>
								<div class="card-body">
									<div class="card-text" style="color: #707070;">
										<p>${userOrder.payMethodByOrder.name}</p>
									</div>
								</div>
							</div>

							<!-- Thời gian -->
							<div class="card border">
								<div class="card-header">
									<h5>Thời gian</h5>
								</div>
								<div class="card-body">
									<div class="card-text" style="color: #707070;">
										<div class="time_order">
											<div class="d-flex justify-content-between">
												<p style="font-weight: 700">Thời gian đặt hàng</p>
												<p class="text-danger" style="font-weight: 700">${userOrder.orderDay}</p>
											</div>
											<div class="d-flex justify-content-between">
												<p style="font-weight: 700">Giao hàng dự kiến</p>
												<p class="text-danger" style="font-weight: 700">${userOrder.shipDay}</p>
											</div>
										</div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</c:if>

			</div>
		</div>
	</div>
</body>
</html>