<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Register New User Form</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="styleSheet" type="text/css" href="resources/css/bootstrap.css">
<script src="resources/js/jquery.js" type="text/javascript"></script>
<script src="resources/js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
    <div>
        <div id="loginbox" style="margin-top: 50px;" class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <div class="panel-title">Register New User</div>
                </div>
                <div style="padding-top: 30px" class="panel-body">
                    <form:form action="${pageContext.request.contextPath}/register/processRegistrationForm" modelAttribute="crmUser"
                        class="form-horizontal">
                        <div class="form-group">
                            <div class="col-xs-15">
                                <div>
                                    <c:if test="${registrationError != null}">
                                        <div class="alert alert-danger col-xs-offset-1 col-xs-10">${registrationError}</div>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                            <form:input path="userName" placeholder="username" class="form-control" />
                        </div>
                        <div style="margin-bottom: 25px" class="input-group">
                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                            <form:password path="password" placeholder="password" class="form-control" />
                        </div>
                        <div style="margin-top: 10px" class="form-group">
                            <div class="col-sm-6 controls">
                                <button type="submit" class="btn btn-primary">Register</button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>