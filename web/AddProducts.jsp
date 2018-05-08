<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
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

        <div id="content">
            <div class="header">
                <img src="./img/companyLogo.jpg" width="100px"/>
                <span class="header-text">COMPANY NAME</span>
            </div>

            <%@ include file="WEB-INF/nav.jspf"%>
            <h1>WELCOME TO OUR PAGE! </h1>  
            <h2>Add Product </h2>   
            <form method="post" action="ProductAddController"> 
                <div class="form-element">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" required>
                </div>
                <div class="form-element">
                    <label for="type">Type</label>
                    <input type="text" name="type" id="type" required>
                </div>

                <div class="form-element">
                    <label for="description">Description</label>
                    <input type="text" name="description" id="description" required>
                </div>
                <div class="form-element">
                    <label for="unitPrice">Unit Price</label>
                    <input type="text" name="unitPrice" id="unitPrice" required>
                </div>
                <div class="form-element">
                    <input type="submit" value="Add Product">
                </div>
        </div>    
    </form>
    <c:forEach items="${requestScope.errors}" var="error">
        <p>${error}</p>
    </c:forEach>
</body>

</html>
