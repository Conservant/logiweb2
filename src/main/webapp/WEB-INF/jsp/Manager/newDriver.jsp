
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<form:form commandName="driver" cssClass="registrationForm">

    <c:if test="${param.success eq true}">
        <div class = "alert alert-success">Водитель добавлен</div>
    </c:if>
    
    <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Имя-Фамилия:</label>
        <div class="col-sm-10">
            <form:input path="name" cssClass="form-control"/>
            <form:errors path="name"/>
        </div>
    </div>

    <div class="form-group">
        <label for="licNumber" class="col-sm-2 control-label">Номер водителького удостоверения:</label>
            <div class="col-sm-10">
                <form:input path="licNumber" cssClass="form-control"/>
                <form:errors path="licNumber"/>
            </div>
    </div>
    <br/><br/>
    <div class="form-group">
        <input type="submit" value="Добавить" class="btn btn-lg btn-primary">
    </div>


</form:form>

<script type="text/javascript">
    $(document).ready(function() {
        $(".registrationForm").validate(
                {
                rules: {
                    name: {
                        required: true,
                        minlength: 3
                    },
                    licNumber: {
                        required: true,
                        minLength: 6
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