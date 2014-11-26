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

<h3>СТАТУС</h3>
${order.orderStatus}
<h3>ГРУЗОВИК</h3>
<c:out value="${order.truck == null ? '' : order.truck.regNumber}"/><br/>

<h3>Состав смены</h3>
<table>
    <c:forEach items="${driversFromOrders}" var="dr">
        <tr>
            <td><c:out value="${dr.name}"/></td>
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

<!-- Modal -->
<!-- Button trigger modal -->
<c:if test="${order.orderStatus == 'CREATED'}">
    <button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        Добавить груз
    </button>
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

<%--Форма добавления груза--%>
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