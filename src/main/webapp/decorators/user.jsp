<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="https://raw.githubusercontent.com/ThaiVanHandSome/logo/master/icons8-bubble-tea-100.png">
<title>ALOTRA</title>
<link href='<c:url value="/user/css/header.css" />' rel="stylesheet" />
<link href='<c:url value="/user/css/footer.css" />' rel="stylesheet" />
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,300;0,400;0,500;0,600;0,700;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet">
<link href='<c:url value="/user/css/home.css" />' rel="stylesheet" />
<link href='<c:url value="/user/css/payment.css"/>' rel="stylesheet"
	type="text/css">
<link href='<c:url value="/user/css/product_detail.css"/>'
	rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/order.css"/>' rel="stylesheet"
	type="text/css">
<link href='<c:url value="/user/css/branches.css"/>' rel="stylesheet"
	type="text/css">
<link href='<c:url value="/user/css/branches_info.css"/>'
	rel="stylesheet" type="text/css">
<link href='<c:url value="/user/css/cart.css"/>' rel="stylesheet"
	type="text/css">
<link href='<c:url value="/user/css/user_infor.css"/>' rel="stylesheet"
	type="text/css">
<link href='<c:url value="/user/css/products.css"/>' rel="stylesheet"
	type="text/css">
<link href='<c:url value="/user/css/search.css"/>' rel="stylesheet"
	type="text/css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/common/user/header/header.jsp"%>
	<sitemesh:write property='body' />
	<%@ include file="/common/user/footer/footer.jsp"%>

	<!-- JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		type="text/javascript"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		type="text/javascript"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		type="text/javascript"></script>
	    <script type="text/javascript" src="https://popupsmart.com/freechat.js"></script>
	
	<script>
    window.start.init({
        title: "AloTra support",
        message: "Chào quý khách, tôi là nhân viên chăm sóc khách hàng của AloTra, tôi có thể giúp gì cho quý khách ạ",
        color: "#1C86FA",
        position: "right",
        placeholder: "Nhập tin nhắn của bạn vào đâ",
        withText: "Write with",
        gty: "Go to your",
        awu: "and write us",
        connect: "Connect now",
        button: "Chat with us",
        device: "everywhere",
        logo: "https://png.pngtree.com/png-clipart/20200701/original/pngtree-milk-tea-logo-png-image_5405468.jpg",
        person: "https://png.pngtree.com/png-vector/20190115/ourlarge/pngtree-avatar-male-icon-design-vector-png-image_316168.jpg",
        services: [
            {
                "name": "messenger",
                "content": "61554287493977"
            }
        ]
    });
</script>
</body>
</html>