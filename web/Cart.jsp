<%-- 
    Document   : Cart
    Created on : Mar 5, 2021, 4:32:37 PM
    Author     : Admin
--%>

<%@page import="dao.Total"%>
<%@page import="java.util.List"%>
<%@page import="dao.DAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <link href="css/styleCart.css" rel="stylesheet" type="text/css"/>
        <!------ Include the above in your HEAD tag ---------->
        <title>Cart</title>
        <style>
            body .container{
                width: 1800px;

            }

        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-xs-8">
                    <div class="panel panel-info">
                        <div class="panel-heading">
                            <div class="panel-title">
                                <div class="row">
                                    <div class="col-xs-6">
                                        <h5><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</h5>
                                    </div>
                                    <div class="col-xs-6">
                                        <a href="home">  <button type="button" class="btn btn-primary btn-sm btn-block">
                                                <span class="glyphicon glyphicon-share-alt"></span> Continue shopping
                                            </button></a>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <c:forEach items="${ListCartDog}" var="o">
                            <div class="panel-body">
                                <div class="row">
                                    <div class="col-xs-2"><img class="img-responsive" src="${o.image}">
                                    </div>
                                    <div class="col-xs-4">
                                        <h4 class="product-name"><strong>${o.name}</strong></h4>
                                    </div>
                                    <div class="col-xs-6">
                                        <div class="col-xs-6 text-right">
                                            <h6><strong>${o.price} <span class="text-muted">x</span></strong></h6>
                                        </div>
                                        <div class="col-xs-4">
                                            <input type="text" class="form-control input-sm" value="${o.amount}">
                                        </div>
                                        <div class="col-xs-2">
                                            <a href="deleteCart?did=${o.cartId}"><button type="button" class="btn btn-link btn-xs">
                                                    <span class="glyphicon glyphicon-trash"> </span>
                                                </button></a>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </c:forEach>


                        </div>

                        <div class="panel-footer">
                            <div class="row text-center">
                                <div class="col-xs-9">
                                    <h4 class="text-right"><strong><%DAO dao = new DAO();
                                        List<Total> list = dao.totalCart();
                                        out.println("<p>" + list.get(0) + "</p>");%></strong></h4>
                                </div>
                                <div class="col-xs-3">
                                    <button type="button" class="btn btn-success btn-block">
                                        Checkout
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
