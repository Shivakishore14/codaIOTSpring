<%-- 
    Document   : signup
    Created on : 4 Jul, 2017, 10:53:56 AM
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
        <script src="<c:url value="/static/script.js" />"></script>
        <title>SignUp Page</title>
    </head>
    <body>
        <jsp:include page="topNav.jsp" />
        <center>
            <h1>SignUp</h1>
        </center>
        
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <form:form action="signup"  method="POST" modelAttribute="user">
                    	<div class="form-group">
                        	<c:set var="emailError"><form:errors path="email" /></c:set>
                            <c:if test="${not empty emailError }">
                            	<label for="email">Please provide a valid email</label>
                            </c:if>
	                        <div class="input-group">
	                            <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
	                            <form:input path="email" id="email" type="text" class="form-control" name="email" placeholder="Email"/>
	                        </div>
	                    </div>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input path="firstName" id="fname" type="text" class="form-control" name="firstName" placeholder="First Name" />
                        </div>
                        <div class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input path="secondName" id="lname" type="text" class="form-control" name="secondName" placeholder="Last Name" />
                        </div>
                        <div class="form-group">
                        	<c:set var="phoneError"><form:errors path="phone" /></c:set>
                            <c:if test="${not empty phoneError }">
                            	<label for="password">Please provide valid PhoneNumber</label>
                            </c:if>
	                        <div class="input-group">
	                            <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
	                            <form:input path="phone" id="phone" type="text" class="form-control" name="phone" placeholder="Phone Number" />
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
                        <div class="input-group row full-width">
                            <div class="col-md-4 col-md-offset-4">
                                <button type="submit" id="submit" class="btn btn-info full-width">Submit</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
            <br>
            <center>
                Already have an account? <a href="/codaiot/login">click here</a>
            </center>
        </div>
        <div id="notification" class="container-fluid">
            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4" id="notificationArea"></div>
                <div class="col-md-4"></div>
            </div>
        </div>
    </body>
    <script>
        $("#submit").on("click", function(){
            var obj = {};
            obj.email = $("#email").val();
            obj.fname = $("#fname").val();
            obj.lname = $("#lname").val();
            obj.phone = $("#phone").val();
            obj.password = $("#password").val();

            $.post("signup", obj, function(result){
                result = JSON.parse(result);
                //console.log(result);
                notify(result.message);
            });
        });
    </script>
</html>
