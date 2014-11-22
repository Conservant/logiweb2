<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<h3>Заказы</h3>

<table class="table table-bordered table-hover">

    <tr>
        <th>Номер заказа</th>
        <th>Статус</th>
    </tr>

    <c:forEach items="${orders}" var="order">

            <tr>
                <td>
                    <a href="<spring:url value="/orders/${order.id}.html" />"><c:out value="${order.id}"/></a>
                </td>
                <td><c:out value="${order.orderStatus}"/></td>
            </tr>

    </c:forEach>
</table>

<br/>
<a href =   "./newOrder"    >Создать заказ</a><br/>
<a href=    "./confirmOrder">Добавить грузы</a><br/>
<a href=    "./shipOrder"   >Назначить грузовик и водителей</a><br/>
<a href=    "./closeOrder"  >Закрыть заказ</a><br/>
