<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:400,300,600"
	rel="stylesheet" type="text/css">
<link href='<c:url value="/css/payment.css"/>' rel="stylesheet"
	type="text/css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	type="text/javascript"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	type="text/javascript"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	type="text/javascript"></script>
</head>
<body>
	<div class="payment">
		<div data-name='${dataJSON}' data-id="${idBranch }"
			class="payment-content">
			<h1 class="bold-text" style="margin-bottom: 46px; margin-top: 16px">Thanh
				toán đơn hàng</h1>
			<div class="row w-100">
				<div class="col-5">
					<div class="payment-container">
						<div class="mb-4">
							<h4>Giao hàng</h4>
							<div class="payment-info">
								<div class="mb-4" style="position: relative;">
									<label for="addressInp" class="form-label">Địa chỉ nhận
										hàng </label> <input id="addressInp" type="text"
										class="form-control bold-text" placeholder="Địa chỉ">
									<ul class="places-result"></ul>
								</div>
								<div class="mb-4" style="position: relative;">
									<label for="addressInp" class="form-label">Chọn cửa
										hàng</label>
									<ul class="list-branches" style="list-style: none">
										<c:forEach var="branch" items="${branches }" varStatus="loop">
											<li class="list-branches-item">
												<div class="d-flex align-items-center">
													<input data-id="${branch.idBranch }" type="radio"
														class="radio-branch" name="branchRadio"
														${loop.index == 0 ? 'checked' : '' }
														id="flexRadio${branch.idBranch}${loop.index}" />
													<div class="list-branches-item-info"
														style="margin-left: 12px">
														<p class="m-0 bold-text list-branches-item-name"
															style="font-size: 24px;">${branch.name }</p>
														<p
															class="bold-text text-secondary fst-italic list-branches-item-address"
															style="margin-bottom: 6px">${branch.addressDetail }</p>
														<p class="m-0 branch-fee" style="font-size: 20px;">
															Phí giao hàng: <span
																class="branch-fee-val bold-text text-danger">0đ</span>
														</p>
													</div>
												</div>
												<hr>
											</li>
										</c:forEach>
									</ul>
								</div>
								<div class="mb-3">
									<label for="surnameInp" class="form-label">Tên khách
										hàng </label>
									<div class="d-flex align-items-center">
										<input id="surnameInp" type="text" readonly="readonly"
											value="${customer.surname}" class="form-control"
											style="margin-right: 12px"> <input type="text"
											readonly="readonly" value="${customer.name}"
											class="form-control">
									</div>
								</div>
								<div class="mb-3">
									<label for="phoneNumberInp" class="form-label">Số điện
										thoại </label> <input id="phoneNumberInp" name="phoneNumber"
										type="text" value="${customer.phoneNumber}"
										class="form-control" placeholder="Số điện thoại">
								</div>
							</div>
						</div>
						<div class="mb-4">
							<h4>Phương thức thanh toán</h4>

							<!-- Lặp qua danh sách phương thức thanh toán và tạo radiobutton -->
							<c:forEach var="paymentMethod" items="${listPayMethod}">
								<div class="form-check">
									<input class="form-check-input-radio" type="radio"
										data-id="${paymentMethod.idPayMethod}" name="payMethodByOrder"
										id="flexRadioDefault${paymentMethod.idPayMethod}" /> <label
										class="form-check-label"
										for="flexRadioDefault${paymentMethod.idPayMethod}">
										${paymentMethod.name} </label>
								</div>
							</c:forEach>
						</div>
						<div>
							<div class="form-check">
								<input class="form-check-input" type="checkbox" value=""
									id="flexCheckDefault"> <label class="check-label"
									for="flexCheckDefault"> Tôi đồng ý với các điều khoản
									và điều kiện mua hàng của ALOTRA </label>
							</div>
						</div>
					</div>
				</div>
				<div class="col-7">
					<div class="products-choosen">
						<h4>Các món đã chọn</h4>
						<ul class="list-product-choosen">
							<c:forEach var="milkTea" items="${listMilkTea}">
								<li class="cart-item payment-item">
									<div class="cart-item-container">
										<c:url
											value="/home/image/${milkTea.image != null ? milkTea.image : null }"
											var="imgUrl" />
										<img src="${imgUrl}" class="cart-product-image payment-product-image" />
										<div class="cart-item-info">
											<div class="d-flex align-items-center"
												style="margin-bottom: 6px">
												<p class="cart-product-name m-0">${milkTea.getName()}</p>
												<p class="cart-quantity ms-2">x${milkTea.getOrderQuantity()}</p>
											</div>
											<p class="product-size">${milkTea.getSize()}</p>
										</div>
									</div>
									<p class="cart-price cart-price-payment">${milkTea.getCost()}đ</p>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="payment-note">
						<div class="mb-3">
							<h4 for="exampleFormControlTextarea1" class="form-label">
								Ghi chú</h4>
							<textarea class="form-control" id="exampleFormControlTextarea1"
								rows="3"></textarea>
						</div>
					</div>
					<div class="payment-price">
						<h4>Tổng cộng</h4>
						<ul>
							<li>
								<p>Tổng giá tiền</p>
								<p class="payment-price-val payment-price-value">${orderProduct.getTotalPrice() }đ</p>
							</li>
							<li>
								<p>Tổng số lượng</p>
								<p class="payment-product payment-price-value">${orderProduct.getTotalProduct() }</p>
							</li>
							<li>
								<p>Phí giao hàng</p>
								<p class="payment-fee payment-price-value">0đ</p>
							</li>
							<li>
								<p>Thành tiền</p>
								<p class="payment-final-price payment-price-value">100000đ</p>
							</li>
							<li>
								<p>Ngày đặt hàng</p>
								<p class="payment-order-day payment-price-value"></p>
							</li>
							<li>
								<p>Ngày giao hàng dự kiến</p>
								<p class="payment-ship-day payment-price-value"></p>
							</li>
						</ul>
					</div>
					<button class="cart-btn-submit payment-btn">Đặt hàng</button>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src='<c:url value="/user/js/payment.js" />'></script>
</body>
</html>