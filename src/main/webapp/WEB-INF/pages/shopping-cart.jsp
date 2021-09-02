<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
    <link rel="stylesheet" href="<c:url value="/template/js/toastr.min.css" />" type="text/css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

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
                    <a href="./home.html"><i class="fa fa-home"></i> Home</a>
                    <a href="./shop.html">Shop</a>
                    <span>Shopping Cart</span>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb Section Begin -->

<!-- Shopping Cart Section Begin -->
<section class="shopping-cart spad">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <form name="editCart" action="<c:url value="/editCart"/>">
                    <div class="cart-table">
                        <table id="productInCart">
                            <thead>
                            <tr>
                                <th>Image</th>
                                <th class="p-name">Product Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th><i class="ti-close"></i></th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--                            <c:forEach items="${cart}" var="cart">--%>
                            <%--                                <input type="hidden" value="${cart.key}" name="cartId">--%>
                            <%--                                <tr>--%>
                            <%--                                    <td class="cart-pic first-row"><img width = "170" height = "170" src="<c:url value="/template/img/products/${cart.value.product.img}"/>" alt=""></td>--%>
                            <%--                                    <td class="cart-title first-row">--%>
                            <%--                                        <h5>${cart.value.product.productName}</h5>--%>
                            <%--                                    </td>--%>
                            <%--                                    <td class="p-price first-row">$${cart.value.product.price}</td>--%>
                            <%--                                    <td class="qua-col first-row">--%>
                            <%--                                        <div class="quantity">--%>
                            <%--                                            <div class="pro-qty">--%>
                            <%--                                                <input type="text" value="${cart.value.quantity}" name="quantity">--%>
                            <%--                                            </div>--%>
                            <%--                                        </div>--%>
                            <%--                                    </td>--%>
                            <%--                                    <td class="total-price first-row">$${cart.value.totalPrice}</td>--%>

                            <%--                                    <td class="close-td first-row"><a href=" <c:url value="/deleteCart/${cart.key}"/>"><i class="ti-close"></i></a></td>--%>
                            <%--                                </tr>--%>
                            <%--                            </c:forEach>--%>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="cart-buttons">
                                <a href="<c:url value="/shop?page=0&size=6"/>" class="primary-btn continue-shop">Continue
                                    shopping</a>
                                <input class="primary-btn up-cart" value="Update cart" type="submit">
                                <%--                            <a href="<c:url value="/editCart?"/>" class="primary-btn up-cart">Update cart</a>--%>
                            </div>

                        </div>
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                <ul>
                                    <li class="cart-total">Total <span >$<span id="totalPriceCart">${TotalPriceCart}</span></span></li>
                                </ul>
                                <a href="${contextPath}/check-out" class="proceed-btn">PROCEED TO CHECK OUT</a>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
<!-- Shopping Cart Section End -->

<!-- Footer Section Begin -->
<%@include file="footer.jsp" %>

<script type="text/javascript">
    $(document).ready(function () {
        getAll();
    })

    // DO GET
    function getAll() {
        $.ajax({
            type: "GET",
            url: '${contextPath}/shopping-cart/getAll',
            success: function (result) {
                var productRow = '';
                if (result == ''){
                    productRow += '<tr>';
                    productRow += '</tr>';
                    $('#productInCart tbody').html(productRow);
                }else {
                    $.each(result, function (i, cart) {
                        productRow += '<input type="hidden" value="'+ cart.product.id +'" name="cartId">';
                        productRow += '<tr>';
                        productRow += '<td class="cart-pic first-row">' + '<img width = "170" height = "170" src="${contextPath}/template/img/products/' + cart.product.img + '" alt="">' + '</td>';
                        productRow += '<td class="cart-title first-row"><h5>' + cart.product.productName + '</h5></td>';
                        productRow += '<td class= "p-price first-row">' + cart.product.price + '</td>';
                        productRow += '<td class= "qua-col first-row"><div class="quantity"><div class="pro-qty">' + '<input type="text" id="quantity'+cart.product.id+'" value="' + cart.quantity + '" name="quantity">' + '</div></div></td>' ;
                        productRow += '<td class="total-price first-row"><input type="hidden" id="productPrice'+cart.product.id+'" value="' + cart.totalPrice + '"> $' + cart.totalPrice + '</td>' ;
                        productRow += '<td class="close-td first-row">' + '<a href="#!" onclick="deleteCart(' + cart.product.id + ')"><i class="ti-close"></i><input type="hidden" id="idProduct' + cart.product.id + '"  value="' + cart.product.id + '">\n</a>' + '</td>' ;
                        productRow += '</tr>';
                        $('#productInCart tbody').html(productRow);
                    });
                }
            },
            error: function (e) {
                toastr.warning("Cart is empty");
            }
        });
    }

    function deleteCart(id) {
        id = $("#idProduct" + id).val();
        $.ajax({
            type: "POST",
            url: '${contextPath}/deleteCart/' + id,
            success: function (result) {
                var currentQuantity;
                var currentPrice;
                if ($("#totalQuantity").text() == "" || $("#totalPrice").text() == "") {
                    currentQuantity = 0;
                    currentPrice = 0;
                } else {
                    currentQuantity = parseInt($("#totalQuantity").text());
                    currentPrice = parseInt($("#totalPrice").text());
                }
                totalQuantity = currentQuantity - parseInt($("#quantity" + id).val());
                totalPrice = currentPrice - parseInt($("#productPrice" + id).val());
                $.session.set("TotalQuantityCart", totalQuantity);
                $.session.set("TotalPriceCart", totalPrice);
                $("#totalQuantity").text($.session.get("TotalQuantityCart"));
                $("#totalPrice").text($.session.get("TotalPriceCart"));
                $("#totalPriceCart").text($.session.get("TotalPriceCart"));
                getAll();
                toastr.warning(result);
            },
            error: function (e) {
                alert("ERROR: ", e);
                console.log("ERROR: ", e);
            }
        });

    }
</script>
<script src="<c:url value="/template/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/template/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.session.js" />"></script>
<script src="<c:url value="/template/js/jquery-ui.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.countdown.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.nice-select.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.zoom.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.dd.min.js" />"></script>
<script src="<c:url value="/template/js/jquery.slicknav.js" />"></script>
<script src="<c:url value="/template/js/owl.carousel.min.js" />"></script>
<script src="<c:url value="/template/js/toastr.min.js" />"></script>
<script src="<c:url value="/template/js/main.js" />"></script>
</body>

</html>