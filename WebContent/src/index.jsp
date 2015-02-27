<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
<!--
@import url(/X-rayIRSystem/src/style/style.css);
-->
</style>
<meta charset="utf-8">
<title>Онлайн обнаружение образований</title>
</head>

<body>

	<div class="header">
		<jsp:include page="/src/head.jsp" /></div>
	<fieldset>
		<legend>Работа с изображение</legend>

		<br>Выберите снимок для обработки
		<form method='post' action='/X-rayIRSystem/ImageProcessor' enctype='multipart/form-data'>
			<input type='file' name='fileToUpload' id='fileToUpload' /> <br>
			<input type='submit' value='Загрузить изображение' name='submit' />
		</form>
	</fieldset>
	<p>или выберите из <a href='/X-rayIRSystem/src/chooseimg.jsp'>уже существующих</a>.</p>
	

	<div class="footer">
		<jsp:include page="/src/foot.jsp" />
	</div>
</body>
</html>