<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Welcome to our site</title>
</head>
<body>
<div style="margin-left: 40px;">Вход<br>
<br>
<br>
<form action="Controller" method="post">
	<input type="hidden" name="com" value="log_in" />
	Логин <input maxlength="10" name="login"><br>
	<br>
	Пароль <input maxlength="10" name="password" type="password">
	<br>
	<br>
	<button name="enter" type="submit">войти</button>
</form>
<br>
<button name="registration">регистрация</button><br>
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