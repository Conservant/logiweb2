<%@ page language="java"   contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->

    <script
            src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <script type="application/javascript"
            src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.11.1/jquery.validate.min.js">

            </script>
    <title>
        <tiles:getAsString name="title"/>
    </title>
</head>

<body>

    <tilesx:useAttribute name="current"/>

    <div class="container">

        <!-- Static navbar -->
        <nav class="navbar navbar-default" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<spring:url value="/" />">Грузоперевозки 2.0</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">

                        <li class="${current == 'index' ? 'active' : ''}"><a href="<spring:url value="/" />">Home</a></li>
                        <security:authorize access="hasRole('ROLE_MANAGER')">
                            <li class="${current == 'trucks' ? 'active' : ''}"><a href="<spring:url value="/trucks.html" />">Грузовики</a></li>
                            <li class="${current == 'drivers' ? 'active' : ''}"><a href="<spring:url value="/drivers.html" />">Водители</a></li>
                            <li class="${current == 'orders' ? 'active' : ''}"><a href="<spring:url value="/orders.html" />">Заказы</a></li>
                        </security:authorize>
                        <security:authorize access="! isAuthenticated()">
                            <li class="${current == 'login' ? 'active' : ''}"><a href="<spring:url value="/login.html" />">Login</a></li>
                        </security:authorize>
                        <security:authorize access="isAuthenticated()">
                            <li><a href="<spring:url value="/logout" />">Logout</a></li>
                        </security:authorize>
                    </ul>

                </div><!--/.nav-collapse -->
            </div><!--/.container-fluid -->
        </nav>
        <br/>
        <br/>
        <br/>
            <tiles:insertAttribute name="header"/>
            <tiles:insertAttribute name="content"/>
        <aside class="left-sidebar">
        </aside>

        <center>
            <tiles:insertAttribute name="footer"/>
        </center>

    </div>

</body>
</html>
