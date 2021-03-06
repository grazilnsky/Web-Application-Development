<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.List"%>
<%@ page import="Domain.Product"%>
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

            <h1>PRODUSELE NOASTRE SUNT AICI </h1>   

        </div> 


        <c:choose> 
            <c:when test="${not empty sessionScope.user_session}">
                <form method="post"  action="CartController">
                    <c:forEach items="${applicationScope.products}" var="product" varStatus="i">
                        <p>${product.display()}</p>
                        <div class="form-element">
                            <label for="quantity">Quantity</label>
                            <input type="number" name="qty<c:out value="${i.index}"></c:out>" id="qty" value="0">
                            </div>
                    </c:forEach>
                    <div class="form-element">
                        <input type="submit" value="Submit">
                        <input type="reset" value="Reset">
                    </div> 
                </form>
            </c:when>
            <c:otherwise>
                <c:forEach items="${applicationScope.products}" var="product">
                    <p>${product.display()}</p>
                </c:forEach>
            </c:otherwise>
        </c:choose>
    </body>

</html>