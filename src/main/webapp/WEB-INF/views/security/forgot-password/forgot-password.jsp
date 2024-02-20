<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>

<body>
    <section class="bg-white">
        <div class="container py-2">
            <div class="row" style="margin-top:100px">
                <div class="col-md-6">
                    <img src='<c:url value="/security/img/forgot_password.png" />' alt="Image" class="img-fluid me-3"
                        style="margin-left: -50px;">
                </div>
                <div class="col-md-6" style="margin-top:120px">
                    <div class="card rounded-4 shadow">
                        <div class="card-body p-md-5 p-sm-2" >
                            <h2 class="fw-bold mb-4">Forgot password</h2>
                            <form action="/security/forgot-password" method="post" class="needs-validation"
                                novalidate="true" >
                                <div class="mb-3">
                                    <div class="form-floating">
                                        <input type="email" class="form-control rounded-3" id="emailForgot"
                                            placeholder="Enter email" name="forgotEmail" required="required">
                                        <label for="emailForgot">Email:</label>
                                        <div class="invalid-feedback">Please enter a valid username.</div>
                                    </div>
                                </div>

                                <div class="d-grid gap-2 mb-2">
                                    <button type="submit" id="submit"
                                        class="btn btn-lg rounded-3 btn-primary">Send</button>
                                </div>
                                <div class="alert">
                                    <c:if test="${not empty message}">
                                        <div class="alert alert-success">${message}</div>
                                    </c:if>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>

</html>
