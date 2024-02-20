<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>QUẢN LÝ KHÁCH HÀNG</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link href="<c:url value='/templates/admin/css/styles.css'/>"
	rel="stylesheet" />
<link href="<c:url value='/templates/admin/css/my-style.css'/>"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<%@include file="/common/admin/header/header.jsp"%>
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h1 class="mt-4">QUẢN LÝ KHÁCH HÀNG</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a style="text-decoration: none"
						href="/admin/index">Trang chủ</a></li>
					<li class="breadcrumb-item active"><a
						style="text-decoration: none; color: black"
						href="/admin/customer-update">Cập nhật khách hàng</a></li>
				</ol>
				<div class="card mb-4">
					<form class="mt-3 ms-3 me-3 mb-3"
						action="/admin/customer/saveOrUpdate/${customer.id }"
						method="post">
						<!-- ID User -->
						<div class="mb-3">
							<label for="exampleInputUserId" class="form-label">ID
								User*</label> <input placeholder="User ID" name="id_user" type="text"
								class="form-control" id="exampleInputUserId"
								aria-describedby="userIdHelp" value="${customer.id}" ${loguser}
								required="required" disabled>
						</div>

						<!-- Surname -->
						<div class="mb-3">
							<label for="exampleInputSurname" class="form-label">Họ*</label> <input
								placeholder="Surname" name="surname" type="text"
								class="form-control" id="exampleInputSurname"
								aria-describedby="surnameHelp" value="${customer.surname}"
								required="required">
						</div>

						<!-- Name -->
						<div class="mb-3">
							<label for="exampleInputName" class="form-label">Tên*</label> <input
								placeholder="Name" name="name" type="text" class="form-control"
								id="exampleInputName" aria-describedby="nameHelp"
								value="${customer.name}" required="required">
						</div>

						<!-- Birthday -->
						<div class="mb-3">
							<label for="exampleInputBirthday" class="form-label">Ngày
								sinh*</label> <input placeholder="Birthday" name="birthday" type="date"
								class="form-control" id="exampleInputBirthday"
								value="${customer.birthday}" required="required">
						</div>

						<!-- Phone Number -->
						<div class="mb-3">
							<label for="exampleInputPhoneNumber" class="form-label">Số
								điện thoại*</label> <input placeholder="Phone Number"
								name="phone_number" type="text" class="form-control"
								id="exampleInputPhoneNumber" aria-describedby="phoneNumberHelp"
								value="${customer.phoneNumber}" required="required">
						</div>

						<!-- Email -->
						<div class="mb-3">
							<label for="exampleInputEmail" class="form-label">Email*</label>
							<input readonly placeholder="Email" name="email" type="email"
								class="form-control" id="exampleInputEmail"
								aria-describedby="emailHelp" value="${customer.email}"
								required="required">
						</div>

						<!-- Gender -->
						<div class="mb-3">
							<label for="exampleInputGender" class="form-label">Giới
								tính*</label> <select name="gender" class="form-select"
								id="exampleInputGender" required="required">
								<option value="1" ${customer.gender == 1 ? 'selected' : ''}>Nam</option>
								<option value="0" ${customer.gender == 0 ? 'selected' : ''}>Nữ</option>
							</select>
						</div>

						<!-- Additional form fields go here -->

						<div class="text-end">
							<button type="submit" class="btn btn-success">
								<c:if test="${city.isEdit}">
									<span>Update</span>
								</c:if>
								<c:if test="${!city.isEdit}">
									<span>Save</span>
								</c:if>
							</button>
						</div>
					</form>
					<h6 class="ms-3 text-primary">${message}</h6>
				</div>
			</div>
		</main>
	</div>

	<script type="text/javascript"
		src='<c:url value="/admin/js/customer.js" />'></script>
	<script src="https://momentjs.com/downloads/moment.min.js"></script>

</body>
</html>
