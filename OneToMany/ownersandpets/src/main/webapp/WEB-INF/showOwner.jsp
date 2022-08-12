<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <title>Document</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand mb-0 h1" href="/owners">Owners</a>
            <a class="navbar-brand mb-0 h1 ms-auto" href="/pets">Pets</a>
        </div>
    </nav>
    <div class="container">
    	<div class="card">
            <h5 class="card-header">OWNER DETAILS</h5>
            <div class="card-body">
                <h3>${owner.firstName} ${owner.lastName}'s Pets</h3>
                <ul class="list-group">
                    <c:forEach var="pet" items="${owner.pets}">
                    <li class="list-group-item">${pet.petName} - ${pet.petType}</li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</body>
</html>