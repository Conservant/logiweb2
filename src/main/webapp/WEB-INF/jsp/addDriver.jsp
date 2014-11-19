<%--
  Created by IntelliJ IDEA.
  User: StarKiller
  Date: 17.11.2014
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
<sf:form method="POST" modelAttribute="driver">
    <label>Имя</label>
    <sf:input path="name"/>
    <label>Номер прав</label>
    <sf:input path="licNumber"/>
    <input type="submit" value="Добавить">
</sf:form>

</body>
</html>
