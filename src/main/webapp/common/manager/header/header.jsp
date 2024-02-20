<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<div id="loader-wrapper">
	<div id="loader"></div>
	<div class="loader-section section-left"></div>
	<div class="loader-section section-right"></div>
</div>
<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">

	<a class="navbar-brand ps-3" href="/admin/index">MilkTea</a>

	<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
		id="sidebarToggle" href="#!">
		<i class="fas fa-bars"></i>
	</button>

	<form
		class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
		<div class="input-group"></div>
	</form>

	<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
		<li class="nav-item dropdown"><a class="nav-link dropdown-toggle"
			id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
			aria-expanded="false">Welcome <c:out
					value="${pageContext.request.remoteUser}" /><i
				class="fas fa-user fa-fw"></i></a>
			<ul class="dropdown-menu dropdown-menu-end"
				aria-labelledby="navbarDropdown">
				<li><a class="dropdown-item" href="/security/logout">Đăng
						xuất</a></li>
				<li><a class="dropdown-item" href="/security/forgot-password">Quên
						mật khẩu</a></li>
				<li><hr class="dropdown-divider"></li>
				<li><a class="dropdown-item" href="/home">Giao diện User</a></li>
			</ul></li>
	</ul>
</nav>
<div id="layoutSidenav">
	<div id="layoutSidenav_nav">
		<nav class="sb-sidenav accordion sb-sidenav-dark"
			id="sidenavAccordion">
			<div class="sb-sidenav-menu">
				<div class="nav">
					<div class="sb-sidenav-menu-heading">Trang tổng quan</div>
					<a class="nav-link" href="/manager/index">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> Báo cáo - Thống kê
					</a>


					<div class="sb-sidenav-menu-heading">Trang quản lý</div>
					<!-- Quản lý chi tiết đơn hàng -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseOrderDetail" aria-expanded="false"
						aria-controls="collapseOrderDetail">
						<div class="sb-nav-link-icon"></div> Quản lý đơn hàng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseOrderDetail"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/manager/order">Danh sách đơn hàng</a>
						</nav>
					</div>
				</div>
			</div>
		</nav>
	</div>