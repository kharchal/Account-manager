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
    <h3>Kind list</h3>
    <a href="./0">new item</a>
    <table class="table table-hover">
        <tr>
            <th>id</th>
            <th>value</th>
            <th></th>
        </tr>
        <c:forEach var="kind" items="${kinds}">
            <tr>
                <td>${kind.id}</td>
                <td>
                    <a href="./${kind.id}">
                            ${kind.value}
                    </a>
                </td>
                <td><a href="./${kind.id}/delete" style="color: red;">delete</a></td>
            </tr>
        </c:forEach>
    </table>

    <c:if test="${not empty backUrl}">
        <a href="../${backUrl}">back...</a>
    </c:if>
        <jsp:include page="../util/footer.jsp"/>
    </div>
</body>
</html>