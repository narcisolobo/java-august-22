<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <title>Superheroes</title>
</head>
<body>
    <div class="container pt-3">
        <div class="row justify-content-center">
            <div class="col-6">
                <div class="card">
                    <h5 class="card-header">Superheroes</h5>
                    <div class="card-body">
                        <table class="table table-striped table-hover">
                            <thead>
                                <tr>
                                    <th>Name:</th>
                                    <th>Alias:</th>
                                    <th>Added:</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="hero" items="${heroes}">
                                <tr>
                                    <td>${hero.name}</td>
                                    <td>${hero.alias}</td>
                                    <td>${hero.createdAt}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>