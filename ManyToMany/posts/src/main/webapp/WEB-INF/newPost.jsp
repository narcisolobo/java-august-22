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
    <title>POSTS</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <span class="navbar-brand mb-0 h1">Welcome, ${user.username}</span>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <form:form action="/posts/insert" method="POST" modelAttribute="post">
                    <input type="hidden" name="creator" value="${user.id}">
                    <div class="mb-3">
                        <form:label class="form-label" path="title">Title:</form:label>
                        <form:input class="form-control" path="title" />
                        <form:errors class="form-text text-danger" path="title" />
                    </div>
                    <div class="mb-3">
                        <form:label class="form-label" path="content">Content:</form:label>
                        <form:textarea class="form-control" path="content" />
                        <form:errors class="form-text text-danger" path="content" />
                    </div>
                    <div class="d-flex justify-content-end">
                        <input type="submit" value="SUBMIT" class="btn btn-primary">
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>