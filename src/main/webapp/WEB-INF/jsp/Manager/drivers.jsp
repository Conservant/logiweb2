<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<table class="table table-bordered table-hover">

    <tr>
        <th>ИмяФамилия</th>
        <th>Номер прав</th>
        <th>Статус</th>
    </tr>

    <c:forEach items="${drivers}" var="driver">
        <tr>
            <td><c:out value="${driver.name}"/></td>
            <td><c:out value="${driver.licNumber}"/></td>
            <td><c:out value="${driver.driverStatus}"/></td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href = "./newDriver">Добавить водителя</a>