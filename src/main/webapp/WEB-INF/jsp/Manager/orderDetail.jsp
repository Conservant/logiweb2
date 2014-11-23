<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h2>Заказ № ${order.id}</h2>


Позиции в заказе
<table class = "table bordered-table hover-table">
<tr>
    <th>Наименование</th>
    <th>Вес</th>
    <th>Координаты доставки</th>
</tr>
    <c:forEach items="${order.items}" var="item">
        <tr>
            <td>
                <c:out value="${item.name}"/>
            </td>
            <td>
                <c:out value="${item.weight}"/>
            </td>
            <td>
                <c:out value="${item.latitude}"/>;
                <c:out value="${item.longitude}"/>
            </td>
        </tr>
    </c:forEach>

</table>
