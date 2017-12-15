<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="../util/header.jsp"/>

</head>
<body>
    <div class="container">
    <h3>Role list</h3>
    <a href="./0">new item</a>
    <table class="table table-hover">
        <tr>
            <th>id</th>
            <th>role</th>
            <th></th>
        </tr>
        <c:forEach var="r" items="${roles}">
            <tr>
                <td>${r.id}</td>
                <td>
                    <a href="./${r.id}">
                            ${r.role}
                    </a>
                </td>
                <td><a href="./${r.id}/delete" style="color: red;">delete</a></td>
            </tr>
        </c:forEach>
    </table>
        <jsp:include page="../util/footer.jsp"/>
    </div>
</body>
</html>