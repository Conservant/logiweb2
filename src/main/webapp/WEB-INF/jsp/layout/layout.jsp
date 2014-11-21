<%--
  Created by IntelliJ IDEA.
  User: Алексей Митенев
  Date: 21.11.2014
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>

<head>
    <title>
        <tiles:insertAttribute name="title" ignore="true"/>
    </title>
    <link href="style.css" rel="stylesheet">
</head>

<body>
<div class="wrapper">
    <tiles:insertAttribute name="header"/>
    <tiles:insertAttribute name="content"/>
    <aside class="left-sidebar">
    </aside>
</div>
<tiles:insertAttribute name="footer"/>
</body>
</html>
