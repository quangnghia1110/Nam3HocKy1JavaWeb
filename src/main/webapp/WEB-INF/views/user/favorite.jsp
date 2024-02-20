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
		<p class="cart-title">Sản phẩm yêu thích của tôi</p>
		<!-- List Cart -->
		<ul class="list-cart">
			<c:forEach var="milktea" items="${listmilkteas }">
				<li class="cart-item">
					<div class="cart-item-container">
						<img
							src="https://cdn.phonebooky.com/blog/wp-content/uploads/2020/04/07010330/Brown-Sugar.jpg"
							class="cart-product-image" />
						<div class="cart-item-info">
							<p class="cart-product-name">${milktea.getName() }</p>
							<p data-name="${milktea.getCost() }" class="cart-price">${milktea.getCost() }đ</p>
						</div>
					</div>
					<div class="cart-action">
    					<div class="d-flex justify-content-center">
        					<a href="/product_detail/${milktea.idMilkTea}" type="button" class="btn btn-secondary" data-bs-dismiss="modal">
            					Xem chi tiết
        					</a>
    					</div>
					</div>
				</li>
			</c:forEach>
		</ul>

	
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