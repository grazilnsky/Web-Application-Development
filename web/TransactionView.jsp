<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="Domain.Product"%>
<%@ page import="Domain.Purchase"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <title>Login</title>
    </head>
    <body>
        <%!
            public void jspInit() {
                System.out.print("Started");
            }

        %>
        <div id="content">
            <div class="header">
                <img src="./img/companyLogo.jpg" width="100px"/>
                <span class="header-text">COMPANY NAME</span>
            </div>
            <div class="navigation">
                <%@ include file="WEB-INF/nav.jspf"%>
            </div>

            <h1>VA MULTUMIM CA ATI CUMPARAT DE LA NOI! </h1>   

        </div> 


            
            <c:forEach items="${requestScope.transaction}" var="trans">
                <p>${trans.buy()}</p>
            </c:forEach>
    </body>
</html>
