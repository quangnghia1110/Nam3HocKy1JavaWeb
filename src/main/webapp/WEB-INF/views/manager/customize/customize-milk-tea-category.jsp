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
    <title>QUẢN LÝ DANH MỤC TRÀ SỮA</title>
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
                <h1 class="mt-4">QUẢN LÝ DANH MỤC TRÀ SỮA</h1>
                <ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/project_9_web/manager/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/project_9_web/manager/milk-tea-category-update">Cập nhật danh mục trà sữa</a></li>
                </ol>
                <div class="card mb-4">
                    <form class="mt-3 ms-3 me-3 mb-3" action="/project_9_web/manager/milk-tea-category-update/create" method="post">
                        <!-- ID Category -->
                        <div class="mb-3">
                            <label for="exampleInputCategoryId" class="form-label">ID Category*</label> 
                            <input placeholder="Category ID" name="id_category" type="text" class="form-control" id="exampleInputCategoryId" aria-describedby="categoryIdHelp" value="${milkTeaCategory.id_category}" ${loguser} required="required" disabled>
                        </div>

                        <!-- Name -->
                        <div class="mb-3">
                            <label for="exampleInputName" class="form-label">Tên danh mục trà sữa*</label> 
                            <input placeholder="Name" name="name" type="text" class="form-control" id="exampleInputName" aria-describedby="nameHelp" value="${milkTeaCategory.name}" required="required">
                        </div>
                        
                        <div class="text-end">
                            <button type="submit" class="btn btn-primary" formaction="/project_9_web/manager/milk-tea-category-update/create" ${buttonnolog}>Thêm</button>
                            <button type="submit" class="btn btn-success" formaction="/project_9_web/manager/milk-tea-category-update/update" ${buttonlog}>Sửa</button>
                            <button type="submit" class="btn btn-danger" formaction="/project_9_web/manager/milk-tea-category-update/delete" ${buttonlog1} ${buttonxoa}>Xóa</button>
                        </div>
                    </form>
                    <h6 class="ms-3 text-primary">${message}</h6>
                </div>
            </div>
        </main>
    </div>
</body>
</html>
