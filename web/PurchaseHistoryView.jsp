<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.Map"%>
<%@ page import="Classes.Product"%>
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
        </div> 
        <!--<% Map<Product, Integer> purchases;
            //purchases = (Map<Product, Integer>) this.getServletContext().getAttribute("purchases");
            purchases = (Map<Product, Integer>) request.getAttribute("purchases");
            out.println("<p>Hello, " + request.getSession().getAttribute("user_session") + "! Here are your purchases.</p>");
            if (purchases != null && !purchases.isEmpty()) {
                for (Map.Entry<Product, Integer> t : purchases.entrySet()) {
                    out.println(t.getKey().getName() + ", " + t.getValue() + "</br>");
                }
            }
        %>-->
        
        <p>Hello, ${sessionScope.user_session}! Here are your purchases.</p></br>
        <c:forEach items="${requestScope.purchases}" var="purchase">
            <p>${purchase.key.getName()}, ${purchase.value} </p>
        </c:forEach>
    </body>
</html>
