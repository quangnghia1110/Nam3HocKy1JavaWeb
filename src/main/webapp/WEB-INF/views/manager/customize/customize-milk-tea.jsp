<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>QUẢN LÝ TRÀ SỮA</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="<c:url value='/templates/manager/css/styles.css'/>" rel="stylesheet" />
    <link href="<c:url value='/templates/manager/css/my-style.css'/>" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
	<%@include file="/common/manager/header/header.jsp"%>
	<div id="layoutSidenav_content">
		<main>
			<div class="container-fluid px-4">
				<h1 class="mt-4">QUẢN LÝ TRÀ SỮA</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a style="text-decoration: none"
						href="/manager/index">Trang chủ</a></li>
					<li class="breadcrumb-item active"><a
						style="text-decoration: none; color: black" href="#">Cập nhật
							trà sữa</a></li>
				</ol>
				<div class="card mb-4">
					<form class="mt-3 ms-3 me-3 mb-3"
						action="<c:url value="/manager/milk-tea/saveOrUpdate"/>" method="post"
						enctype="multipart/form-data">
						<!-- ID Milk Tea -->
						<div class="mb-3">
							<label for="exampleInputMilkTeaId" class="form-label">ID
								Milk Tea*</label> <input placeholder="Milk Tea ID" name="idMilkTea"
								type="text" class="form-control" id="exampleInputMilkTeaId"
								aria-describedby="milkTeaIdHelp" value="${milkTea.idMilkTea}"
								${loguser} required="required" disabled>
						</div>

						<!-- Name -->
						<div class="mb-3">
							<label for="exampleInputName" class="form-label">Tên trà
								sữa*</label> <input placeholder="Name" name="name" type="text"
								class="form-control" id="exampleInputName"
								aria-describedby="nameHelp" value="${milkTea.name}"
								required="required">
						</div>

						<!-- Cost -->
						<div class="mb-3">
							<label for="exampleInputCost" class="form-label">Giá*</label> <input
								placeholder="Cost" name="cost" type="text" class="form-control"
								id="exampleInputCost" aria-describedby="costHelp"
								value="${milkTea.cost}" required="required">
						</div>

						<!-- Description -->
						<div class="mb-3">
							<label for="exampleInputDescription" class="form-label">Mô
								tả*</label>
							<textarea placeholder="Description" name="description"
								class="form-control" id="exampleInputDescription" rows="3"
								required="required">${milkTea.description}</textarea>
						</div>

						<!-- ID Type -->
						<div class="mb-3">
							<label for="exampleInputTypeId" class="form-label">ID
								Type*</label> <input placeholder="Type ID"
								${milkTea.isEdit ? 'readonly':'' } name="milkTeaTypeId"
								type="text" class="form-control" id="exampleInputTypeId"
								aria-describedby="typeIdHelp"
								value="${milkTea.milkTeaTypeByMilkTea.idType}"
								required="required">
						</div>

						<!-- Image -->
						<script type="text/javascript">
							function chooseFile(fileInput) {
								if (fileInput.files && fileInput.files[0]) {
									var reader = new FileReader();
									reader.onload = function(e) {
										document.querySelector("#image")
												.setAttribute('src',
														e.target.result);
										document.querySelector("#image").classList
												.remove("hidden");
									}
									reader.readAsDataURL(fileInput.files[0]);
								}
							}
						</script>
						<div class="mb-3" style="display: flex; flex-direction: column;">
							<label for="exampleInputImage" class="form-label">Hình
								ảnh*</label>
							<c:url
								value="/manager/branch/image/${milkTea.image != null ? milkTea.image : null }"
								var="imgUrl" />
							<input type="hidden" name="image" value="${milkTea.image}">
							<img class="${milkTea.image == null ? 'hidden':''}" id="image"
								width="200px" height="200px" src="${imgUrl}" /> <input
								onchange="chooseFile(this)" placeholder="Image" name="imageFile"
								type="file" class="form-control-file"
								aria-describedby="imageFile">
						</div>
						<div class="text-end">
							<button type="submit" class="btn btn-success">
								<c:if test="${milkTea.isEdit}">
									<span>Update</span>
								</c:if>
								<c:if test="${!milkTea.isEdit}">
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
</body>
</html>

