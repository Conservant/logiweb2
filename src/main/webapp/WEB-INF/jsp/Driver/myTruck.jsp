<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<H2>Грузовик</H2>

<table class="table table-bordered table-hover">

    <tr>
        <th>№</th>
        <th>Рег.номер</th>
        <th>Число водителей</th>
        <th>Класс вместимости</th>
    </tr>
    <tr>
        <td><c:out value="${myTruck.id}"/></td>
        <td><c:out value="${myTruck.regNumber}"/></td>
        <td><c:out value="${myTruck.requiredNumberOfDrivers}"/></td>
        <td><c:out value="${myTruck.capacityClass}"/></td>
    </tr>

</table>