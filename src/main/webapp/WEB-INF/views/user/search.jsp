<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="search.css" />
</head>
<body>
	<p class="search-content">
		Kết quả tìm kiếm cho từ khóa "<span style="color: red;">${content}</span>"
	</p>
	<div style="margin-top: 20px; margin-left: 50px;">
		<h3 style="display: inline-block;">Sắp xếp theo:</h3>
		<a href="/header/search/content=${content}/method=outstanding">
			<button type="button" class="btn btn-success">bán chạy</button>
		</a>
		<div class="btn-group">
			<button type="button" class="btn btn-warning dropdown-toggle"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				Giá</button>
			<div class="dropdown-menu">
				<a class="dropdown-item"
					href="/header/search/content=${content}/method=low-to-high">Giá:
					Thấp đến cao </a> <a class="dropdown-item"
					href="/header/search/content=${content}/method=high-to-low">Giá:
					Cao đến thấp </a>
			</div>
		</div>
	</div>

	<div class="products">
		<c:if test="${milkTeas.hasContent()}">
			<div class="col-9 products-item">
				<div class="row gx-4">
					<c:forEach var="milkTea" items="${milkTeas.content}">
						<div class="col-3">
							<a href="/product_detail/${milkTea.idMilkTea}" class="card">
								<div class="img-container">
									<c:url
										value="/home/image/${milkTea.image != null ? milkTea.image : null }"
										var="imgUrl" />
									<img src="${imgUrl}" class="card-image card-img-top" />
								</div>
								<div class="card-body">
									<h5 class="card-title">${milkTea.name}</h5>
									<p class="card-price">${milkTea.cost}</p>
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
								class="page-link"
								href="<c:url value='/header/search?page=${1}'/>" tabindex="-1"
								aria-disabled="true">First</a></li>

							<c:forEach items="${pageNumbers}" var="pageNumber">
								<c:if test="${milkTeas.totalPages > 1}">
									<li
										class="${pageNumber == milkTeas.number + 1 ? 'page-item active' : 'page-item'}">
										<a class="page-link"
										href="<c:url value='/header/search?page=${pageNumber}'/>">${pageNumber}</a>
									</li>
								</c:if>
							</c:forEach>
							<li
								class="${milkTeas.totalPages == milkTeas.number + 1 ? 'page-item active' : 'page-item'}"><a
								class="page-link"
								href="<c:url value='/header/search?page=${milkTeas.totalPages}'/>">Last</a></li>
						</ul>
					</nav>
				</c:if>
			</div>
		</c:if>

		<c:if test="${milkTeasByNames.hasContent()}">
			<div class="col-9 products-item">
				<div class="row gx-4">
					<c:forEach var="milkTea" items="${milkTeasByNames.content}">
						<div class="col-3">
							<a href="/product_detail/${milkTea.idMilkTea}" class="card">
								<div class="img-container">
									<c:url
										value="/home/image/${milkTea.image != null ? milkTea.image : null }"
										var="imgUrl" />
									<img src="${imgUrl}" class="card-image card-img-top" />
								</div>
								<div class="card-body">
									<h5 class="card-title">${milkTea.name}</h5>
									<p class="card-price">${milkTea.cost}</p>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
				<!-- Phan trang -->
				<c:if test="${milkTeasByNames.totalPages > 1}">
					<nav aria-label="Page navigation">
						<ul class="pagination"
							style="background-image: url('https://phuclong.com.vn/images/background/bg_tealeaf.svg')">
							<li
								class="${1==milkTeasByNames.number + 1 ? 'page-item active' : 'page-item'}"><a
								class="page-link"
								href="<c:url value='/header/search/content=${name}?page=${1}'/>"
								tabindex="-1" aria-disabled="true">First</a></li>

							<c:forEach items="${pageNumbers}" var="pageNumber">
								<c:if test="${milkTeasByNames.totalPages > 1}">
									<li
										class="${pageNumber == milkTeasByNames.number + 1 ? 'page-item active' : 'page-item'}">
										<a class="page-link"
										href="<c:url value='/header/search/content=${name}?page=${pageNumber}'/>">${pageNumber}</a>
									</li>
								</c:if>
							</c:forEach>
							<li
								class="${milkTeasByNames.totalPages == milkTeasByNames.number + 1 ? 'page-item active' : 'page-item'}"><a
								class="page-link"
								href="<c:url value='/header/search/content=${name}?page=${milkTeasByNames.totalPages}'/>">Last</a></li>
						</ul>
					</nav>
				</c:if>
			</div>
		</c:if>

		<c:if test="${milkTeaBySorts.hasContent()}">
			<div class="col-9 products-item">
				<div class="row gx-4">
					<c:forEach var="milkTea" items="${milkTeaBySorts.content}">
						<div class="col-3">
							<a href="/product_detail/${milkTea.idMilkTea}" class="card">
								<div class="img-container">
									<c:url
										value="/home/image/${milkTea.image != null ? milkTea.image : null }"
										var="imgUrl" />
									<img src="${imgUrl}" class="card-image card-img-top" />
								</div>
								<div class="card-body">
									<h5 class="card-title">${milkTea.name}</h5>
									<p class="card-price">${milkTea.cost}</p>
								</div>
							</a>
						</div>
					</c:forEach>
				</div>
				<!-- Phan trang -->
				<c:if test="${milkTeaBySorts.totalPages > 1}">
					<nav aria-label="Page navigation">
						<ul class="pagination"
							style="background-image: url('https://phuclong.com.vn/images/background/bg_tealeaf.svg')">
							<li
								class="${1==milkTeaBySorts.number + 1 ? 'page-item active' : 'page-item'}"><a
								class="page-link"
								href="<c:url value='/header/search/content=${name}/method=${method}?page=${1}'/>"
								tabindex="-1" aria-disabled="true">First</a></li>

							<c:forEach items="${pageNumbers}" var="pageNumber">
								<c:if test="${milkTeaBySorts.totalPages > 1}">
									<li
										class="${pageNumber == milkTeaBySorts.number + 1 ? 'page-item active' : 'page-item'}">
										<a class="page-link"
										href="<c:url value='/header/search/content=${name}/method=${method}?page=${pageNumber}'/>">${pageNumber}</a>
									</li>
								</c:if>
							</c:forEach>
							<li
								class="${milkTeaBySorts.totalPages == milkTeaBySorts.number + 1 ? 'page-item active' : 'page-item'}"><a
								class="page-link"
								href="<c:url value='/header/search/content=${name}/method=${method}?page=${milkTeaBySorts.totalPages}'/>">Last</a></li>
						</ul>
					</nav>
				</c:if>
			</div>
		</c:if>

	</div>
</body>
</html>
