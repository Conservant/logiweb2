<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../layout/taglib.jsp"%>

<H2>Водители</H2>

<c:if test="${param.anotherDriverIsDriving eq true}">
    <div class = "alert alert-danger">Другой водитель за рулем!</div>
</c:if>

<table class="table table-bordered table-hover">

    <tr>
        <th>Имя</th>
        <th>Номер прав</th>
        <th>Статус</th>
    </tr>

    <c:forEach items="${myDrivers}" var="driver">
        <tr>
            <td><c:out value="${driver.name}"/></td>
            <td><c:out value="${driver.licenseNumber}"/></td>
            <td>
                <c:if test="${driver.driverStatus eq 'ON_ROUTE'}">
                    На смене
                </c:if>

                <c:if test="${driver.driverStatus eq 'DRIVING'}">
                    За рулем
                </c:if>
        </tr>
    </c:forEach>
</table>

<div class="btn-group" role="group" aria-label="...">

    <a href="<spring:url value="/Driver/drive.html" /> ">
    <button type="button" class="btn btn-default">
        За рулем
    </button>
    </a>


    <a href="<spring:url value="/Driver/route.html" /> ">
    <button type="button" class="btn btn-default">
        На смене
    </button>
    </a>

</div>


