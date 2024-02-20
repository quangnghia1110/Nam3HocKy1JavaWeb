<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<!-- Site meta -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" type="text/css" href="home.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
	<div class="home">
		<c:if test="${orderMessage != null }">
			<div id="toast">
				<div class="toast toast--success">
					<div class="toast__icon">
						<i class="fas fa-check-circle"></i>
					</div>
					<div class="toast__body">
						<h3 class="toast__title">Success</h3>
						<p class="toast__msg">${orderMessage }</p>
					</div>
					<a href="/order" class="btn btn-warning ms-2"
						style="font-size: 12px !important">Xem đơn hàng</a>
					<div class="toast__close">
						<i class="fas fa-times"></i>
					</div>
				</div>
			</div>
		</c:if>
		<div id="homeSlider" class="carousel slide" data-ride="carousel">
			<!--Indicators-->
			<ul class="carousel-indicators">
				<li data-target="#homeSlider" data-slide-to="0" class="active"></li>
				<li data-target="#homeSlider" data-slide-to="1"></li>
				<li data-target="#homeSlider" data-slide-to="2"></li>
			</ul>
			<!--SlideShow-->
			<div class="carousel-inner">
				<div class="carousel-item active c-item">
					<img class="c-img"
						src="https://file.hstatic.net/1000075078/file/web_desktop_aeb6f5acca5d46adad94c262dcd9ac72.jpg">
				</div>
				<div class="carousel-item c-item">
					<img class="c-img"
						src="https://file.hstatic.net/1000075078/file/desktop_b924413014a1448eb0a38024cd8bc270.jpg">
				</div>
				<div class="carousel-item c-item">
					<img class="c-img"
						src="https://file.hstatic.net/1000075078/file/web_moi_-_desktop_7f410066fea94545b59667a4063a1e09.jpg">
				</div>
			</div>

			<!--Controls-->
			<a class="carousel-control-prev" href="#homeSlider" data-slide="prev">
				<span class="carousel-control-prev-icon"></span>
			</a> <a class="carousel-control-next" href="#homeSlider"
				data-slide="next"> <span class="carousel-control-next-icon"></span>
			</a>
		</div>
		<div class="introduce">
			<div class="row">
				<div class="col">
					<div class="introduce-item">
						<img class="img-introduce"
							src="https://images.deliveryhero.io/image/fd-ph/LH/h6bn-hero.jpg" />
					</div>
				</div>
				<div class="col">
					<div class="w-100 d-flex align-items-center justify-content-center"
						style="height: 100%">
						<div class="introduce-item">
							<div class="introduce-title">Câu chuyện thương hiệu</div>
							<p class="home-desc">Được trồng trọt và chăm chút kỹ lưỡng,
								nuôi dưỡng từ thổ nhưỡng phì nhiêu, nguồn nước mát lành, bao bọc
								bởi mây và sương cùng nền nhiệt độ mát mẻ quanh năm, những búp
								trà ở Tây Bắc mập mạp và xanh mướt, hội tụ đầy đủ dưỡng chất,
								sinh khí, và tinh hoa đất trời.</p>
							<a href="https://homitatea.com/about/cau-chuyen-thuong-hieu.html"
								class="btn-explore">Khám phá</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="products">
			<p class="products-title">Sản phẩm bán chạy</p>
			<div class="row gx-1">
				<c:forEach var="milkTea" items="${list1}">
					<div class="col col-1-2">
						<a href="/product_detail/${milkTea.idMilkTea}"
							class="d-block card outstanding-item"> <span
							class="outstanding-title">BEST SELLER</span>
							<div class="img-container">
								<c:url
									value="/home/image/${milkTea.image != null ? milkTea.image : null }"
									var="imgUrl" />
								<img src="${imgUrl}" class="card-image card-img-top" />
							</div>
							<div class="card-body">
								<h5 class="card-title">${milkTea.name}</h5>
								<p class="card-price">${milkTea.cost}đ</p>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="products pb-4">
			<p class="products-title">Sản phẩm cửa hàng</p>
			<div class="row gx-1">
				<c:forEach var="milkTea" items="${list2}">
					<div class="col col-1-2">
						<a href="/product_detail/${milkTea.idMilkTea}" class="card">
							<div class="img-container">
								<c:url
									value="/home/image/${milkTea.image != null ? milkTea.image : null }"
									var="imgUrl" />
								<img src="${imgUrl}" class="card-image card-img-top" />
							</div>
							<div class="card-body">
								<h5 class="card-title">${milkTea.name}</h5>
								<p class="card-price">${milkTea.cost}đ</p>
							</div>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src='<c:url value="/user/js/toast.js" />'></script>
</body>
</html>
