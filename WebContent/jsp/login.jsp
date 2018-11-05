<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
			<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
			<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
			<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
			<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
	</head>
	<body>
		<form class="col-md-5 offset-md-3" method="GET" action="/conecta">
			<div class="form-group row" >
			<input type="hidden" name="opcion" value="4">
				<label for="user" class="col-md-1 col-form-label">User:</label>
				<div class="col-md-10">
					<input tpe="text" class="form-control" name="user" value="" placeholder="Usuario" id="user">
				</div>
			</div>
			<div class="form-group row">
				<label for="pass" class="col-md-1 col-form-label">Password</label>
				<div class="col-md-10">
					<input tpe="password" class="form-control" value="" name="password" placeholder="Contraseña" id="pass">
					
				</div>
			</div>
			<input type="submit" value="Accept" class="btn btn-primary">
		</form>
	</body>
</html>