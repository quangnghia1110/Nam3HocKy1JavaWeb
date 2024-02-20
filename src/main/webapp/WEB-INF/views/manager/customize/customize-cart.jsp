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
    <link href="<c:url value='/templates/manager/css/styles.css'/>" rel="stylesheet" />
    <link href="<c:url value='/templates/manager/css/my-style.css'/>" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="/common/manager/header/header.jsp"%>
    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">
                <h1 class="mt-4">QUẢN LÝ GIỎ HÀNG</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/manager/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/manager/cart-update">Cập nhật giỏ hàng</a></li>
                </ol>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="/manager/cart-update/create" method="post">
                        <!-- ID Cart -->
                        <div class="mb-3">
                            <label for="exampleInputCartId" class="form-label">ID Cart*</label> 
                            <input placeholder="Cart ID" name="id_cart" type="text" class="form-control" id="exampleInputCartId" aria-describedby="cartIdHelp" value="${cart.id_cart}" ${loguser} required="required" disabled>
                        </div>

                        <!-- ID User -->
                        <div class="mb-3">
                            <label for="exampleInputUserId" class="form-label">ID User*</label> 
                            <input placeholder="User ID" name="id_user" type="text" class="form-control" id="exampleInputUserId" aria-describedby="userIdHelp" value="${cart.id_user}" ${loguser} required="required">
                        </div>

                        <!-- Total Product -->
                        <div class="mb-3">
                            <label for="exampleInputTotalProduct" class="form-label">Số lượng sản phẩm*</label> 
                            <input placeholder="Total Product" name="total_product" type="text" class="form-control" id="exampleInputTotalProduct" aria-describedby="totalProductHelp" value="${cart.total_product}" required="required">
                        </div>

                        <!-- Total Price -->
                        <div class="mb-3">
                            <label for="exampleInputTotalPrice" class="form-label">Tổng giá*</label> 
                            <input placeholder="Total Price" name="total_price" type="text" class="form-control" id="exampleInputTotalPrice" aria-describedby="totalPriceHelp" value="${cart.total_price}" required="required">
                        </div>

                        <div class="text-end">
                            <button type="submit" class="btn btn-primary" formaction="/manager/cart-update/create" ${buttonnolog}>Thêm</button>
                            <button type="submit" class="btn btn-success" formaction="/manager/cart-update/update" ${buttonlog}>Sửa</button>
                            <button type="submit" class="btn btn-danger" formaction="/manager/cart-update/delete" ${buttonlog1} ${buttonxoa}>Xóa</button>
                        </div>
                    </form>
                    <h6 class="ms-3 text-primary">${message}</h6>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
