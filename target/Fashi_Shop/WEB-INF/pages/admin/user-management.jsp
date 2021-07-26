<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Trong Cuong
  Date: 7/9/2021
  Time: 12:12 AM
  To change this template use File | Settings | File Templates.
--%>
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

    <title>User Management</title>

    <!-- Custom fonts for this template -->
    <link href="<c:url value="/template/vendor/fontawesome-free/css/all.min.css"/> " rel="stylesheet" type="text/css">
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/template/css/sb-admin-2.min.css"/>" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="<c:url value="/template/vendor/datatables/dataTables.bootstrap4.min.css"/>" rel="stylesheet">

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
                <h1 class="h3 mb-2 text-gray-800">User Management</h1>

                <!-- Insert Modal -->
                <div class="modal fade" id="insertModal" tabindex="-1" role="dialog"
                     aria-labelledby="insertModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="insertModalLabel">Add User</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form:form method="post" modelAttribute="User"
                                           action="${contextPath}/admin/user-management/add-user">
                                    <div class="form-row">
                                        <spring:bind path="username">
                                            <div class="form-group col-md-6">
                                                <label for="inputEmail4">User name</label>
                                                <form:input type="text" class="form-control" id="inputEmail4"
                                                            path="username"/>
                                                <form:errors path="username"/>
                                            </div>
                                        </spring:bind>
                                        <spring:bind path="password">
                                            <div class="form-group col-md-6">
                                                <label for="inputPassword4">Password</label>
                                                <form:input type="password" class="form-control" id="inputPassword4"
                                                            path="password"/>
                                                <form:errors path="password"/>
                                            </div>
                                        </spring:bind>
                                    </div>
                                    <spring:bind path="email">
                                        <div class="form-group">
                                            <label for="inputAddress">Email</label>
                                            <form:input type="email" class="form-control" id="inputAddress"
                                                        path="email"/>
                                            <form:errors path="email"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="fullName">
                                        <div class="form-group">
                                            <label for="inputAddress">Full name</label>
                                            <form:input type="text" class="form-control" id="inputAddress"
                                                        path="fullName"/>
                                            <form:errors path="fullName"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="description">
                                        <div class="form-group">
                                            <label for="inputDescription">Description</label>
                                            <form:input type="text" class="form-control" id="inputDescription"
                                                        path="description"/>
                                            <form:errors path="description"/>
                                        </div>
                                    </spring:bind>

                                    <div class="form-row">
                                        <label for="inputState">Role</label>
                                        <select id="inputState" class="form-control" name="role">
                                            <option value="ADMIN">Admin</option>
                                            <option value="USER" selected>User</option>
                                        </select>
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
                                <h5 class="modal-title" id="updateModalLabel">Update User</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form:form method="post" modelAttribute="User"
                                           action="${contextPath}/admin/user-management/update-user">
                                    <div class="form-row">
                                        <spring:bind path="username">
                                            <div class="form-group col-md-6">
                                                <label for="inputUpdateUserName">User name</label>
                                                <form:input type="text" class="form-control" id="inputUpdateUserName"
                                                            path="username"/>
                                                <form:errors path="username"/>
                                            </div>

                                        </spring:bind>
                                        <div class="form-group col-md-6">
                                            <label for="inputUpdateRole">Role</label>
                                            <select id="inputUpdateRole" class="form-control" name="roleUpdate">
                                                <option value="ADMIN">Admin</option>
                                                <option VALUE="USER" selected>User</option>
                                            </select>
                                        </div>
                                    </div>
                                    <spring:bind path="email">
                                        <div class="form-group">
                                            <label for="inputUpdateEmail">Email</label>
                                            <form:input type="email" class="form-control" id="inputUpdateEmail"
                                                        path="email" placeholder="abc123@gmail.com"/>
                                            <form:errors path="email"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="fullName">
                                        <div class="form-group">
                                            <label for="inputUpdateFullName">Full name</label>
                                            <form:input type="text" class="form-control" id="inputUpdateFullName"
                                                        path="fullName" placeholder="Nguyễn Trọng Cường"/>
                                            <form:errors path="fullName"/>
                                        </div>
                                    </spring:bind>
                                    <spring:bind path="description">
                                        <div class="form-group">
                                            <label for="inputUpdateDescription">Description</label>
                                            <form:input type="text" class="form-control" id="inputUpdateDescription"
                                                        path="description" placeholder="Some thing about you"/>
                                            <form:errors path="description"/>
                                        </div>
                                    </spring:bind>
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
                            <form method="post" action="${contextPath}/admin/user-management/delete-user">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="deleteModalLabel">Delete user</h5>
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
                <hr/>

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-success btn-sm" data-toggle="modal"
                                data-target="#insertModal">
                            <i class="fa fa-plus"></i> Add User
                        </button>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th>User Name</th>
                                    <th>Full Name</th>
                                    <th>Email</th>
                                    <th>Created By</th>
                                    <th>Created Date</th>
                                    <th>Updated By</th>
                                    <th>Updated Date</th>
                                    <th>Description</th>
                                    <th>Status</th>
                                    <th>Action</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${listUser}" var="user">
                                    <tr>
                                        <td>${user.username}</td>
                                        <td>${user.fullName}</td>
                                        <td>${user.email}</td>
                                        <td>${user.createdBy}</td>
                                        <td>${user.createdDate}</td>
                                        <td>${user.updatedBy}</td>
                                        <td>${user.updatedDate}</td>
                                        <td>${user.description}</td>
                                        <td>
                                            <input type="checkbox"
                                                   <c:if test="${user.status == 1}">checked</c:if> data-toggle="toggle"
                                                   data-size="xs">
                                        </td>
                                        <td>
                                            <button value="${user.id}" id="updateUser" data-target="#updateModal" data-toggle="modal" class="btn btn-warning updateUser" ><i
                                                    class="fas fa-pencil-alt"></i>
                                            </button>
                                            <button value="${user.id}" id="deleteUser" data-target="#deleteModal" data-toggle="modal" class="btn btn-danger deleteUser" ><i
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
    $("table button ").click(function() {
        var idDelete = $(this).val();
        $('#deleteModal #idDelete').val(idDelete);
    });
    $("table button ").click(function() {
        var idUpdate = $(this).val();
        $.ajax({
            type: 'GET',
            url: '${contextPath}/api/user/find/'+ idUpdate,
            success: function (user) {
                $('#updateModal #idUpdate').val(user.id);
                $('#updateModal #inputUpdateUserName').val(user.username);
                $('#updateModal #inputUpdateFullName').val(user.fullName);
                $('#updateModal #inputUpdateDescription').val(user.description);
                $('#updateModal #inputUpdateEmail').val(user.email);
                $('#updateModal #inputUpdateRole').val(user.roles[0].roleName).attr('selected','selected');
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

<script src="https://cdn.jsdelivr.net/gh/gitbrent/bootstrap4-toggle@3.6.1/js/bootstrap4-toggle.min.js"></script>
</body>

</html>