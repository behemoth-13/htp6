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
<div style="margin-left: 40px;">
<%@include file="../fragments/localeButton.jspf" %>
<h2>Регистрация</h2>
<br>
<form action="Controller" method="post">

    Имя <input type="text" maxlength="15" name="un">
    Только латинские или только русские буквы вплоть до 15-и символов<br>
    
    Фамилия <input type="text" maxlength="15" name="us">
    Только латинские или только русские буквы вплоть до 15-и символов<br>
    
	Логин <input type="text" maxlength="15" name="ul">
	Латинские буквы или цифры, от 3-х до 15-и символов<br>
	
	e-mail <input type="text" name="ue">
	Пример: vasia.pupkin@gmail.com.<br>
	
	Телефон <input type="text" name="up">
	Пример: +375 29 1234567, 123-45-67, +375 44 123-45-67<br>
	
	Пароль <input type="password" maxlength="15" name="ua">
	Латинские буквы, цифры, *, ! или ^, от 6-и до 15-и символов<br>
	
	<button name="cm" value="ur" type="submit">зарегистрироваться</button>
</form>
</div>
</body>
</html>