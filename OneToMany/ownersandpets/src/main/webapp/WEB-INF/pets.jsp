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
    <title>Owners and Pets</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-3">
        <div class="container">
            <a class="navbar-brand mb-0 h1" href="/owners">Owners</a>
            <a class="navbar-brand mb-0 h1 ms-auto" href="/pets">Pets</a>
        </div>
    </nav>
    <div class="container">
        <div class="row">
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="card">
                    <h5 class="card-header">All Pets</h5>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <th>Pet Name:</th>
                                <th>Pet Type:</th>
                            </thead>
                            <tbody>
                                <c:forEach var="pet" items="${allPets}">
                                <tr>
                                    <td>${pet.petName}</td>
                                    <td>${pet.petType}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="card">
                    <h5 class="card-header">Create Pet</h5>
                    <div class="card-body">
                        <form:form action="/pets/insert" method="POST" modelAttribute="pet">
                            <div class="mb-3">
                                <form:label class="form-label" path="petName">Pet Name:</form:label>
                                <form:input class="form-control" path="petName" />
                                <form:errors class="form-text text-danger" path="petName" />
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="petType">Pet Type:</form:label>
                                <form:input class="form-control" path="petType" />
                                <form:errors class="form-text text-danger" path="petType" />
                            </div>
                            <div class="mb-3">
                                <form:select class="form-select" path="owner">
                                    <c:forEach var="owner" items="${allOwners}">
                                        <form:option value="${owner.id}">${owner.firstName} ${owner.lastName}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="ADD PET" class="btn btn-primary">
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>