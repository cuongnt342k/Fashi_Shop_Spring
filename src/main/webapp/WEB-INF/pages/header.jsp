<%@ page import="com.ltc.utils.SecurityUtils" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Header Section Begin -->
<header class="header-section">
    <div class="header-top">
        <div class="container">
            <div class="ht-left">
                <div class="mail-service">
                    <i class=" fa fa-envelope"></i>
                    cuongnt342k@gmail.com
                </div>
                <div class="phone-service">
                    <i class=" fa fa-phone"></i>
                    +84 382 577 599
                </div>
            </div>
            <div class="ht-right">
                <security:authorize access="isAnonymous()">
                    <a href="<c:url value="/registration"/>" class="login-panel">Register</a>
                    <a href="<c:url value="/login"/>" class="login-panel" style="padding-right: 15px"><i class="fa fa-user"></i> Login </a>
                </security:authorize>
                <security:authorize access="isAuthenticated()">
                    <div class="lan-selector">
                        <a data-toggle="dropdown"
                           class="dropdown-toggle user-action"><%=SecurityUtils.getPrincipal().getFullName()%><b
                                class="caret"></b></a>
                        <div class="dropdown-menu">
                            <a href="<c:url value="/admin/"/> " class="dropdown-item"><i class="fa fa-user-o"></i> Admin</a></a>
                            <a href="#" class="dropdown-item"><i class="fa fa-sliders"></i> Settings</a></a>
                            <div class="dropdown-divider"></div>
                            <a class="nav-link" href="<c:url value='/logout'/>">Logout</a>
                        </div>
                    </div>
                </security:authorize>
                <div class="lan-selector">
                    <select class="language_drop" name="countries" id="countries" style="width:300px;">
                        <option value='yt' data-image="<c:url value="/template/img/flag-1.jpg"/> "
                                data-imagecss="flag yt"
                                data-title="English">English
                        </option>
                        <option value='yu' data-image="<c:url value="/template/img/flag-2.jpg"/>"
                                data-imagecss="flag yu"
                                data-title="Bangladesh">German
                        </option>
                    </select>
                </div>
                <div class="top-social">
                    <a href="#"><i class="ti-facebook"></i></a>
                    <a href="#"><i class="ti-twitter-alt"></i></a>
                    <a href="#"><i class="ti-linkedin"></i></a>
                    <a href="#"><i class="ti-pinterest"></i></a>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="inner-header">
            <div class="row">
                <div class="col-lg-2 col-md-2">
                    <div class="logo">
                        <a href="./">
                            <img src="<c:url value="/template/img/logo.png"/>" alt="">
                        </a>
                    </div>
                </div>
                <div class="col-lg-7 col-md-7">
                    <form action="<c:url value="/search?page=0&size=6"/>" method="get">
                        <div class="advanced-search">
                            <button type="button" class="category-btn">All
                                Categories
                            </button>
                            <div class="input-group">
                                <input name="textSearch" type="text" placeholder="What do you need?"
                                       value="${textSearch}">
                                <button type="submit">
                                    <i class="ti-search"></i>
                                </button>
                                <input type="hidden" name="page" value="0">
                                <input type="hidden" name="size" value="6">
                            </div>
                        </div>
                    </form>
                </div>
                <div class="col-lg-3 text-right col-md-3">
                    <ul class="nav-right">
                        <li class="heart-icon"><a href="#">
                            <i class="icon_heart_alt"></i>
                            <span>1</span>
                        </a>
                        </li>
                        <li class="cart-icon"><a href="<c:url value="/shopping-cart"/>">
                            <i class="icon_bag_alt"></i>
                            <span>${TotalQuantityCart}</span>
                        </a>
                            <div class="cart-hover">
                                <div class="select-items">
                                    <table>
                                        <tbody>
                                        <c:forEach items="${Cart}" var="cart">
                                            <tr>
                                                <td class="si-pic"><img width="70" height="70"
                                                                        src="<c:url value="/template/${cart.value.product.img}"/>"
                                                                        alt=""></td>
                                                <td class="si-text">
                                                    <div class="product-selected">
                                                        <p>$${cart.value.product.price} x ${cart.value.quantity}</p>
                                                        <h6>${cart.value.product.productName}</h6>
                                                    </div>
                                                </td>
                                                <td class="si-close">
                                                    <a href=" <c:url value="/deleteCart/${cart.key}"/>"><i
                                                            class="ti-close"></i></a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="select-total">
                                    <span>total:</span>
                                    <h5>$${TotalPriceCart}</h5>
                                </div>
                                <div class="select-button">
                                    <a href="<c:url value="/shopping-cart"/>" class="primary-btn view-card">VIEW
                                        CARD</a>
                                    <a href="<c:url value="/check-out"/>" class="primary-btn checkout-btn">CHECK
                                        OUT</a>
                                </div>
                            </div>
                        </li>
                        <li class="cart-price">$${TotalPriceCart}</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <div class="nav-item">
        <div class="container">
            <div class="nav-depart">
                <div class="depart-btn">
                    <i class="ti-menu"></i>
                    <span>All departments</span>
                    <ul class="depart-hover">
                        <li>
                            <a href="<c:url value="/shop?page=0&size=${size}&categoryId=1"/> ">Men</a>
                        </li>
                        <li>
                            <a href="<c:url value="/shop?page=0&size=${size}&categoryId=2"/> ">Women</a>
                        </li>
                        <li>
                            <a href="<c:url value="/shop?page=0&size=${size}&categoryId=3"/> ">Kid</a>
                        </li>
                    </ul>
                </div>
            </div>
            <nav class="nav-menu mobile-menu">
                <ul>
                    <li><a href="./">Home</a></li>
                    <li><a href="<c:url value="/shop?page=0&size=6"/>">Shop</a></li>
                    <li><a href="#">Collection</a>
                        <ul class="dropdown">
                            <li>
                                <a href="<c:url value="/shop?page=0&size=${size}&categoryId=1"/> ">Men</a>
                            </li>
                            <li>
                                <a href="<c:url value="/shop?page=0&size=${size}&categoryId=2"/> ">Women</a>
                            </li>
                            <li>
                                <a href="<c:url value="/shop?page=0&size=${size}&categoryId=3"/> ">Kid</a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="<c:url value="/contact"/> ">Contact</a></li>
                    <li><a href="#">Pages</a>
                        <ul class="dropdown">
                            <li><a href="<c:url value="/shopping-cart"/> ">Shopping Cart</a></li>
                            <li><a href="<c:url value="/check-out"/>">Checkout</a></li>
                            <li><a href="<c:url value="/faq"/>">Faq</a></li>
                            <li><a href="<c:url value="/registration"/>">Register</a></li>
                            <li><a href="<c:url value="/login"/>">Login</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
            <div id="mobile-menu-wrap"></div>
        </div>
    </div>
</header>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<!-- Header End -->