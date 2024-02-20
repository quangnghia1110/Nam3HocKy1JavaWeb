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
    <title>QUẢN LÝ GIỎ HÀNG</title>
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
                <h1 class="mt-4">QUẢN LÝ GIỎ HÀNG</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/admin/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/admin/cart-update">Cập nhật giỏ hàng</a></li>
                </ol>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="<c:url value="/admin/customize-cart/saveOrUpdate"/>" method="post">
                        <!-- ID User -->
                        <div class="mb-3">
                            <label for="exampleInputUserId" class="form-label">ID User*</label> 
                            <input placeholder="User ID" name="idUser" type="text" class="form-control" id="idUser" aria-describedby="userIdHelp" value="${cart.idUser}" required="required">
                        </div>

                        <!-- Total Product -->
                        <div class="mb-3">
                            <label for="exampleInputTotalProduct" class="form-label">Số lượng sản phẩm*</label> 
                            <input placeholder="Total Product" name="totalProduct" type="text" class="form-control" id="totalProduct" aria-describedby="totalProductHelp" value="${cart.totalProduct}" required="required">
                        </div>

                        <!-- Total Price -->
                        <div class="mb-3">
                            <label for="exampleInputTotalPrice" class="form-label">Tổng giá*</label> 
                            <input placeholder="Total Price" name="totalPrice" type="text" class="form-control" id="totalPrice" aria-describedby="totalPriceHelp" value="${cart.totalPrice}" required="required">
                        </div>

                        <div class="text-end">
                            <button type="submit" class="btn btn-success">
                            	<c:if test="${cart.isEdit}">
                            		<span>Update</span>
                            	</c:if>
                            	<c:if test="${!cart.isEdit}">
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
