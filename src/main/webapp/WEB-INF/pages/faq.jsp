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

<!-- Breadcrumb Section Begin -->
<div class="breacrumb-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="breadcrumb-text">
                    <a href="#"><i class="fa fa-home"></i> Home</a>
                    <span>FAQs</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Section Begin -->

<!-- Faq Section Begin -->
<div class="faq-section spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="faq-accordin">
                    <div class="accordion" id="accordionExample">
                        <div class="card">
                            <div class="card-heading active">
                                <a class="active" data-toggle="collapse" data-target="#collapseOne">
                                    Is There Anything I Should Bring?
                                </a>
                            </div>
                            <div id="collapseOne" class="collapse show" data-parent="#accordionExample">
                                <div class="card-body">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                        consequat.</p>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-heading">
                                <a data-toggle="collapse" data-target="#collapseTwo">
                                    Where Can I Find Market Research Reports?
                                </a>
                            </div>
                            <div id="collapseTwo" class="collapse" data-parent="#accordionExample">
                                <div class="card-body">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                        consequat.</p>
                                </div>
                            </div>
                        </div>
                        <div class="card">
                            <div class="card-heading">
                                <a data-toggle="collapse" data-target="#collapseThree">
                                    Where Can I Find The Wall Street Journal?
                                </a>
                            </div>
                            <div id="collapseThree" class="collapse" data-parent="#accordionExample">
                                <div class="card-body">
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                        tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                        quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                        consequat.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Faq Section End -->


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