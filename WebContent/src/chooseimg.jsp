<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Выберите существующее изображение</title>

<style type="text/css">
<!--
@import url(/X-rayIRSystem/src/style/style.css);
-->
</style>
</head>
<body>
	<div class="header">
		<jsp:include page="/src/head.jsp" /></div>
	<fieldset>
		<legend>Работа с изображение</legend>
		<jsp:include page='/GetAllImages' />
	</fieldset>


	<div class="footer">
		<jsp:include page="/src/foot.jsp" />
	</div>
</html>