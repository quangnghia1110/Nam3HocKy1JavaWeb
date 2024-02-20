<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Security</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style type="text/css">
.custom-center {
    margin-top:15px;
}
</style>
</head>
<body>
<div class="custom-center">
    <section class="bg-white">
        <div class="container py-2 h-100"> 
            <div class="row d-flex justify-content-center align-items-center">
               
              <div class="col-md-6">
                    		<img src='<c:url value="/security/img/login.jpg" />'alt="Image" class="img-fluid me-3"style="margin-left: -50px;">
                		</div>
                <div class="col-md-6">
                    <div class="card rounded-4 shadow">
                        <div class="card-body p-md-5 p-sm-2">
                            <form action="/security/login" method="post">
                                <h3 class="fw-bold mb-4 text-center">Sign in</h3>
                                <div class="alert">
                                    <c:if test="${not empty message}">
                                        <div class="alert alert-success">${message}</div>
                                    </c:if>
                                   
                                </div>
                                <div class="mb-3">
                                    <div class="form-floating">
                                        <input type="text" id="username" name="username" value="${username}" class="form-control" placeholder="Username" />
                                        <label class="form-label">User Name</label>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <div class="form-floating">
                                        <input type="password" id="password" name="password" value="${password}" class="form-control" placeholder="Password" />
                                        <label class="form-label">Password</label>
                                    </div>
                                </div>
                                <div class="form-check d-flex justify-content-start mb-4">
                                    <input class="form-check-input me-2" type="checkbox" name="remember-me" id="form1Example3" />
                                    <label class="form-check-label"> Remember password? </label>
                                    <a href="/security/forgot-password" class="ms-auto text-decoration-none">Forgot password?</a>
                                </div>
                                <div class="d-grid gap-2 mb-2">
                                    <button type="submit" id="submit" class="btn btn-lg rounded-3 btn-primary">Sign In</button>
                                </div>
                                <hr class="my-4">
                                <h2 class="fs-5 fw-bold mb-3 text-center">Or</h2>
                                <a href="/oauth2/authorization/google" class="w-100 py-2 mb-2 btn btn-outline-danger rounded-3">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 488 512">
                                        <style>svg{fill:#ffffff}</style><path d="M488 261.8C488 403.3 391.1 504 248 504 110.8 504 0 393.2 0 256S110.8 8 248 8c66.8 0 123 24.5 166.3 64.9l-67.5 64.9C258.5 52.6 94.3 116.6 94.3 256c0 86.5 69.1 156.6 153.7 156.6 98.2 0 135-70.4 140.8-106.9H248v-85.3h236.1c2.3 12.7 3.9 24.9 3.9 41.4z"/>
                                    </svg>      
                                    Sign in with Google
                                </a>
                                <a href="/oauth2/authorization/facebook" class="w-100 py-2 mb-2 btn btn-outline-primary rounded-3">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 512 512">
                                        <style>svg{fill:#ffffff}</style><path d="M504 256C504 119 393 8 256 8S8 119 8 256c0 123.78 90.69 226.38 209.25 245V327.69h-63V256h63v-54.64c0-62.15 37-96.48 93.67-96.48 27.14 0 55.52 4.84 55.52 4.84v61h-31.28c-30.8 0-40.41 19.12-40.41 38.73V256h68.78l-11 71.69h-57.78V501C413.31 482.38 504 379.78 504 256z"/>
                                    </svg>
                                    Sign in with Facebook
                                </a>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-7 offset-md-4 text-end mb-3">
		<div class="d-inline">
			<p class="d-inline">
				<b>Bạn chưa có tài khoản ?</b>
			</p>
			<a href="/security/register" class="text-primary text-decoration-none d-inline"><b> Đăng ký</b></a>
		</div>
	</div>
    </section>
</div>
</body>
</html>
