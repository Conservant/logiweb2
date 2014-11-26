<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="attachedTruck" cssClass="registrationForm">

    <c:choose>
        <c:when test="${param.isFound eq false}">
            <div class = "alert alert-danger">Грузовик не найден</div>
        </c:when>
        <c:when test="${param.isBusy eq true}">
            <div class = "alert alert-danger">Указанный грузовик уже на заказе</div>
        </c:when>
        <c:when test="${param.notEnoughtCapacity eq true}">
            <div class = "alert alert-danger">Недостаточная грузоподъемность</div>
        </c:when>
    </c:choose>

    <div class="form-group">
        <label for="regNumber" class="col-sm-2 control-label">Номер:</label>
        <div class="col-sm-10">
            <form:input path="regNumber" cssClass="form-control"/>
        </div>
    </div>
    <br/><br/>
    <div class="form-group">
        <input type="submit" value="Назначить" class="btn btn-lg btn-primary">
    </div>

</form:form>
