<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<h3>Пользователи</h3>
<a href="<c:url value="/addTruck.html"/>">Добавить пользователя</a>

<table>

    <tr>
        <th>№</th>
        <th>Рег.номер</th>
        <th>Число водителей</th>
        <th>Класс вместимости</th>
    </tr>

    <c:forEach items="${trucks}" var="truck">
        <tr>
            <td><c:out value="${truck.id}"/></td>
            <td><c:out value="${truck.regNumber}"/></td>
            <td><c:out value="${truck.requiredNumberOfDrivers}"/></td>
            <td><c:out value="${truck.capacity}"/></td>

        </tr>
    </c:forEach>
</table>
</body>
</html>