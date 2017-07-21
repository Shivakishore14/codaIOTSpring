<%-- 
    Document   : login.jsp
    Created on : 4 Jul, 2017, 10:03:20 AM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="<c:url value="/static/style.css" />">
        <title>Login Page</title>
    </head>
    <body>
    	<jsp:include page="topNav.jsp" />
        <center>
            <h1>Login</h1>
        </center>
        
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <form:form action="login"  method="POST" modelAttribute="user">
                        <div class="form-group">
                        	<c:set var="emailError"><form:errors path="email" /></c:set>
                            <c:if test="${not empty emailError }">
                            	<label for="email">Please provide a valid email</label>
                            </c:if>
                            <div class="input-group">
                            	<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            	<form:input path="email" id="email" type="text" class="form-control" name="email" placeholder="Email" />
                        	</div>
                        </div>
                        <div class="form-group">
                        	<c:set var="passwordError"><form:errors path="password" /></c:set>
                            <c:if test="${not empty passwordError }">
                            	<label for="password">Please provide valid password</label>
                            </c:if>
                            <div class="input-group">
                            	<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            	<form:input path="password" id="password" type="password" class="form-control" name="password" placeholder="Password" />
                        	</div>
                        </div>
                        <div class="row full-width">
                            <center class="col-md-offset-1">
                                <br>
                                <input type="submit" class="btn btn-info"/>
                            </center>
                            <br>
                        </div>
                        <c:choose>
	                        <c:when test="${empty param.invalid}">
	                        </c:when>
	                        <c:otherwise>
        						<br><div  class="list-group-item list-group-item-danger"><c:out value="${param.invalid}"></c:out></div>
	                       </c:otherwise>
	                    </c:choose>                        	
                        
                    </form:form>
                    <center>
                        Don't have an account? <a href="signup">click here</a>
                    </center>
                </div>
            </div>
        </div>
    </body>
</html>
