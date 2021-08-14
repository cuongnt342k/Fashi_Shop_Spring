<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.ltc.utils.SecurityUtils" %>

<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Product Management</title>

    <!-- Custom fonts for this template -->
    <link href="<c:url value="/template/vendor/fontawesome-free/css/all.min.css"/> " rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/template/css/sb-admin-2.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="<c:url value="/template/vendor/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/template/css/bootstrap4-toggle.min.css"/>" rel="stylesheet">

    <link href="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/css/bootstrap4-toggle.min.css"
          rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <%@include file="side-bar.jsp" %>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <%@include file="top-bar.jsp" %>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">

                <!-- Page Heading -->
                <h1 class="h3 mb-2 text-gray-800">Product Management</h1>
                <!-- Insert Modal -->
                <div class="modal fade" id="insertModal" tabindex="-1" role="dialog"
                     aria-labelledby="insertModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="insertModalLabel">Add Product</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form:form method="post" modelAttribute="Product"
                                           action="${contextPath}/admin/product-management/add-product?${_csrf.parameterName}=${_csrf.token}"
                                           enctype="multipart/form-data">
                                    <spring:bind path="productName">
                                        <div class="form-group">
                                            <label for="inputProductName">Product name</label>
                                            <form:input type="text" class="form-control" id="inputProductName"
                                                        path="productName"/>
                                            <form:errors path="productName"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="brand">
                                        <div class="form-group">
                                            <label for="inputbrand">Brand</label>
                                            <form:input type="text" class="form-control" id="inputbrand"
                                                        path="brand"/>
                                            <form:errors path="brand"/>
                                        </div>
                                    </spring:bind>

                                    <div class="form-row">

                                        <spring:bind path="price">
                                            <div class="form-group col-md-6">
                                                <label for="inputAddress">Price</label>
                                                <form:input type="number" class="form-control" id="inputAddress"
                                                            path="price"/>
                                                <form:errors path="price"/>
                                            </div>
                                        </spring:bind>
                                        <spring:bind path="salePrice">
                                            <div class="form-group col-md-6">
                                                <label for="inputAddress">Sale price</label>
                                                <form:input type="number" class="form-control" id="inputAddress"
                                                            path="salePrice"/>
                                                <form:errors path="salePrice"/>
                                            </div>
                                        </spring:bind>
                                    </div>
                                    <spring:bind path="description">
                                        <div class="form-group">
                                            <label for="inputDescription">Description</label>
                                            <form:input type="text" class="form-control" id="inputDescription"
                                                        path="description"/>
                                            <form:errors path="description"/>
                                        </div>
                                    </spring:bind>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="inputState">Category</label>
                                            <select id="inputState" class="form-control" name="category">
                                                <option value="1" selected>Man</option>
                                                <option value="2">Woman</option>
                                                <option value="3">Kid</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="inputImage">Image</label>
                                            <input type="file" name="image" id="inputImage" accept=".jpg, .jpeg, .png">
                                            <label>${errorMessage}</label>
                                        </div>
                                    </div>
                                    <hr/>
                                    <button type="submit" class="btn btn-success">Add</button>
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- Update Modal -->
                <div class="modal fade" id="updateModal" tabindex="-1" role="dialog"
                     aria-labelledby="insertModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="updateModalLabel">Update Product</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form:form method="post" modelAttribute="Product"
                                           action="${contextPath}/admin/product-management/update-product"
                                           enctype="multipart/form-data">
                                    <spring:bind path="productName">
                                        <div class="form-group">
                                            <label for="updateProductName">Product name</label>
                                            <form:input type="text" class="form-control" id="updateProductName"
                                                        path="productName"/>
                                            <form:errors path="productName"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="brand">
                                        <div class="form-group">
                                            <label for="updateBrand">Brand</label>
                                            <form:input type="text" class="form-control" id="updateBrand"
                                                        path="brand"/>
                                            <form:errors path="brand"/>
                                        </div>
                                    </spring:bind>

                                    <div class="form-row">

                                        <spring:bind path="price">
                                            <div class="form-group col-md-6">
                                                <label for="updatePrice">Price</label>
                                                <form:input type="number" class="form-control" id="updatePrice"
                                                            path="price"/>
                                                <form:errors path="price"/>
                                            </div>
                                        </spring:bind>
                                        <spring:bind path="salePrice">
                                            <div class="form-group col-md-6">
                                                <label for="updateSalePrice">Sale price</label>
                                                <form:input type="number" class="form-control" id="updateSalePrice"
                                                            path="salePrice"/>
                                                <form:errors path="salePrice"/>
                                            </div>
                                        </spring:bind>
                                    </div>
                                    <spring:bind path="description">
                                        <div class="form-group">
                                            <label for="updateDescription">Description</label>
                                            <form:input type="text" class="form-control" id="updateDescription"
                                                        path="description"/>
                                            <form:errors path="description"/>
                                        </div>
                                    </spring:bind>
                                    <div class="form-row">
                                        <div class="form-group col-md-6">
                                            <label for="updateCategory">Category</label>
                                            <select id="updateCategory" class="form-control" name="category">
                                                <option value="1" selected>Man</option>
                                                <option value="2">Woman</option>
                                                <option value="3">Kid</option>
                                            </select>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="inputImage">Image</label>
                                            <input type="file" name="image" id="inputUpdateImage"
                                                   accept=".jpg, .jpeg, .png">
                                            <label>${errorMessage}</label>
                                        </div>
                                    </div>
                                    <hr/>
                                    <input type="submit" class="btn btn-warning" value="Save changes">
                                    <input type="hidden" name="idUpdate" id="idUpdate">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
                <!--Delete Modal -->
                <div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
                     aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <form method="post" action="${contextPath}/admin/product-management//delete-product">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="deleteModalLabel">Delete Product</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Are you sure you want to delete these Records?
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <input type="submit" class="btn btn-danger" value="Delete"/>
                                    <input type="hidden" name="idDelete" id="idDelete">
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-success btn-sm" data-toggle="modal"
                                data-target="#insertModal">
                            <i class="fa fa-plus"></i> Add Product
                        </button>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>Image</th>
                                    <th>Name</th>
                                    <th>Brand</th>
                                    <th>Created By</th>
                                    <th>Created Date</th>
                                    <th>Updated By</th>
                                    <th>Updated Date</th>
                                    <th>Price</th>
                                    <th>Sale Price</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="product" items="${products}">
                                    <tr>
                                        <td><img width="100" height="100"
                                                 src="<c:url value="/template/img/products/${product.img}"/>" alt="">
                                        </td>
                                        <td>${product.productName}</td>
                                        <td>${product.brand}</td>
                                        <td>${product.createdBy}</td>
                                        <td>${product.createdDate}</td>
                                        <td>${product.updatedBy}</td>
                                        <td>${product.updatedDate}</td>
                                        <td>$${product.price}</td>
                                        <td>$${product.salePrice}</td>
                                        <td>
                                            <button value="${product.id}" id="updateProduct" data-target="#updateModal"
                                                    data-toggle="modal" class="btn btn-warning updateProduct"><i
                                                    class="fas fa-pencil-alt"></i>
                                            </button>
                                            <button value="${product.id}" id="deleteProduct" data-target="#deleteModal"
                                                    data-toggle="modal" class="btn btn-danger deleteProduct"><i
                                                    class="fas fa-trash"></i>
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <%@include file="footer.jsp" %>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<%@include file="logout-modal.jsp" %>
<script type="text/javascript">
    $("button").click(function () {
        var idDelete = $(this).val();
        $('#deleteModal #idDelete').val(idDelete);
    });
    $("table button ").click(function () {
        var idUpdate = $(this).val();
        $.ajax({
            type: 'GET',
            url: '${contextPath}/api/product/find/' + idUpdate,
            success: function (product) {
                $('#updateModal #idUpdate').val(product.id);
                $('#updateModal #updateProductName').val(product.productName);
                $('#updateModal #updateBrand').val(product.brand);
                $('#updateModal #updateDescription').val(product.description);
                $('#updateModal #updatePrice').val(product.price);
                $('#updateModal #updateSalePrice').val(product.salePrice);
                $('#updateModal #updateCategory').val(product.categories.id).attr('selected', 'selected');
            }
        })
    });
</script>
<!-- Bootstrap core JavaScript-->
<script src="<c:url value="/template/vendor/jquery/jquery.min.js"/> "></script>
<script src="<c:url value="/template/vendor/bootstrap/js/bootstrap.bundle.min.js"/>"></script>

<!-- Core plugin JavaScript-->
<script src="<c:url value="/template/vendor/jquery-easing/jquery.easing.min.js"/>"></script>

<!-- Custom scripts for all pages-->
<script src="<c:url value="/template/js/sb-admin-2.min.js"/>"></script>

<!-- Page level plugins -->
<script src="<c:url value="/template/vendor/datatables/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="/template/vendor/datatables/dataTables.bootstrap4.min.js"/>"></script>

<!-- Page level custom scripts -->
<script src="<c:url value="/template/js/demo/datatables-demo.js"/>"></script>

<script src="<c:url value="/template/js/bootstrap4-toggle.min.js"/>"></script>
</body>

</html>