<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="attachedDriver" cssClass="registrationForm">
    <c:choose>
        <c:when test="${param.isFound eq false}">
            <div class = "alert alert-danger">Водитель не найден</div>
        </c:when>
        <c:when test="${param.isBusy eq true}">
            <div class = "alert alert-danger">Водитель уже на смене</div>
        </c:when>
    </c:choose>

    <div class="form-group">
        <label for="licenseNumber" class="col-sm-2 control-label">Номер прав:</label>
        <div class="col-sm-10">
            <form:input path="licenseNumber" cssClass="form-control"/>
        </div>
    </div>

    <br/><br/><br/>
    <div class="form-group">
        <input type="submit" value="Назначить" class="btn btn-lg btn-primary">
    </div>

</form:form>

