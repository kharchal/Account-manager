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
    <h3>list</h3>
    <a href="./0">new item</a>
    <table class="table table-hover">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>age</th>
            <th>kind</th>
            <th></th>
        </tr>
        <c:forEach var="pet" items="${pets}">
            <tr>
                <td>${pet.id}</td>
                <td>
                    <a href="./${pet.id}">
                            ${pet.name}
                    </a>
                </td>
                <td>${pet.age}</td>
                <td>${pet.kind.value}</td>
                <td><a href="./${pet.id}/delete" style="color: red;">delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <%--kinds: ${kinds}--%>
    </div>
</body>
</html>