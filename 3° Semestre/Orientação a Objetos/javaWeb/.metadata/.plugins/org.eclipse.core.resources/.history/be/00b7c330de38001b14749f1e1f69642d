<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!float resultado;%>
 <form action="" name="operacao">
 <label> Primeiro Numero: </label> <br> <label> Segundo Numero: </label>
 
 <br />
 
 <input type="number" name="num1">
 
 <select name="operacao">
	 <option value="+">+</option>
     <option value="-"> - </option> 
     <option value="*"> * </option>
     <option value="/"> / </option>
 </select> 

 <input type="number" name="num2">
 
 <input type="submit" value="Calcular" onClick= <%
	
 	float num1 = Integer.parseInt(request.getParameter("num1"));
 	float num2 = Integer.parseInt(request.getParameter("num2"));
 	char operacao = request.getParameter("operacao").charAt(0);
 	
 	
 	switch(operacao){
 	case '+':
 		resultado = num1 + num2;
 		break;
 	case '-':
 		resultado = num1 - num2;
 		break;
 	case '*':
 		resultado = num1*num2;
 		break;
 	case '/':
 		resultado = num1/num2;
 	}
 		
 %>>
 <br /> <br />
 <label> <%=num1%> <%=operacao%> <%=num2%> <%=resultado%>>></label>

 
</form>
 
</body>
</html>