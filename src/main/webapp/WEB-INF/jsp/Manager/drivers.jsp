<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ include file="../layout/taglib.jsp"%>

<h3>Водители</h3>

<table class="table table-bordered table-hover">

    <tr>
        <th>ИмяФамилия</th>
        <th>Номер прав</th>
        <th>Статус</th>
    </tr>

    <c:forEach items="${drivers}" var="driver">
        <tr>
            <td><c:out value="${driver.name}"/></td>
            <td><c:out value="${driver.licenseNumber}"/></td>
            <td><c:out value="${driver.driverStatus}"/></td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="<spring:url value="/Manager/newDriver.html" /> " class="btn btn-primary btn-lg">
    Добавить водителя
</a>