<%--
  Created by IntelliJ IDEA.
  User: burusothman
  Date: 8/30/16
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ include file="/common/taglibs.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="web.app.admin"/></title>
</head>
<body>
<div class="container">
    <h3>Admin Panel</h3>
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li class="active">
            <a href="#home" role="tab" data-toggle="tab">
                <icon class="fa fa-home"></icon> Home
            </a>
        </li>
        <li><a href="#editors" role="tab" data-toggle="tab">
            <i class="fa fa-user"></i> Editors
        </a>
        </li>
        <li>
            <a href="#approvals" role="tab" data-toggle="tab">
                <i class="fa fa-envelope"></i> Approvals
            </a>
        </li>
        <li>
            <a href="#posts" role="tab" data-toggle="tab">
                <i class="fa fa-cog"></i> Posts
            </a>
        </li>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div class="tab-pane fade active in" id="home">
            <h2>Create Editor</h2>
            <form:form class="well" method="post" modelAttribute="userForm" action="${pageContext.request.contextPath}/user/create">
                <div class="form-group row">
                    <label for="example-text-input" class="col-xs-2 col-form-label">Username</label>
                    <div class="col-xs-10">
                        <form:input path="username" class="form-control" type="text" value="" id="example-text-input"/>
                    </div>
                </div>
                <div class="form-group row">
                    <label for="example-password-input" class="col-xs-2 col-form-label">Password</label>
                    <div class="col-xs-10">
                        <form:input path="password" class="form-control" type="password" value="" id="example-password-input"/>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Create Editor</button>
            </form:form>
        </div>
        <div class="tab-pane fade" id="editors">
            <h2>Editors</h2>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach var="user" items="${userList}">
                        <tr>
                            <td>
                            ${user.username}
                            </td>
                            <td><c:choose>
                                    <c:when test="${user.enabled}">
                                        <button name="suspend" value="${user.username}" class="btn btn-info"
                                                onclick="location.href='${pageContext.request.contextPath}/user/suspend?suspend=${user.username}'">Suspend</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button  name="suspend" value="${user.username}" class="btn btn-info"
                                                onclick="location.href='${pageContext.request.contextPath}/user/suspend?suspend=${user.username}'">Enable</button>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                        </tr>
                    </c:forEach>
                </thead>
            </table>
        </div>
        <div class="tab-pane fade" id="approvals">
            <h2>Approvals</h2>
        </div>
        <div class="tab-pane fade" id="posts">
            <h2>Settings Content Goes Here</h2>
        </div>
    </div>

</div>
</div>
</body>
</html>
