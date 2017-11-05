<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<c:import url="cabe�alho.jsp" />
<!DOCTYPE html>
<html>
	<head>
		<link href="css/jquery.css" rel="stylesheet">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-ui.js"></script>
		<meta charset="UTF-8">
		<title>Teste Contato</title>
	</head>
	<body>
		<h1>adicionaContato</h1>
		<hr />
		<form action="adicionaContato">
			Nome: <input type="text" name="nome" /><br />
			E-mail: <input type="text" name="email" /><br />
			Endereco: <input type="text" name="endereco" /><br />
			Data Nascimento: <caelum:campoData id="dataNascimento" /><br />
				
			<input type="submit" value="Gravar" />
		</form>
		<c:import url="rodape.jsp" />
	</body>
</html>