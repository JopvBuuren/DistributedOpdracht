<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


	<c:url value="/css/stylesheet.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" type="text/css" />
	<title>Admin</title>
</head>
<body>
	<div class="container">
		<div class="side">
			<h1> Chat Server </h1>
			
			<ul>
				<li class="menuItem">
					<a href="login?logout=true">Logout</a>
				</li>
				<li class="menuItem">
					<a href="chat">Chat</a>
				</li>
				
			</ul>
		</div>
		<div class="content">
			<h2> Admin </h2>
			<form action="/login">
				  User:<br>
				  <input type="text" name="user" value="user"><br>
				  Password:<br>
				  <input type="password" name="password" value="pass"><br><br>
				  <input type="submit" value="Submit">
			</form>	
		</div>

