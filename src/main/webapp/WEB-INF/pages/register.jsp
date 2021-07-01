<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Fashi Template">
    <meta name="keywords" content="Fashi, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Fashi | Template</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="<c:url value="/template/css/bootstrap.min.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/font-awesome.min.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/themify-icons.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/elegant-icons.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/owl.carousel.min.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/nice-select.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/jquery-ui.min.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/slicknav.min.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/template/css/style.css" />" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>

<!-- Header Section Begin -->
<%@include file="header.jsp" %>
<!-- Header End -->

<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="#"><i class="fa fa-home"></i> Home</a>
                    <span>Register</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Form Section Begin -->

<!-- Register Section Begin -->
<div class="register-login-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-6 offset-lg-3">
                <div class="register-form">
                    <h2>Register</h2>
                    <form action="#">
                        <div class="group-input">
                            <label for="username">Username or email address *</label>
                            <input type="text" id="username">
                        </div>
                        <div class="group-input">
                            <label for="pass">Password *</label>
                            <input type="text" id="pass">
                        </div>
                        <div class="group-input">
                            <label for="con-pass">Confirm Password *</label>
                            <input type="text" id="con-pass">
                        </div>
                        <button type="submit" class="site-btn register-btn">REGISTER</button>
                    </form>
                    <div class="switch-login">
                        <a href="./login.html" class="or-login">Or Login</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Register Form Section End -->


<!-- Partner Logo Section Begin -->
<div class="partner-logo">
    <div class="container">
        <div class="logo-carousel owl-carousel">
            <div class="logo-item">
                <div class="tablecell-inner">
                    <img src="<c:url value="/template/img/logo-carousel/logo-1.png"/>" alt="">
                </div>
            </div>
            <div class="logo-item">
                <div class="tablecell-inner">
                    <img src="<c:url value="/template/img/logo-carousel/logo-2.png"/>" alt="">
                </div>
            </div>
            <div class="logo-item">
                <div class="tablecell-inner">
                    <img src="<c:url value="/template/img/logo-carousel/logo-3.png"/>" alt="">
                </div>
            </div>
            <div class="logo-item">
                <div class="tablecell-inner">
                    <img src="<c:url value="/template/img/logo-carousel/logo-4.png"/>" alt="">
                </div>
            </div>
            <div class="logo-item">
                <div class="tablecell-inner">
                    <img src="<c:url value="/template/img/logo-carousel/logo-5.png"/>" alt="">
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Partner Logo Section End -->

<!-- Footer Section Begin -->
<%@include file="footer.jsp" %>

<script src="<c:url value="/template/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/template/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/template/js/jquery-ui.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.countdown.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.nice-select.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.zoom.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.dd.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.slicknav.js" />"></script>
<script src="<c:url value="/template/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/template/js/main.js" />"></script>
<script src="<c:url value="/template/js/jquery.twbsPagination.js" />" type="text/javascript"></script>
</body>

</html>