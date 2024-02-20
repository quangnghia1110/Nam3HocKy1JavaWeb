<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>TRANG CHỦ</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link href="<c:url value='/admin/css/styles.css'/>" rel="stylesheet" />
<link href="<c:url value='/admin/css/my-style.css'/>" rel="stylesheet" />
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/xlsx/0.17.1/xlsx.full.min.js"></script>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"crossorigin="anonymous"></script>
<script src="<c:url value='/admin/assets/demo/chart-area-demo.js'/>"></script>
<script src="<c:url value='/admin/assets/demo/chart-bar-demo.js'/>"></script>
<script src="<c:url value='/admin/js/scripts.js'/>"></script>
<script src="<c:url value='/user/js/plugins.js'/>"></script>
<script	src="<c:url value='/admin/js/bootstrap.bundle.min.js'/>"></script>
<script	src="<c:url value='/admin/js/buttons.bootstrap4.min.js'/>"></script>
<script	src="<c:url value='/admin/js/buttons.colVis.min.js'/>"></script>
<script src="<c:url value='/admin/js/buttons.html5.min.js'/>"></script>
<script src="<c:url value='/admin/js/buttons.print.min.js'/>"></script>
<script	src="<c:url value='/admin/js/dataTables.bootstrap4.min.js'/>"></script>
<script	src="<c:url value='/admin/js/dataTables.buttons.min.js'/>"></script>
<script	src="<c:url value='/admin/js/dataTables.responsive.min.js'/>"></script>
<script src="<c:url value='/admin/js/jquery.dataTables.min.js'/>"></script>
<script src="<c:url value='/admin/js/jquery.min.js'/>"></script>
<script src="<c:url value='/admin/js/jszip.min.js'/>"></script>
<script src="<c:url value='/admin/js/pdfmake.min.js'/>"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/he/1.2.0/he.min.js"></script>

<script>
	$(window).on("load", function() {
		$('body').addClass('loaded');
	});
</script>
</head>
<body>
	<sitemesh:write property="body"/>
</body>
</html>