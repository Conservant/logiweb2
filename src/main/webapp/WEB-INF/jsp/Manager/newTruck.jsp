<%--
  Created by IntelliJ IDEA.
  User: StarKiller
  Date: 20.11.2014
  Time: 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form action="./newTruck" method="POST">
        Truck reg number: <input type="text" name="regNumber"/><br/>
        Truck count drivers: <input type="text" name="reqDrivers"/><br/>
        Truck capacity: <input type="text" name="capacity"/><br/>
        <input type="submit" value="ADD TRUCK">

    </form>
</body>
</html>
