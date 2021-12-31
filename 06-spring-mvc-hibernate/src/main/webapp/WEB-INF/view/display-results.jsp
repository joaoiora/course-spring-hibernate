<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Spring Demo - Multiple Data Sources</title>
</head>
<body>
	<div class="container">
		<h1>Spring Demo - Multiple Data Sources</h1>
		<h3>Data Source 1: Employees</h3>
		<table class="table table-bordered table-striped">
			<thead class="table-primary">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employees}">
					<tr>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr>
		<h3>Data Source 2: Customers</h3>
		<table class="table table-bordered table-striped">
			<thead class="table-success">
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="customer" items="${customers}">
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>