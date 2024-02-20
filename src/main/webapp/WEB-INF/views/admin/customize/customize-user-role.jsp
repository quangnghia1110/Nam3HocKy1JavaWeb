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
<title>QUẢN LÝ VAI TRÒ NGƯỜI DÙNG</title>
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
				<h1 class="mt-4">QUẢN LÝ VAI TRÒ NGƯỜI DÙNG</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a style="text-decoration: none"
						href="/admin/index">Trang chủ</a></li>
					<li class="breadcrumb-item active"><a
						style="text-decoration: none; color: black"
						href="/admin/user-role-update">Cập nhật vai trò người dùng</a></li>
				</ol>
				<div class="card mb-4">
					<form class="mt-3 ms-3 me-3 mb-3"
						action="/admin/userrole/saveOrUpdate" method="post">
						<!-- ID Role -->
						<div class="mb-3">
							<label for="exampleInputRoleId" class="form-label">ID
								Role*</label> <input readonly="readonly" placeholder="Role ID"
								name="role_user_id" type="text" class="form-control"
								id="exampleInputRoleId" aria-describedby="roleIdHelp"
								value="${userRole.role_user_id}" required="required">
						</div>

						<!-- ID Role -->
						<div class="mb-3">
							<label for="exampleInputRoleId" class="form-label">User
								ID</label> <input readonly name="user_id" type="text"
								class="form-control" id="exampleInputUserId"
								aria-describedby="roleIdHelp" value="${userRole.user.id}"
								required="required">
						</div>

						<!-- ID Role -->
						<div class="mb-3">
							<label for="exampleInputRoleId" class="form-label">User
								Name</label> <input readonly name="" type="text" class="form-control"
								id="exampleInputUserName" aria-describedby="roleIdHelp"
								value="${userRole.user.username}" ${loguser} required="required">
						</div>

						<!-- ID Role -->
						<div class="mb-3">
							<label for="exampleInputRoleId" class="form-label">Email</label>
							<input readonly name="" type="text" class="form-control"
								id="exampleInputEmail" aria-describedby="roleIdHelp"
								value="${userRole.user.email}" required="required">
						</div>

						<!-- Name -->
						<div class="mb-3">
							<label for="exampleInputRole" class="form-label">Vai trò*</label>
							<select name="role_id" class="form-select" id="exampleInputRole"
								required="required">
								<c:forEach var="role" items="${listRole }">
									<option value="${role.id }"
										${role.id == userRole.role.id ? 'selected' : ''}>${role.name }</option>
								</c:forEach>
							</select> 
						</div>
						<div class="mb-3 idBranchBlock ${userRole.role.id eq 'MANAGER' ? 'd-block' : 'd-none' }">
							<label for="exampleInputIdBranch" class="form-label">Chọn cửa hàng quản lý</label>
							<select name="idBranch" class="form-select"
								id="exampleInputIdBranch" required="required">
								<c:forEach var="branch" items="${listBranch }">
									<option value="${branch.idBranch }" "${branch.idBranch == idBranch && idBranch != null ? 'checked' : '' }">${branch.name }</option>
								</c:forEach>
							</select>
						</div>
				</div>

				<div class="text-end">
					<button type="submit" class="btn btn-success">
						<c:if test="${branch.isEdit}">
							<span>Update</span>
						</c:if>
						<c:if test="${!branch.isEdit}">
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
		src='<c:url value="/admin/js/custom-user-role.js" />'></script>
</body>
</html>
