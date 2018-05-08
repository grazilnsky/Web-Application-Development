<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
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

            <h1>Login </h1>   
            <form method="post"  action="LoginController"> 
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname" required>
                </div>
                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required>
                </div>
        </div> 
        <div class="form-element">
            <input type="submit" value="Submit">
            <input type="reset" value="Reset">
        </div>
    
    
    <c:forEach items="${requestScope.errors}" var="error">
        <p>${error}</p>
    </c:forEach>



</body>

</html>