<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
</head>
<body>
	<div class="products">
		<div class="row gx-2">
			<div class="col-3 p-3 ps-4" style="border-right: 1px solid #ccc">
				<div class="products-category">
					<c:set var="index" value="0"></c:set>
					<c:forEach var="category" items="${categories}">
						<span>${category.name}</span>
						<ul>
							<c:forEach var="type" items="${types[index]}">
								<li><a
									class="${type.idType == idActive ? 'products-category-link-active':''}"
									href="/products/type/${type.idType}">${type.name}</a></li>
							</c:forEach>
						</ul>
						<c:set var="index" value="${index + 1 }"></c:set>
					</c:forEach>
				</div>
			</div>

			<c:if
				test="${!milkTeas.hasContent()} && ${!milkTeaByTypes.hasContent()}">
				<div class="row">
					<div class="col">
						<div class="alter alter-danger">
							<h2>Không tìm thấy sản phẩm!</h2>
						</div>
					</div>
				</div>
			</c:if>
			<!-- List tất cả sản phẩm-->

			<c:if test="${milkTeas.hasContent()}">
				<div class="col-9 products-item"
					style="background-image: url('https://phuclong.com.vn/images/background/bg_tealeaf.svg')">
					<div class="row gx-4">
						<c:forEach var="milkTea" items="${milkTeas.content}">
							<div class="col-4">
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
					<!-- Phan trang -->
					<c:if test="${milkTeas.totalPages > 1}">
						<nav aria-label="Page navigation">
							<ul class="pagination"
								style="background-image: url('https://phuclong.com.vn/images/background/bg_tealeaf.svg')">
								<li
									class="${1==milkTeas.number + 1 ? 'page-item active' : 'page-item'}"><a
									class="page-link" href="<c:url value='/products?page=${1}'/>"
									tabindex="-1" aria-disabled="true">First</a></li>

								<c:forEach items="${pageNumbers}" var="pageNumber">
									<c:if test="${milkTeas.totalPages > 1}">
										<li
											class="${pageNumber == milkTeas.number + 1 ? 'page-item active' : 'page-item'}">
											<a class="page-link"
											href="<c:url value='/products?page=${pageNumber}'/>">${pageNumber}</a>
										</li>
									</c:if>
								</c:forEach>
								<li
									class="${milkTeas.totalPages == milkTeas.number + 1 ? 'page-item active' : 'page-item'}"><a
									class="page-link"
									href="<c:url value='/products?page=${milkTeas.totalPages}'/>">Last</a></li>
							</ul>
						</nav>
					</c:if>
					<!-- Ket thuc phan trang -->
				</div>

			</c:if>


			<!-- List theo sản phẩm tìm kiếm-->
			<c:if test="${milkTeaByTypes.hasContent()}">
				<div class="col-9 products-item">
					<div class="row gx-4">
						<c:forEach var="milkTea" items="${milkTeaByTypes.content}">
							<div class="col-4">
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
					<!-- Phan trang -->
					<c:if test="${milkTeaByTypes.totalPages > 1}">
						<nav aria-label="Page navigation">
							<ul class="pagination">
								<li
									class="${1==milkTeaByTypes.number + 1 ? 'page-item active' : 'page-item'}"><a
									class="page-link"
									href="<c:url value='/products/type/${id}?page=${1}'/>"
									tabindex="-1" aria-disabled="true">First</a></li>

								<c:forEach items="${pageNumbers}" var="pageNumber">
									<c:if test="${milkTeaByTypes.totalPages > 1}">
										<li
											class="${pageNumber == milkTeaByTypes.number + 1 ? 'page-item active' : 'page-item'}">
											<a class="page-link"
											href="<c:url value='/products/type/${id}?page=${pageNumber}'/>">${pageNumber}</a>
										</li>
									</c:if>
								</c:forEach>
								<li
									class="${milkTeaByTypes.totalPages == milkTeaByTypes.number + 1 ? 'page-item active' : 'page-item'}"><a
									class="page-link"
									href="<c:url value='/products/type/${id}?page=${milkTeaByTypes.totalPages}'/>">Last</a></li>
							</ul>
						</nav>
					</c:if>
					<!-- Ket thuc phan trang -->
				</div>

			</c:if>
		</div>
	</div>
</body>
</html>
