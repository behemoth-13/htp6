<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %> <!-- localization -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome to our site</title>
</head>
<body>
<div style="margin-left: 40px;">
<br>
	<%@include file="../fragments/login.jspf" %>
<br>
<button name="makeorder">сделать онлайн заказ</button><br>
<br>
<button name="autopark">наш автопарк</button><br>
<br>
<button name="price">наши цены</button><br>
<br>
<button name="about">о компании</button><br>
<br>

</div>
</body>
</html>