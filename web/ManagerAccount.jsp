<%-- 
    Document   : ManagerAccount
    Created on : Mar 16, 2021, 8:49:40 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" rel="stylesheet" type="text/css"/>
<!------ Include the above in your HEAD tag ---------->
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <div class="row col-md-6 col-md-offset-2 custyle">
                <table class="table table-striped custab">
                    <thead>
                    <a href="#" class="btn btn-primary btn-xs pull-right"><b>+</b> Add new categories</a>
                    <tr>
                        <th>UserName</th>
                        <th>PassWord</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Phone</th>
                        <th class="text-center">Action</th>
                    </tr>
                    </thead>
                    <c:forEach items="${listAccount}" var="o">
                    <tr>
                        <td>${o.username}</td>
                        <td>${o.password}</td>
                        <td>${o.name}</td>
                        <td>${o.email}</td>
                        <td>${o.address}</td>
                        <td>${o.phone}</td>
                        <td class="text-center"><a class='btn btn-info btn-xs' href="LoadInforManagerAccount?id=${o.accID}"><i class="fas fa-edit"></i> Edit</a> </td>
                        <td class="text-center"><a href="#" class="btn btn-danger btn-xs" style="align-items: center;"><i class="fas fa-user-times"></i> Del</a></td>
                    </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </body>
</html>
