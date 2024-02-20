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
<link href='<c:url value="/css/product_detail.css"/>' rel="stylesheet"
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
	<!-- Breadcrumb -->
	<div class="container" style="margin-top: 120px">
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
		<div class="row">
			<div class="col">
				<nav aria-label="breadcrumb">
					<!-- Show message -->
					<c:if test="${cartMessage != null}">
						<div class="alert" role="alert">
							<c:choose>
								<c:when test="${cartMessage eq 'success'}">
									<div class="alert alert-success">
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">&times;</button>
										<i>Bạn đã thêm sản phẩm này vào <a
											class="black-text bold-text" href="/cart">giỏ hàng</a> thành
											công.
										</i>
									</div>
								</c:when>
								<c:when test="${cartMessage eq 'fail'}">
									<div class="alert alert-danger">
										<button type="button" class="close" data-dismiss="alert"
											aria-label="Close">&times;</button>
										<i>Sản phẩm này đã có trong <a
											class="black-text bold-text" href="/cart">giỏ hàng</a> của
											bạn.
										</i>
									</div>
								</c:when>
							</c:choose>
						</div>
					</c:if>
					<!-- End: message -->
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a class="black-text bold-text"
							href="/products">Menu</a></li>
						<li class="breadcrumb-item"><a class="black-text bold-text"
							href="/products/type/${milkTea.milkTeaTypeId }">${milkTea.milkTeaType}</a>
						</li>
						<li class="breadcrumb-item active bold-text" aria-current="page">
							${milkTea.name}</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!-- End: Breadcrumb -->

	<!-- Product detail -->
	<div class="container">
		<div class="row">
			<!-- Main product image -->
			<div class="col-12 col-lg-6">
				<div class="card mb-3 no-border">
					<div class="card-body" style="padding: 0;">
						<a href="" data-toggle="modal" data-target="#productModal"> <c:url
								value="/home/image/${milkTea.image != null ? milkTea.image : null }"
								var="imgUrl" /> <img src="${imgUrl}" class="img-fluid"
							style="border-radius: 10px;" />
						</a>
					</div>
				</div>
			</div>

			<!-- Add to cart | Buy now -->
			<div class="col-12 col-lg-6 add_to_cart_block">
				<div data-name="${milkTea.idMilkTea }" id="card-id"
					class="card mb-3 no-border">
					<div class="card-body">
						<p class="h3 bold-text">${milkTea.name}</p>
						<p data-name="${milkTea.cost }"
							class="h4 price bold-text text-danger">${milkTea.cost}đ</p>
						<form method="get" action="">
							<div class="form-group">
								<label class="mt-2 fs-18 ml-6 bold-text fst-italic">Chọn
									size</label><br />
								<button type="button"
									class="btn btn-outline-dark active medium-size-btn"
									onclick="changeSize('Vừa')">Vừa +0đ</button>
								<button type="button"
									class="btn btn-outline-dark ml-1 large-size-btn"
									onclick="changeSize('Lớn')">Lớn +5.000đ</button>
							</div>
							<div class="form-group">
								<button type="button"
									class="btn btn-outline-dark btn-lg mt-2 bold-text"
									style="width: 215px;">
									<a class="no-decor-text black-text add-to-cart-btn"
										href="/product_detail/addtocart?id=${milkTea.idMilkTea}&&size=Vừa">Thêm
										vào giỏ hàng</a>
								</button>
								<button type="button"
									class="btn btn-dark btn-lg ml-1 mt-2 bold-text"
									style="width: 215px;">
									<div class="no-decor-text white-text buy-now-btn">Mua
										ngay</div>
								</button>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- End: Add to cart | Buy now -->
		</div>
		<!-- End: Product detail -->

		<!-- Description -->
		<div class="container">
			<div class="row">
				<div class="col-12">
					<hr style="border: thin solid black;">
					<h5 class="bold-text black-text mt-2">Mô tả sản phẩm</h5>
					<p style="font-weight: 500;">${milkTea.description}</p>
					<hr class="mt-2" style="border: thin solid #B6B6B6;">
				</div>
			</div>
		</div>
		<!-- End: Description -->

		<!-- Relevant products -->
		<div class="container mb-2">
			<div class="row">
				<div class="col-12">
					<h5 class="bold-text black-text mt-2">Sản phẩm liên quan</h5>
				</div>
				<c:forEach var="milkTea" items="${relevantProducts }">
					<div class="col-lg-3 col-sm-12 mt-2">
						<a href="/product_detail/${milkTea.idMilkTea }" class="card">
							<c:url
								value="/home/image/${milkTea.image != null ? milkTea.image : null }"
								var="imgUrl" /> <img src="${imgUrl}" class="card-img-top" />
							<div class="card-body">
								<p class="card-title bold-text">${milkTea.name }
								<p class="black-text"></p>
								</p>
								<p class="card-price" style="font-size: 20px">${milkTea.cost }đ</p>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<!-- End: Relevant products -->
	</div>

	<script type="text/javascript"
		src='<c:url value="/user/js/toast.js" />'></script>
	<script type="text/javascript"
		src='<c:url value="/user/js/product_detail.js" />'></script>
</body>
</html>