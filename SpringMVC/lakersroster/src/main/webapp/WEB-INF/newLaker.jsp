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
    <title>Lakers Roster</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand mb-0 h1" href="/lakers">LAKERS ROSTER</a>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="card">
                    <h5 class="card-header">Add a New Laker</h5>
                    <div class="card-body">
                        <form:form action="/lakers/insert" method="POST" modelAttribute="laker">
                            <div class="mb-3">
                                <form:label class="form-label" path="firstName">First Name:</form:label>
                                <form:input class="form-control" path="firstName"/>
                                <form:errors class="text-danger form-text" path="firstName"/>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="lastName">Last Name:</form:label>
                                <form:input class="form-control" path="lastName"/>
                                <form:errors class="text-danger form-text" path="lastName"/>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="position">Position:</form:label>
                                <form:input class="form-control" path="position"/>
                                <form:errors class="text-danger form-text" path="position"/>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="age">Age:</form:label>
                                <form:input class="form-control" type="number" path="age"/>
                                <form:errors class="text-danger form-text" path="age"/>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="height">Height:</form:label>
                                <form:input class="form-control" path="height"/>
                                <form:errors class="text-danger form-text" path="height"/>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="weight">Weight:</form:label>
                                <form:input class="form-control" type="number" path="weight"/>
                                <form:errors class="text-danger form-text" path="weight"/>
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="college">College:</form:label>
                                <form:input class="form-control" path="college"/>
                                <form:errors class="text-danger form-text" path="college"/>
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="ADD Laker" class="btn btn-primary">
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>