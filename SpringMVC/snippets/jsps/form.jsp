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
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Document</title>
</head>
<body>
    <form:form action="" method="POST" modelAttribute="">
        <div class="mb-3">
            <form:label class="form-label" path="first">:</form:label>
            <form:input class="form-control" path="first"/>
            <form:errors class="text-danger form-text" path="first"/>
        </div>
        <div class="mb-3">
            <form:label class="form-label" path="second">:</form:label>
            <form:input class="form-control" path="second"/>
            <form:errors class="text-danger form-text" path="second"/>
        </div>
        <div class="mb-3">
            <form:label class="form-label" path="third">:</form:label>
            <form:input class="form-control" path="third"/>
            <form:errors class="text-danger form-text" path="third"/>
        </div>
        <div class="d-flex justify-content-end">
            <input type="submit" value="" class="btn btn-primary">
        </div>
    </form:form>
</body>
</html>