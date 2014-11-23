<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="truck">

    <c:if test="${param.success eq true}">
        <div class = "alert alert-success">Грузовик добавлен</div>
    </c:if>

    <div class="form-group">
        <label for="regNumber" class="col-sm-2 control-label">Регистрационный номер</label>
        <div class="col-sm-10">
            <form:input path="regNumber" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="capacity" class="col-sm-2 control-label">Вместимость (в тоннах):</label>
        <div class="col-sm-10">
            <form:input path="capacity" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <input type="submit" value="Добавить" class="btn btn-lg btn-primary">
    </div>

</form:form>