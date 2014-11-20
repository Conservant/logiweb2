<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Заказы</title>
</head>
<body>
<h3>Заказы</h3>


<table>

    <tr>
        <th>Номер заказа</th>
        <th>Статус</th>
    </tr>

    <c:forEach items="${orders}" var="order">
        <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.orderStatus}"/></td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href = "./newOrder">Создать заказ</a><br/>
<a href="">Добавить грузы</a>
<a href="">Назанчить грузовик и водителей</a>
<a href="">Закрыть заказ</a>
</body>
</html>