<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ include file="../layout/taglib.jsp"%>

<h3>Грузовики</h3>

<table class="table table-bordered table-hover">

    <tr>
        <th>№</th>
        <th>Рег.номер</th>
        <th>Число водителей</th>
        <th>Класс вместимости</th>
        <th>Номер заказа</th>
    </tr>

    <c:forEach items="${trucks}" var="tr">
        <tr>
            <td><c:out value="${tr.id}"/></td>
            <td><c:out value="${tr.regNumber}"/></td>
            <td><c:out value="${tr.requiredNumberOfDrivers}"/></td>
            <td><c:out value="${tr.capacityClass}"/></td>
            <td><c:out value="${tr.order == null ? '---' : tr.order.id}"/></td>
        </tr>
    </c:forEach>

</table>

<br/>
<a href="<spring:url value="/Manager/newTruck.html" /> " class="btn btn-primary btn-lg">
    Добавить грузовик
</a>
