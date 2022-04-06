<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar gasto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
	<div class="container">
		<h1>Editar gasto</h1>
		
		<form:form action="/expenses/edit/${gasto.id}" method="post" modelAttribute="gasto">			
			<input type="hidden" name="_method" value="put">
			<form:input type="hidden" path="id" value="${gasto.id}"/>
			
			<div class="form-group">
			
				<form:label path="expense_name">Gasto</form:label>
				<form:input path="expense_name" class="form-control" value="${gasto.getExpense_name()}"/>
				<form:errors path="expense_name"/>
			</div>
			
			<div class="form-group">
				<form:label path="vendor">Vendor</form:label>
				<form:input path="vendor" class="form-control" value="${gasto.getVendor()}"/>
				<form:errors path="vendor"/>
			</div>
			
			<div class="form-group">
				<form:label path="amount">Cantidad</form:label>
				<form:input path="amount" class="form-control" value="${gasto.getAmount()}"/>
				<form:errors path="amount"/>
			</div>
			
			<div class="form-group">
				<form:label path="description">descripcion</form:label>
				<form:input path="description" class="form-control" value="${gasto.getDescription()}"/>
				<form:errors path="description"/>
			</div>
			<input type="submit" value="guardar" class="btn btn-succes">
			
		</form:form>
	</div>
</body>
</html>