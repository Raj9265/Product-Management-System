<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/view/base.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container mt-3">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h1 class="text-center mb-3">Login</h1>
				<form action="login.html" method="post">
					<div class="form-group">
						<label for="username">Username</label>
						<input type="text" class="form-control" id="username" name="username" placeholder="Enter your username" required>
					</div>
					<div class="form-group">
						<label for="password">Password</label>
						<input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
					</div>
					<c:if test="${not empty error}">
						<p class="text-center" style="color: red">${error}</p>
					</c:if>
					<div class="container text-center">
						<button type="submit" class="btn btn-primary">Login</button> &nbsp &nbsp
						<a href="register.html" class="btn btn-outline-success">Register</a>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>