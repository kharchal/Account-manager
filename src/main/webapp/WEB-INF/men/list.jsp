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
    <h3>Man list</h3>
    <a href="./0">new item</a>
    <table class="table table-hover">
        <tr>
            <th width="10%">id</th>
            <th width="20%">name</th>
            <th width="60%">roles</th>
            <th></th>
        </tr>
        <c:forEach var="man" items="${men}">
            <tr>
                <td>${man.id}</td>
                <td>
                    <a href="./${man.id}">
                            ${man.name}
                    </a>
                </td>
                <td>
                    <c:forEach items="${man.roleList}" var="item" varStatus="status">
                        <c:if test="${status.index ne 0}">
                            ,&nbsp;
                        </c:if>
                        <c:out value="${item.role}"/>
                    </c:forEach>
                </td>
                <td><a href="./${man.id}/delete" style="color: red;">delete</a></td>
            </tr>
        </c:forEach>
    </table>

    </div>
</body>
</html>