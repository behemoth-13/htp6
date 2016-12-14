<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../fragments/localization.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${registration_title}</title>
</head>
<body>
<script type="text/javascript" src="js/validation.js"></script>
<div style="margin-left: 40px;">
<%@include file="../fragments/localeButton.jspf" %>
<h2>${Registration}</h2>
<br>
<form action="Controller" method="post">

    Имя <input type="text" maxlength="15" name="un" id="nameForm" onKeyUp="check('name')">
    <p id="name" style="color: red">Только латинские или только русские буквы вплоть до 15-и символов</p>
    <br>
    
    Фамилия <input type="text" maxlength="15" name="us" id="surnameForm" onKeyUp="check('surname')">
    <p id="surname" style="color:red">Только латинские или только русские буквы вплоть до 15-и символов</p>
    <br>
    
	Логин <input type="text" maxlength="15" name="ul" id="loginForm" onKeyUp="check('login')">
	<p id="login" style="color:red">Латинские буквы или цифры, от 3-х до 15-и символов</p>
	<br>
	
	e-mail <input type="text" name="ue" id="emailForm" onKeyUp="chek('email')">
	<p id="email" style="color:red">Пример: vasia.pupkin@gmail.com</p>
	<br>
	
	Телефон <input type="text" name="up" id="phoneForm" onKeyUp="check('phone')">
	<p id="phone" style="color:green">Пример: +375 29 1234567, 123-45-67, +375 44 123-45-67</p><br>
	
	Пароль <input type="password" maxlength="15" name="ua" id="passwordForm" onKeyUp="check('password')" >
	<p id="password" style="color:red">Латинские буквы, цифры, *, ! или ^, от 6-и до 15-и символов</p>
	<br>
	
	<button name="cm" value="ur" type="submit">${register_button}</button>
</form>
</div>
</body>
</html>