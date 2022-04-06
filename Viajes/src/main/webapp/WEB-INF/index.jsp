<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>

	<div class="container">
		<h1>Gastos de viaje</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Gasto</th>
					<th>Vendor</th>
					<th>Cantidad</th>
					<th>Acciones</th>	
				</tr>
			
			</thead>
			
			</tbody>
			
				<c:forEach var="gastos" items="${lista_gastos }">
					<tr>
						<td><c:out value="${gastos.getExpense_name() }"/></td>
						<td><c:out value="${gastos.getVendor() }"/></td>
						<td><c:out value="${gastos.getAmount() }"/></td>
						<td>
							<a href="/expenses/edit/${gastos.getId()}" class="btn btn-warning">Editar</a>
							<form action="/expenses/delete/${gastosz.getId()}" method="POST">
							
								<input type="hidden" name ="_method" value="DELETE">
								<button class ="btn btn-submit" type="submit">Eliminar</button>
							</form>
						</td>
					</tr>
				
				</c:forEach>
							
			
			
			</tbody>
		
		
		</table>
		<a href="/expenses/new" class="btn btn-primary">Agregar gasto</a>
		
	</div>
	
</body>
</html>