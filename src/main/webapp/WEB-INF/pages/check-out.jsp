<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <div class="breadcrumb-text product-more">
                    <a href="./index.html"><i class="fa fa-home"></i> Home</a>
                    <a href="./shop.html">Shop</a>
                    <span>Check Out</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Section Begin -->

<!-- Shopping Cart Section Begin -->
<section class="checkout-section spad">
    <div class="container">
        <form:form method="post" modelAttribute="orders" class="checkout-form">

            <div class="row">
                <div class="col-lg-6">
                    <div class="row">
                        <spring:bind path="customerFirstName">
                            <div class="col-lg-6">
                                <label for="fir">First Name<span>*</span></label>
                                <form:input type="text" id="fir" path="customerFirstName"/>
                            </div>
                        </spring:bind>
                        <spring:bind path="customerLastName">
                            <div class="col-lg-6">
                                <label for="last">Last Name<span>*</span></label>
                                <form:input type="text" id="last" name="last_name" path="customerLastName"/>
                            </div>
                        </spring:bind>


                        <spring:bind path="companyName">
                            <div class="col-lg-12">
                                <label for="cun-name">Company Name</label>
                                <form:input type="text" id="cun-name" name="company_name" path="companyName"/>
                            </div>
                        </spring:bind>


                        <spring:bind path="country">
                            <div class="col-lg-12">
                                <label for="cun">Country<span>*</span></label>
                                <form:input type="text" id="cun" name="country" path="country"/>
                            </div>
                        </spring:bind>


                        <spring:bind path="street_address">
                            <div class="col-lg-12">
                                <label for="street">Street Address<span>*</span></label>
                                <form:input type="text" id="street" class="street-first" name="street_address"
                                            path="street_address"/>
                            </div>
                        </spring:bind>


                        <spring:bind path="postCode">
                            <div class="col-lg-12">
                                <label for="zip">Postcode / ZIP (optional)</label>
                                <form:input type="text" id="zip" name="post_code" path="postCode"/>
                            </div>
                        </spring:bind>


                        <spring:bind path="city">
                            <div class="col-lg-12">
                                <label for="town">Town / City<span>*</span></label>
                                <form:input type="text" id="town" name="town" path="city"/>
                            </div>
                        </spring:bind>


                        <spring:bind path="email">
                            <div class="col-lg-6">
                                <label for="email">Email Address<span>*</span></label>
                                <form:input type="text" id="email" name="email" path="email"/>
                            </div>
                        </spring:bind>


                        <spring:bind path="phoneNumber">
                            <div class="col-lg-6">
                                <label for="phone">Phone<span>*</span></label>
                                <form:input type="text" id="phone" name="phone" path="phoneNumber"/>
                            </div>
                        </spring:bind>


                    </div>
                    <h4>Biiling Details</h4>
                </div>
                <div class="col-lg-6">
                    <div class="place-order">
                        <h4>Your Order</h4>
                        <div class="order-total">
                            <ul class="order-table">
                                <li>Product <span>Total</span></li>
                                <c:forEach items="${cart}" var="cart">
                                    <li class="fw-normal">${cart.value.product.productName} x ${cart.value.quantity}
                                        <span>$${cart.value.totalPrice}</span></li>
                                </c:forEach>
                                <li class="total-price">Total <span>$${TotalPriceCart}</span></li>
                            </ul>
                            <div class="payment-check">
                                <div class="pc-item">
                                    <label for="pc-check">
                                        Cheque Payment
                                        <input type="radio" id="pc-check" name="payment_type" value="Cheque Payment">
                                        <span class="checkmark"></span>
                                    </label>
                                    <label for="pc-paypal">
                                        Paypal
                                        <input type="radio" id="pc-paypal" name="payment_type" value="Paypal">
                                        <span class="checkmark"></span>
                                    </label>
                                </div>
                            </div>
                            <div class="order-btn">
                                <button type="submit" class="site-btn place-btn">Place Order</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</section>
<!-- Shopping Cart Section End -->


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
</body>

</html>