<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            <h1>SHOPPING CART </h1>   

            <form method="post"  action="BuyController2">
                <c:forEach items="${sessionScope.shopping_cart}" var="purchase" varStatus="i">
                    <p>${purchase.display()}</p>
                    <div class="form-element">
                        <input type="submit" name="<c:out value="${i.index}"></c:out>" id="remove" value="Remove" formaction="RemoveController">
                        </div>
                </c:forEach>
                <div class="form-element">
                    <input type="submit" value="Checkout">
                </div> 
            </form>

    </body>
</div> 
