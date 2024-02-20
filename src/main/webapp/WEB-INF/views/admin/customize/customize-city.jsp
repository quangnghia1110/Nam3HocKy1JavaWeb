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
    <title>CẬP NHẬT THÀNH PHỐ</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="<c:url value='/templates/admin/css/styles.css'/>" rel="stylesheet" />
    <link href="<c:url value='/templates/admin/css/my-style.css'/>" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="/common/admin/header/header.jsp"%>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">CẬP NHẬT THÀNH PHỐ</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/admin/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="#">Cập nhật thành phố</a></li>
                </ol>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="<c:url value="/admin/city/saveOrUpdate"/>" method="post">
                        <!-- Name -->
                        <div class="mb-3">
                            <label for="exampleInputName" class="form-label">Tên thành phố*</label> 
                            <input placeholder="City Name" name="name" type="text" class="form-control" id="exampleInputName" aria-describedby="nameHelp" value="${city.name}" required="required">
                        </div>
                        
                         <!-- ID -->
                        <div class="mb-3">
                            <label for="exampleInputID" class="form-label">ID thành phố*</label> 
                            <input placeholder="City ID" ${city.isEdit ? 'readonly':''	} name="idCity" type="text" class="form-control" id="exampleInputID" aria-describedby="idHelp" value="${city.idCity}" required="required">
                        </div>
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
</body>
</html>
