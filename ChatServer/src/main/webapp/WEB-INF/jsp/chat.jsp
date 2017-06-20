<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chat</title>
</head>
<body>
	<div class="header">
		<h1> Chat </h1>
	</div>
	<div class="container">
		<div class="side">
			<ul>
				<c:forEach items="${list}" var="user">
				    <li>
				    	<c:out value="${user}" />
				    </li>
	  			</c:forEach>
			</ul>
		</div>
		<div class="content">
			<p> 
				Welcome to the chat server, this java server is made for distributes systems 
			</p>	
		</div>
	</div>
	<div class="footer"> @ HU 2017 </div>
	
</body>
</html>

