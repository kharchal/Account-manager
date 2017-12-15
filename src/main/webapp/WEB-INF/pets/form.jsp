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
    <form:form modelAttribute="pet" action="./" method="post">
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
                <td><label for="name">NAME:</label></td>
                <td><form:input class="form-control" path="name" id="name"/></td>
                <td><form:errors cssStyle="color: red;" path="name"/></td>
            </tr>
            <tr>
                <td><label for="age">AGE:</label></td>
                <td><form:input class="form-control" path="age" id="age"/></td>
                <td><form:errors cssStyle="color: red;" path="age"/></td>
            </tr>
            <tr>
                <td><label for="kind">
                    <a href="../kinds/?backUrl=pets/${pet.id}&kindsUpdate=true">
                        KIND:
                    </a>
                </label></td>
                <td><form:select class="form-control" path="kind.id" id="kind" items="${kinds}"/></td>
                <td><form:errors cssStyle="color: red;" path="kind"/></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button class="btn btn-primary">Save it</button>
                </td>
                <td></td>
            </tr>
        </table>
    </form:form>
    <a href="../">list</a>
    </div>
</body>
</html>