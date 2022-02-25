<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Game</title>
</head>
<body>
<form action = "editItemServlet" method="post">
Title: <input type ="text" name = "title" value="${itemToEdit.title}"> <br>
Publisher: <input type = "text" name = "publisher" value="${itemToEdit.publisher}"><br>
<!--Platform: <input type ="text" name = "platform" value="${itemToEdit.platform}"><br>-->
Year: <input type = "text" name = "year" value="${itemToEdit.year}"><br>
<input type = "hidden" name = "id" value="${itemToEdit.id}">
<input type = "submit" value="Save Edited Item">
</form>
</body>
</html>