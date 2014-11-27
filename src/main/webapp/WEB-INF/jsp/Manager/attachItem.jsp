<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="item" cssClass="registrationForm">

    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Название:</label>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label for="weight" class="col-sm-2 control-label">Вес:</label>
        <div class="col-sm-10">
            <form:input path="weight" cssClass="form-control"/>
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

    <br/>
    <div class="form-group">
        <input type="submit" value="Добавить груз" class="btn btn-lg btn-primary">
    </div>

</form:form>