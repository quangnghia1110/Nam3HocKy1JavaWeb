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
    <title>QUẢN LÝ CHI TIẾT ĐƠN HÀNG</title>
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
                <h1 class="mt-4">QUẢN LÝ CHI TIẾT ĐƠN HÀNG</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/manager/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/manager/order-detail-update">Cập nhật chi tiết đơn hàng</a></li>
                </ol>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="/manager/order-detail-update/create" method="post">
                        <!-- ID Order -->
                        <div class="mb-3">
                            <label for="exampleInputOrderId" class="form-label">ID Order*</label> 
                            <input placeholder="Order ID" name="id_order" type="text" class="form-control" id="exampleInputOrderId" aria-describedby="orderIdHelp" value="${orderDetail.id_order}" ${loguser} required="required">
                        </div>

                        <!-- ID Milk Tea -->
                        <div class="mb-3">
                            <label for="exampleInputMilkTeaId" class="form-label">ID Milk Tea*</label> 
                            <input placeholder="Milk Tea ID" name="id_milk_tea" type="text" class="form-control" id="exampleInputMilkTeaId" aria-describedby="milkTeaIdHelp" value="${orderDetail.id_milk_tea}" required="required">
                        </div>

                        <!-- Quantity -->
                        <div class="mb-3">
                            <label for="exampleInputQuantity" class="form-label">Số lượng*</label> 
                            <input placeholder="Quantity" name="quantity" type="text" class="form-control" id="exampleInputQuantity" aria-describedby="quantityHelp" value="${orderDetail.quantity}" required="required">
                        </div>

                        <!-- Size -->
                        <div class="mb-3">
                            <label for="exampleInputSize" class="form-label">Kích thước*</label> 
                            <input placeholder="Size" name="size" type="text" class="form-control" id="exampleInputSize" aria-describedby="sizeHelp" value="${orderDetail.size}" required="required">
                        </div>

                        <!-- Note -->
                        <div class="mb-3">
                            <label for="exampleInputNote" class="form-label">Ghi chú*</label> 
                            <textarea placeholder="Note" name="note" class="form-control" id="exampleInputNote" rows="3" required="required">${orderDetail.note}</textarea>
                        </div>

                        <div class="text-end">
                            <button type="submit" class="btn btn-primary" formaction="/manager/order-detail-update/create" ${buttonnolog}>Thêm</button>
                            <button type="submit" class="btn btn-success" formaction="/manager/order-detail-update/update" ${buttonlog}>Sửa</button>
                            <button type="submit" class="btn btn-danger" formaction="/manager/order-detail-update/delete" ${buttonlog1} ${buttonxoa}>Xóa</button>
                        </div>
                    </form>
                    <h6 class="ms-3 text-primary">${message}</h6>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
