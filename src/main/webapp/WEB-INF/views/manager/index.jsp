<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<body class="sb-nav-fixed">
	<%@include file="/common/manager/header/header.jsp"%>

	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h4 class="mt-3" style="text-align: center">Tên chi nhánh: <i class="text-danger">${branch.name }</i></h4>
				<h4 style="text-align: center">Địa chỉ chi nhánh: <i class="text-danger">${branch.addressDetail }</i></h4>
				<h1 class="mt-4">BÁO CÁO - THỐNG KÊ</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item active">Báo cáo - Thống kê</li>
				</ol>
				<div id="report" class="row">
					<div class="col-xl-6 col-md-6">
						<div class="card bg-warning text-white mb-4">
							<div class="card-body">Tổng số đơn hàng</div>
							<h2 class="ms-3">${countOrder}<i
									class="fas fad fa-shopping-cart float-end me-2"></i>
							</h2>
						</div>
					</div>
					<div class="col-xl-6 col-md-6">
						<div class="card bg-success text-white mb-4">
							<div class="card-body">Tổng số sản phẩm</div>
							<h2 class="ms-3">${countProduct}<i
									class="fas fad fa-glass-martini float-end me-2"></i>
							</h2>
						</div>
					</div>
				</div>
			</div>
		</main>
	</div>

</body>

</html>

