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
    <h3>form</h3>
    <form:form modelAttribute="role" action="./" method="post">
        <table class="table">
            <colgroup>
                <col width="100px"/>
                <col width="200px"/>
            </colgroup>
            <tr>
                <td><label for="id">ID:</label></td>
                <td><form:input class="form-control" path="id" id="id" readonly="true"/></td>
                <td><form:errors cssStyle="color: red;" path="id"/></td>
            </tr>
            <tr>
                <td><label for="role">NAME:</label></td>
                <td><form:input class="form-control" path="role" id="role"/></td>
                <td><form:errors cssStyle="color: red;" path="role"/></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button class="btn btn-primary">Save it</button>
                </td>
                <td></td>
            </tr>
        </table>
    </form:form>
    <a href=".">list</a>
    </div>
</body>
</html>