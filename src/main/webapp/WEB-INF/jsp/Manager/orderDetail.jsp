<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2>Заказ № ${order.id}</h2>

<!-- Button trigger modal -->
<c:if test="${order.orderStatus == 'CREATED'}">
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
    Добавить в заказ
</button>
</c:if>
<!-- Modal -->

<form:form commandName="item" cssClass="form-horizontal">
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">Добавление груза в заказ</h4>
            </div>
            <div class="modal-body">

                <div class="form-group">
                    <label for="name" class="col-sm-2 control-label">Название:</label>
                    <div class="col-sm-10">
                        <form:input path="name" cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="longitude" class="col-sm-2 control-label">Долгота:</label>
                    <div class="col-sm-10">
                        <form:input path="longitude" cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="latitude" class="col-sm-2 control-label">Широта:</label>
                    <div class="col-sm-10">
                        <form:input path="latitude" cssClass="form-control"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="weight" class="col-sm-2 control-label">Вес:</label>
                    <div class="col-sm-10">
                        <form:input path="weight" cssClass="form-control"/>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Отмена</button>
                <input type="submit" class="btn btn-primary" value="Добавить"/>
            </div>
        </div>
    </div>
</div>
</form:form>

<br/><br/>

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



<c:if test="${order.orderStatus == 'CREATED'}">
    <a href="<spring:url value="/order/confirm/${order.id}.html" /> " class="btn btn-primary btn-lg">
        Подтвердить заказ
    </a>
</c:if>

<c:if test="${order.orderStatus == 'CONFIRMED' and order.truck == null}">
    <a href="<spring:url value="/order/attachTruck/${order.id}.html" /> " class="btn btn-primary btn-lg">
        Назначить грузовик
    </a>
</c:if>

<c:if test="${order.orderStatus == 'CONFIRMED' and order.truck != null}">
    <a href="<spring:url value="/order/attachDrivers/${order.id}.html" /> " class="btn btn-primary btn-lg">
        Отправить в рейс
    </a>
</c:if>

<c:if test="${order.orderStatus == 'PERFORMED'}">
    <a href="<spring:url value="/order/close/${order.id}.html" /> " class="btn btn-primary btn-lg">
        Закрыть заказ
    </a>
</c:if>
