<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


	<c:url value="/css/stylesheet.css" var="jstlCss" />
	<link href="${jstlCss}" rel="stylesheet" type="text/css" />
	<title>Welcome</title>
</head>
<body>
	<div class="container">
		<div class="side">
			<h1> Chat Server </h1>
			<ul>
				<li> 
					<a class="menuItem" href="login">Login</a> 
				</li>
				<li> 
					<a class="menuItem" href="register">Register</a> 
				</li>
			</ul>
		</div>
		<div class="content">
			<h2> A wild error appeared! </h2>
			<p>
				A error was detected
					TODO here, make error message :)
			</div>p>
		</div>