<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ include file="../layout/taglib.jsp"%>

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

<a href="<spring:url value="/Manager/newOrder.html" /> "  class="btn btn-lg btn-primary">Создать заказ</a>