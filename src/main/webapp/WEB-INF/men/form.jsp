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
    <h2>form</h2>
    <form:form modelAttribute="man" action="./" method="post">
        <table class="table">
            <colgroup>
                <col width="100px"/>
                <col width="200px"/>
            </colgroup>
            <c:if test="${not empty man.id && man.id ne 0}">
            <tr>
                <td><label for="id">ID:</label></td>
                <td><form:input class="form-control" path="id" id="id" readonly="true"/></td>
                <td><form:errors cssStyle="color: red;" path="id"/></td>
            </tr>
            </c:if>
            <tr>
                <td><label for="name">NAME:</label></td>
                <td><form:input class="form-control" path="name" id="name"/></td>
                <td><form:errors cssStyle="color: red;" path="name"/></td>
            </tr>
            <tr>
                <td>
                    <b>ROLE:</b>
                </td>
                <td colspan="2">
                    <input type="hidden" name="roleid" value="0"/>
                    <c:forEach var="r" items="${roles}">
                        <input type="checkbox" name="roleid" value="${r.id}" id="chbx_${r.id}" ${man.roleList.contains(r) ? "checked='checked'" : ""}/>
                        <label for="chbx_${r.id}"><c:out value="${r.role}"/></label>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    </c:forEach>
                    <form:errors cssStyle="color: red;" path="roleList"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <button class="btn btn-primary">Save it</button>
                </td>
                <td></td>
            </tr>
        </table>
    </form:form>
    <a href="./${man.id}/prev">&lt;= prev</a> |
    <a href="../">list</a> |
    <a href="./${man.id}/next">next =&gt;</a>
    <hr>
    <h3>Pet list</h3>
    <table class="table">
        <tr>
            <th width="10%">#</th>
            <th width="10%">id</th>
            <th width="30%">name</th>
            <th width="15%">age</th>
            <th width="15%">kind</th>
            <th width="25%"></th>
        </tr>
        <c:forEach var="pet" items="${man.petList}" varStatus="cnt">
            <tr>
                <td>${cnt.count}</td>
                <td>${pet.id}</td>
                <td>
                    <a href="../pets/${pet.id}">
                            ${pet.name}
                    </a>
                </td>
                <td>${pet.age}</td>
                <td>${pet.kind.value}</td>
                <td><a href="./${man.id}/pets/${pet.id}/delete" style="color: red;">delete</a></td>
            </tr>
        </c:forEach>
    </table>
    <hr>
    <h3>Manless pet list</h3>
    <table class="table">
        <tr>
            <th width="10%">#</th>
            <th width="10%">id</th>
            <th width="30%">name</th>
            <th width="15%">age</th>
            <th width="15%">kind</th>
            <th width="25%"></th>
        </tr>
        <c:forEach var="pet" items="${pets}" varStatus="cnt">
            <tr>
                <td>${cnt.count}</td>
                <td>${pet.id}</td>
                <td>
                    <a href="../pets/${pet.id}">
                            ${pet.name}
                    </a>
                </td>
                <td>${pet.age}</td>
                <td>${pet.kind.value}</td>
                <td><a href="./${man.id}/pets/${pet.id}/add" style="color: green;">add</a></td>
            </tr>
        </c:forEach>
    </table>
    </div>
</body>
</html>