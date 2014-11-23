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
    </tr>


    <c:forEach items="${trucks}" var="tr">
        <tr>
            <td><c:out value="${tr.id}"/></td>
            <td><c:out value="${tr.regNumber}"/></td>
            <td><c:out value="${tr.requiredNumberOfDrivers}"/></td>
            <td><c:out value="${tr.capacityClass}"/></td>

        </tr>
    </c:forEach>


</table>

<br/>
<a href="./newTruck.html">Добавить грузовик</a>