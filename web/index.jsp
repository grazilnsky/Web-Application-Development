
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link rel="stylesheet" href="style.css" type="text/css"/>
        <title>Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
    </head>
    <body>
        <div id="content">
            <div class="header">
                <img src="./img/companyLogo.jpg" width="100px"/>
                <span class="header-text">COMPANY NAME</span>
            </div>
            <%@ include file="WEB-INF/nav.jspf"%>
            <h1>Registration form</h1>   
            <form method="post"  action="RegistrationController"> 
                <div class="form-element">
                    <label for="name">Name</label>
                    <input type="text" name="name" id="name" size="40" required>
                </div>
                <div class="form-element">
                    <label for="username">Username</label>
                    <input type="text" name="uname" id="uname" required>
                </div>
                <div class="form-element">
                    <label for="password">Password</label>
                    <input type="password" name="password" id="password" required>
                </div>
                <div class="form-element">
                    <label for="rPassword">Repeat password</label>
                    <input type="password" id="rPassword" required>
                </div>
                <div class="form-element">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-element">
                    <label for="gender">Gender</label>
                    Male<input type="radio" name="gender" value="male"> 
                    Female<input type="radio" name="gender" value="female"> 
                </div>
                <div class="form-element">
                    <label for="tel">Telephone</label>
                    <input type="tel" name="tel" id="tel">
                </div>
                <div class="form-element">
                    <label for="country">Country</label>
                    <select name="country" id="country">
                        <option>Romania</option>
                        <option>Italy</option>
                        <option>France</option>
                        <option>Germany</option>
                    </select>
                </div>
                <div class="form-element">
                    <label for="spam">Subscribe to mailing list</label>
                    <input type="checkbox" name="spam" id="spam">
                </div> 
                <div class="form-element">
                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset">
                </div>  


            </form>

        </div>
        
        <c:forEach items="${requestScope.RegistrationErrors}" var="error">
            <p>${error}</p>
        </c:forEach>
    </body>
</html>


