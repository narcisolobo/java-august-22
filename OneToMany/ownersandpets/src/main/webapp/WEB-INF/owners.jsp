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
                    <h5 class="card-header">All Owners</h5>
                    <div class="card-body">
                        <table class="table table-striped">
                            <thead>
                                <th>Owner Name:</th>
                            </thead>
                            <tbody>
                                <c:forEach var="owner" items="${allOwners}">
                                <tr>
                                    <td><a href="/owners/${owner.id}">${owner.firstName} ${owner.lastName}</a></td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div class="col-lg-6 col-md-12 col-sm-12">
                <div class="card">
                    <h5 class="card-header">Create Owner</h5>
                    <div class="card-body">
                        <form:form action="/owners/insert" method="POST" modelAttribute="owner">
                            <div class="mb-3">
                                <form:label class="form-label" path="firstName">First Name:</form:label>
                                <form:input class="form-control" path="firstName" />
                                <form:errors class="form-text text-danger" path="firstName" />
                            </div>
                            <div class="mb-3">
                                <form:label class="form-label" path="lastName">Last Name:</form:label>
                                <form:input class="form-control" path="lastName" />
                                <form:errors class="form-text text-danger" path="lastName" />
                            </div>
                            <div class="d-flex justify-content-end">
                                <input type="submit" value="ADD OWNER" class="btn btn-primary">
                            </div>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>