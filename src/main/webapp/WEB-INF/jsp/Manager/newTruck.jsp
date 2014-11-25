<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="truck">

    <c:if test="${param.success eq true}">
        <div class = "alert alert-success">Грузовик добавлен</div>
    </c:if>

    <div class="form-group">
        <label for="regNumber" class="col-sm-2 control-label">Рег. номер</label>
        <div class="col-sm-10">
            <form:input path="regNumber" cssClass="form-control"/>
            <form:errors path="regNumber"/>
        </div>
    </div>

    <div class="form-group">
        <label for="capacity" class="col-sm-2 control-label">Вместимость:</label>
        <div class="col-sm-10">
            <form:input path="capacity" cssClass="form-control"/>
            <form:errors path="capacity"/>
        </div>
    </div>

    <div class="form-group">
        <label for="requiredNumberOfDrivers" class="col-sm-2 control-label">Число водителей:</label>
        <div class="col-sm-10">
            <form:input path="requiredNumberOfDrivers" cssClass="form-control"/>
            <form:errors path="requiredNumberOfDrivers"/>
        </div>
    </div>

    <div class="form-group">
        <input type="submit" value="Добавить" class="btn btn-lg btn-primary">
    </div>
</form:form>

<script type="text/javascript">
    $(document).ready(function() {
        $(".registrationForm").validate(
                {
                    rules: {
                        regNumber: {
                            required: true,
                            minlength: 3
                        },
                        capacity: {
                            required: true,
                            minLength: 6
                        },
                        requiredNumberOfDrivers: {
                            required: true,
                        }
                    },
                    highlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
                    },

                    unhighlight: function(element) {
                        $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
                    }
                }
        );
    });
</script>