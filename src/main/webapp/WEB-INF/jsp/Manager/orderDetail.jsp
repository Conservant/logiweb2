<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>

<%@ include file="../layout/taglib.jsp"%>

<h4 align="center">Заказ № ${order.id}</h4>

<c:if test="${param.isDriverAttached eq true}">
    <div class = "alert alert-success">Водитель добавлен</div>
</c:if>

<c:if test="${param.isTruckAttached eq true}">
    <div class = "alert alert-success">Грузовик добавлен</div>
</c:if>

<c:if test="${param.isConfirmed eq true}">
    <div class = "alert alert-success">Заказ подтвержден</div>
</c:if>

<c:if test="${param.isConfirmed eq false}">
    <div class = "alert alert-danger">Заказ не подтвержден! Пустой заказ!</div>
</c:if>

<c:if test="${param.isComplete eq true}">
    <div class = "alert alert-success">Смена сформирована</div>
</c:if>

<c:if test="${param.isItemAttached eq true}">
    <div class = "alert alert-success">Груз добавлен</div>
</c:if>

СТАТУС
<h3>${order.orderStatus}</h3>
ГРУЗОВИК
<h3><c:out value="${order.truck == null ? '' : order.truck.regNumber}"/></h3>

Состав смены
<table>
    <c:forEach items="${driversFromOrder}" var="dr">
        <tr>
            <td><h2><c:out value="${dr.name}"/></h2></td>
        </tr>
    </c:forEach>
</table>
<br/>

<h3>Позиции в заказе</h3>
<table class = "table bordered-table hover-table">
    <tr>
        <th>Наименование</th>
        <th>Вес</th>
        <th>Координаты доставки</th>
        <th>Статус доставки</th>
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
            <td>
                <c:out value="${item.delivery}"/>
            </td>
        </tr>
    </c:forEach>
</table>

<c:if test="${order.orderStatus == 'CREATED'}">
    <a href="<spring:url value="/Manager/orders/${order.id}/attachItem.html" /> " class="btn btn-primary btn-lg">
        Добавить груз
    </a>
    <br/>
    <br/>
</c:if>

<c:if test="${order.orderStatus == 'CREATED'}">
    <a href="<spring:url value="/Manager/orders/${order.id}/confirm.html" /> " class="btn btn-primary btn-lg">
        Подтвердить заказ
    </a>
</c:if>

<c:if test="${order.orderStatus == 'CONFIRMED' and order.truck == null}">
    <a href="<spring:url value="/Manager/orders/${order.id}/attachTruck.html" /> " class="btn btn-primary btn-lg">
        Назначить грузовик
    </a>
</c:if>

<c:if test="${order.orderStatus == 'CONFIRMED' and order.truck != null}">
    <a href="<spring:url value="/Manager/orders/${order.id}/attachDriver.html" /> " class="btn btn-primary btn-lg">
        Добавить водителя
    </a>
</c:if>

<c:if test="${order.orderStatus == 'PERFORMED'}">
    <a href="<spring:url value="/Manager/orders/${order.id}/close.html" /> " class="btn btn-primary btn-lg">
        Закрыть заказ
    </a>
</c:if>
