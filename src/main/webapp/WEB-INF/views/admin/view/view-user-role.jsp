<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>DANH SÁCH VAI TRÒ NGƯỜI DÙNG</title>
    <!-- Add your additional CSS links here -->
    <link href="<c:url value='/templates/admin/css/styles.css'/>" rel="stylesheet" />
</head>
<body class="sb-nav-fixed">
<%@include file="/common/admin/header/header.jsp"%>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">DANH SÁCH VAI TRÒ NGƯỜI DÙNGs</h1>
            <div class="card mb-4">
            	<ol class="breadcrumb mb-4">
                    <li class="breadcrumb-item"><a style="text-decoration: none" href="/admin/index">Trang chủ</a></li>
                    <li class="breadcrumb-item active"><a style="text-decoration: none; color: black" href="/admin/view-user-role">Danh sách vai trò người dùng</a></li>
                </ol>
            	<div class="card mb-4">
                	<div class="card-header">
                    	<i class="fas fa-table me-1"></i>DANH SÁCH VAI TRÒ NGƯỜI DÙNG
                    	<button class="btn btn-primary" onclick="exportToExcel()" style="margin-left: 15px">
                        	<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
                            	<style>svg{fill:#e8e8e8}</style>
                            	<path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm90.9 233.3c-8.1-10.5-23.2-12.3-33.7-4.2s-12.3 23.2-4.2 33.7L161.6 320l-44.5 57.3c-8.1 10.5-6.3 25.5 4.2 33.7s25.5 6.3 33.7-4.2L192 359.1l37.1 47.6c8.1 10.5 23.2 12.3 33.7 4.2s12.3-23.2 4.2-33.7L222.4 320l44.5-57.3c8.1-10.5 6.3-25.5-4.2-33.7s-25.5-6.3-33.7 4.2L192 280.9l-37.1-47.6z"/>
                        	</svg>
                        	Export Excel
                        </button>
                    	<button class="btn btn-success" onclick="exportToWord()" style="margin-left:15px">
                        	<svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 384 512">
                            	<style>svg{fill:#e8e8e8}</style>
                            	<path d="M48 448V64c0-8.8 7.2-16 16-16H224v80c0 17.7 14.3 32 32 32h80V448c0 8.8-7.2 16-16 16H64c-8.8 0-16-7.2-16-16zM64 0C28.7 0 0 28.7 0 64V448c0 35.3 28.7 64 64 64H320c35.3 0 64-28.7 64-64V154.5c0-17-6.7-33.3-18.7-45.3L274.7 18.7C262.7 6.7 246.5 0 229.5 0H64zm55 241.1c-3.8-12.7-17.2-19.9-29.9-16.1s-19.9 17.2-16.1 29.9l48 160c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l25-83.4 25 83.4c3 10.2 12.4 17.1 23 17.1s19.9-7 23-17.1l48-160c3.8-12.7-3.4-26.1-16.1-29.9s-26.1 3.4-29.9 16.1l-25 83.4-25-83.4c-3-10.2-12.4-17.1-23-17.1s-19.9 7-23 17.1l-25 83.4-25-83.4z"/>
                        	</svg>
                        	Export Word
                        </button>
                	</div>
                	<div class="card-body">
                    	<div class="table-responsive">
                       		<table class="table table-bordered" id="userRolesTable">
                            	<thead>
                                	<tr>
                                    	<th>Role ID</th>
                                    	<th>Username</th>
                                    	<th>Password</th>
                                    	<th>Email</th>
                                    	<th>Role Name</th>
                                    	<th>Edit</th>
                                	</tr>
                            	</thead>
                            	<tbody>
                                	<c:forEach var="userrole" items="${listUserRole}">
                                    	<tr>
                                        	<td>${userrole.user.id}</td>
                                        	<td>${userrole.user.username}</td>
                                        	<td>${userrole.user.password}</td>
                                        	<td>${userrole.user.email}</td>
                                        	<td>${userrole.role.name}</td>
                                        	<td><a class="btn btn-success" href="/admin/userrole/edit/${userrole.role_user_id}">Edit</a></td>
                                    	</tr>
                                	</c:forEach>
                            	</tbody>
                        	</table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>
<script>
	function exportToExcel() {
		// Clone bảng và loại bỏ cột cuối
    	var tableClone = $('#example1').clone();
    	tableClone.find('tr').each(function () {
        	$(this).find('th:last, td:last').remove();
    	});
    	var wb = XLSX.utils.table_to_book(tableClone[0], { sheet: "Sheet JS" });
    	XLSX.writeFile(wb, "Danh Sách Vai Trò Người Dùng.xlsx");
	}
	function exportToWord() {
    	var tableClone = $('#example1').clone();
    	tableClone.find('tr').each(function () {
        	$(this).find('th:last, td:last').remove();
    	});
    	var newHtml = tableClone.prop('outerHTML');
    	var blob = new Blob(['\ufeff', newHtml], { type: 'application/msword' });
    	var url = URL.createObjectURL(blob);
    	var a = document.createElement('a');
    	a.href = url;
    	a.download = 'Danh Sách Vai Trò Người Dùng.doc';
    	document.body.appendChild(a);
    	a.click();
    	document.body.removeChild(a);
    	URL.revokeObjectURL(url);
	}
</script>
</body>
</html>