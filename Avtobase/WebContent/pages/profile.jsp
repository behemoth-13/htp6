<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@include file="../fragments/localization.jspf" %> <!-- localization -->
<%@include file="../fragments/common.jspf"  %>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${sessionScope.LOGIN} (${sessionScope.SURNAME} ${sessionScope.NAME})</title>
</head>
<body>
	<%@include file="../fragments/header.jspf"  %>
	<%@include file="../fragments/profile.jspf"  %>
	<%@include file="../fragments/footer.jspf" %>
</body>
</html>