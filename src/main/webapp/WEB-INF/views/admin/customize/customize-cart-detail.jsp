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
    <title>QUẢN LÝ CHI TIẾT GIỎ HÀNG</title>
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
                <h1 class="mt-4">QUẢN LÝ CHI TIẾT GIỎ HÀNG</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/admin/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/admin/cart-detail-update">Cập nhật chi tiết giỏ hàng</a></li>
                </ol>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="/admin/customize-cart-detail/saveOrUpdate" method="post">
                        <!-- ID Cart -->
                        <div class="mb-3">
                            <label for="exampleInputCartId" class="form-label">ID Cart*</label> 
                            <input placeholder="Cart ID" name="idCart" type="text" class="form-control" id="exampleInputCartId" aria-describedby="cartIdHelp" value="${cartDetail.idCart}" ${loguser} required="required">
                        </div>

                        <!-- ID Milk Tea -->
                        <div class="mb-3">
                            <label for="exampleInputMilkTeaId" class="form-label">ID Milk Tea*</label> 
                            <input placeholder="Milk Tea ID" name="idMilkTea" type="text" class="form-control" id="exampleInputMilkTeaId" aria-describedby="milkTeaIdHelp" value="${cartDetail.idMilkTea}" required="required">
                        </div>

                        <div class="text-end">
                            <button type="submit" class="btn btn-success">
                            	<c:if test="${cartDetail.isEdit}">
                            		<span>Update</span>
                            	</c:if>
                            	<c:if test="${!cartDetail.isEdit}">
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
