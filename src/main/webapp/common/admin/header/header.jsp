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
					<a class="nav-link" href="/admin/index">
						<div class="sb-nav-link-icon">
							<i class="fas fa-tachometer-alt"></i>
						</div> Báo cáo - Thống kê
					</a>


					<div class="sb-sidenav-menu-heading">Trang quản lý</div>
					<!-- Quản lý vai trò người dùng-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseUserRole" aria-expanded="false"
						aria-controls="collapseUserRole">
						<div class="sb-nav-link-icon"></div> Quản lý vai trò người dùng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseUserRole"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/userrole">Danh sách
								vai trò người dùng</a> 
						</nav>
					</div>
					<!-- Quản lý chi nhánh -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseBranch" aria-expanded="false"
						aria-controls="collapseBranch">
						<div class="sb-nav-link-icon"></div> Quản lý chi nhánh
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseBranch"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/branch">Danh sách chi nhánh</a>
							<a class="nav-link" href="/admin/branch/add">Cập nhật chi
								nhánh</a>
						</nav>
					</div>
					<!-- Quản lý thành phố -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseCity" aria-expanded="false"
						aria-controls="collapseCity">
						<div class="sb-nav-link-icon"></div> Quản lý thành phố
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseCity"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/city">Danh sách thành phố</a> <a
								class="nav-link" href="/admin/city/add">Cập nhật thành phố</a>
						</nav>
					</div>
					<!-- Quản lý khách hàng -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseCustomer" aria-expanded="false"
						aria-controls="collapseCustomer">
						<div class="sb-nav-link-icon"></div> Quản lý khách hàng
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseCustomer"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/customer">Danh sách khách
								hàng</a>
						</nav>
					</div>
					<!-- Quản lý loại trà sữa-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseMilkTeaType" aria-expanded="false"
						aria-controls="collapseMilkTeaType">
						<div class="sb-nav-link-icon"></div> Quản lý loại trà sữa
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseMilkTeaType"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/milk-tea-type">Danh sách
								loại trà sữa</a> <a class="nav-link" href="/admin/milk-tea-type/add">Cập
								nhật loại trà sữa</a>
						</nav>
					</div>
					<!-- Quản lý chi nhánh - trà sữa-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseBranchMilkTeaType" aria-expanded="false" aria-controls="collapseBranchMilkTeaType">
						<div class="sb-nav-link-icon">
							
						</div> Quản lý chi nhánh - trà sữa
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseBranchMilkTeaType" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/branch-milk-tea">Danh sách loại trà sữa</a> 
							<a class="nav-link" href="/admin/branch-milk-tea/add">Cập nhật loại trà sữa</a>
						</nav>
					</div>
					<!-- Quản lý trà sữa -->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseMilkTea" aria-expanded="false"
						aria-controls="collapseMilkTea">
						<div class="sb-nav-link-icon"></div> Quản lý trà sữa
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseMilkTea"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/milk-tea">Danh sách trà sữa</a>
							<a class="nav-link" href="/admin/milk-tea/add">Cập nhật trà
								sữa</a>
						</nav>
					</div>
					<!-- Quản lý danh mục trà sữa-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapseMilkTeaCategory" aria-expanded="false"
						aria-controls="collapseMilkTeaCategory">
						<div class="sb-nav-link-icon"></div> Quản lý danh mục trà sữa
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapseMilkTeaCategory"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/category">Danh sách danh mục
								trà sữa</a> <a class="nav-link" href="/admin/category/add">Cập
								nhật danh mục trà sữa</a>
						</nav>
					</div>
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
							<a class="nav-link" href="/admin/order">Danh sách
								đơn hàng</a> 
						</nav>
					</div>
					<!-- Quản lý phương thức thanh toán-->
					<a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
						data-bs-target="#collapsePaymethod" aria-expanded="false"
						aria-controls="collapsePaymethod">
						<div class="sb-nav-link-icon"></div> Quản lý phương thức thanh
						toán
						<div class="sb-sidenav-collapse-arrow">
							<i class="fas fa-angle-down"></i>
						</div>
					</a>
					<div class="collapse" id="collapsePaymethod"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/paymethod">Danh sách phương thức thanh toán</a> 
							<a class="nav-link" href="/admin/paymethod/add">Cập nhật phương thức thanh toán</a>
						</nav>
					</div>
					<div class="collapse" id="collapseUserOrder"
						aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
						<nav class="sb-sidenav-menu-nested nav">
							<a class="nav-link" href="/admin/view-user-order">Danh sách
								đơn hàng người dùng</a> <a class="nav-link"
								href="/admin/customize-user-order">Cập nhật đơn hàng người
								dùng</a>
						</nav>
					</div>
				</div>
			</div>
		</nav>
	</div>