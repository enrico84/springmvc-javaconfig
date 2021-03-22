<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>
<html>
	<head>
		<title>Home</title>
		
		<!-- Caricare file statici come js, css e img nelle jsp -->
	    <spring:url value="//resources/tema1/css/spring.css" var="springCSS" />
	    <link href="${springCSS}" rel="stylesheet" />
	</head>
	<body>
		<h1>
			SpringMVC Java Configuration
		</h1>
		
		<h3> ${message1} ${message2}. </h3>
		<h4>  La data di oggi è ${serverTime}. </h4>
	</body>
</html>
