<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@include file="./base.jsp"%>
</head>
<body>

	<div class="container mt-3">

		<div class="row">

			<div class="col-md-6 offset-md-3">

				<h1 class="text-center mb-3">Change Product Details</h1>

				<f:form action="handle-product.html" method="post"
					modelAttribute="key2">

					<%-- <input type="hidden" value="${product.id}" name="id" /> --%>
					<f:hidden path="id" />
					<div class="form-group">
						<label for="name">Product Name</label>
						<%--  <input type="text" class="form-control" id="name" aria-describedby="emailHelp"
							name="name" placeholder="Enter the product name here"
							value="${product.name }"> --%>
						<f:input path="name" class="form-control"
							aria-describedby="emailHelp"
							placeholder="Enter the product name here" />
					</div>


					<div class="form-group">

						<label for="description">Product Description</label>
						<%-- <textarea class="form-control" name="description" id="description"
							rows="5" placeholder="Enter the product description">${product.description }
							</textarea> --%>
						<f:input path="description" class="form-control" rows="5"
							placeholder="Enter the product description" />
					</div>



					<div class="form-group">
						<label for="price">Product Price</label>
						<%-- <input type="text"
							placeholder="Enter Product Price" name="price"
							class="form-control" id="price" value="${product.price }"> --%>
						<f:input path="price" placeholder="Enter Product Price"
							class="form-control" />
					</div>

					<div class="container text-center">




						<button type="submit" class="btn btn-warning">Update</button>
					</div>
				</f:form>


			</div>

		</div>

	</div>

</body>
</html>