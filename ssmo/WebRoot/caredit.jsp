<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<title>SSMO Demo</title>
</head>

<body>
	<h1>SpringMVC - Spring - Mybatis - Oracle</h1>
	<form action="carController_save" method="post" name="f">
	  <input type="hidden" name="id" value="${car.id }">
	  
	  <input type="text" name="name" 
	    placeholder="Name" value="${car.name }"><br>
	    	  
	  <c:if test="${empty car }">
	    <input type="date" name="saleDate" 
        placeholder="销售日期"> 
	  </c:if>
	  
	  <c:if test="${!empty car }">
	    <input type="date" name="saleDate" 
        placeholder="销售日期" 
        value='<spring:eval expression="car.saleDate" />'>
    </c:if><br>
    
    <input type="number" name="price" step="0.01"
      placeholder="Price" value="${car.price }"><br>
      
    <input type="submit" value="Save">
	</form>
</body>
</html>
