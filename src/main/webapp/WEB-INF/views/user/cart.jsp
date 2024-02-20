<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<!-- Content -->
	<div class="content" style="margin-top: 80px">
		<!--  Title-->
		<p class="cart-title">Giỏ hàng của tôi</p>

		<c:if test="${message != null }">
			<div id="toast">
				<div
					class="toast ${status == 'success' ? 'toast--success' : 'toast--error' }">
					<div class="toast__icon">
						<i
							class="${status == 'success' ? 'fas fa-check-circle' : 'fas fa-exclamation-circle' }"></i>
					</div>
					<div class="toast__body">
						<h3 class="toast__title">${status == 'success' ? 'Success' : 'Error' }</h3>
						<p class="toast__msg">${message }</p>
					</div>
					<div class="toast__close">
						<i class="fas fa-times"></i>
					</div>
				</div>
			</div>
		</c:if>
		<!-- List Cart -->
		<ul class="list-cart">
			<c:forEach var="milktea" items="${listmilkteas }">
				<li class="cart-item">
					<div class="cart-item-container">
						<div class="checkbox-wrapper-42">
							<input value="${milktea.idMilkTea }" type="checkbox"
								class="checkbox-element" /> <label class="cbx"></label>
						</div>
						<c:url
							value="/cart/image/${milktea.image != null ? milktea.image : null }"
							var="imgUrl" />
						<img src="${imgUrl}" class="cart-product-image" />
						<div class="cart-item-info">
							<p class="cart-product-name">${milktea.getName() }</p>
							<span data-name="${milktea.getSize() }" class="cart-size">${milktea.getSize() }</span>
							<p data-name="${milktea.getCost() }" class="cart-price">${milktea.getCost() }đ</p>
						</div>
					</div>
					<div class="cart-action">
						<div data-id="${milktea.idMilkTea }"
							data-name="${milktea.getName() }" class="cart-btn-delete"
							data-bs-toggle="modal" data-bs-target="#exampleModal">
							<i class="fa-solid fa-trash"></i>
						</div>
						<div class="cart-modify-quantity">
							<div class="cart-modify-quantity-desc">
								<i class="fa-solid fa-minus"></i>
							</div>
							<input value="1" class="cart-quantity-input" />
							<div class="cart-modify-quantity-asc">
								<i class="fa-solid fa-plus"></i>
							</div>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>

		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<span class="d-none modal-product-id"></span> Bạn có muốn xóa sản
						phẩm <span class="modal-product-name">1</span> và size = <span
							class="modal-product-size">Lớn</span>?
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary btn-yes">Yes</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Total price -->
		<div class="order-container">
			<!-- Check box -->
			<div class="check-container">
				<div class="checkbox-wrapper-42">
					<input type="checkbox" class="checkbox-select-all" /> <label
						class="cbx"></label>
				</div>
				<label class="check-title">Chọn tất cả</label>
			</div>

			<!-- Total Price -->
			<div class="total-price">
				<span class="total-price-title">Tổng giá:</span> <span
					class="cart-sum-price" style="font-size: 30px;">0đ</span>
			</div>

			<!-- <button class="order-btn">Đặt hàng</button> -->
			<button class="cart-btn-submit" type="submit">Đặt hàng</button>
		</div>
	</div>

	<script type="text/javascript"
		src='<c:url value="/user/js/toast.js" />'></script>
	<script type="text/javascript" src='<c:url value="/user/js/cart.js" />'></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous"></script>
</body>
</html>