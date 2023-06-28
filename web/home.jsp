<%-- 
    Document   : home
    Created on : Feb 3, 2021, 6:07:48 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">        <link href="style.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=PT+Serif:ital,wght@1,700&display=swap" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Home</title>
    </head>
    <body>
         

        <div class="wrapper">
            <div class="multi_color_border"></div>
            <div class="top_nav">
                <div class="left">
                    <i class="fas fa-place-of-worship" style="font-size: 30px"></i>
                    <div class="logo"><p><span>Shop </span>Bán Chó </p>
                    </div>


                    <div class="search_bar">
                        <form action="search" method="post">

                            <input name="txt" type="text" placeholder="Search" value="${txtS}">
                            <button type="submit" class="btn btn-secondary btn-number">
                                <i class="bi bi-search"></i>
                            </button> 
                        </form>
                    </div>
                    <a class="btn btn-success btn-sm ml-3" href="ShowCartControl">
                        <i class="fa fa-shopping-cart"></i> Cart
                        <span class="badge badge-light">3</span>
                    </a>

                </div> 
                <div class="right">
                    <ul>
                        <c:if test="${sessionScope.acc != null}">
                            <li><a href="logout"><i class="fas fa-sign-in-alt"></i> LogOut</a></li>
                            </c:if>
                            <c:if test="${sessionScope.acc == null}">
                            <li><a href="Login.jsp"><i class="fas fa-sign-in-alt"></i> LogIn</a></li>
                            <li><a href="signup.jsp"><i class="fas fa-user-plus"></i> SignUp</a></li>
                            </c:if>

                        <li><!-- Button trigger modal -->
                            <a href="loadInfor" type="button">
                                <i class="fas fa-id-badge"></i> Hello ${sessionScope.acc.username}</a>
                        </li>
                    </ul>
                </div>
            </div>


            <div class="menu-bar">
                <ul>
                    <li class="active"><a href="home"><i class="fas fa-home" style="font-size: 20px"></i> Home</a></li>
                    <li><a href="#"></a><i class="fas fa-dog" style="font-size: 20px"></i>giống chó</a>
                        <div class="sub-menu-1">
                            <ul>
                                <c:forEach items="${listC}" var="o">
                                    <div class="menu-bar">
                                        <ul>
                                            <li><a href="category?cid=${o.cid}">${o.cname}</a></li>
                                        </ul>
                                    </div>
                                </c:forEach>
                            </ul>
                        </div>
                    </li>

                    <li><a href="#"><i class="fas fa-sort-amount-down-alt" style="font-size: 20px"></i> sắp xếp theo giá</a>
                        <div class="sub-menu-1">
                            <ul>
                                <div class="menu-bar">
                                    <ul>
                                        <li><a href="sortAsc">tăng dần</a></li>
                                        <li><a href="sortdesc">giảm dần</a></li>
                                    </ul>
                                </div>
                            </ul>
                        </div>
                    </li>
                        <c:if test="${sessionScope.acc.seller == 1}">
                        <li><a href="manager">Manager product</a></li>
                        </c:if>
                        <c:if test="${sessionScope.acc.admin == 1}">
                        <li><a href="showManagerAccount">Manager Account</a></li>
                        </c:if>

                </ul>
            </div>



            <!--Main layout-->
            <main class="mt-5 pt-4">
                <div id="content-dog" class="container dark-grey-text mt-5">

                    <!--Grid row-->
                    <c:forEach items="${listD}" var="o">   <!-- day du lieu cua dog  -->
                        <div class="product row wow fadeIn"> <!-- tu day -->

                            <!--Grid column-->
                            <div class="col-md-6 mb-4">

                                <img src="${o.image}" class="img-fluid" alt="">

                            </div>
                            <!--Grid column-->

                            <!--Grid column-->
                            <div class="col-md-6 mb-4">

                                <!--Content-->
                                <div class="p-4">

                                    <div class="mb-3">
                                        <a href="#"  data-toggle="modal" data-target="#descrip">
                                            <span class="badge purple mr-1">Description</span>
                                        </a>
                                        <a href="#" data-toggle="modal" data-target="#alimen">
                                            <span class="badge blue mr-1">Alimentation</span>
                                        </a>

                                    </div>

                                    <p class="lead">
                                        <span>${o.title}</span>
                                        <br>
                                        <span style="font-family: 'RocknRoll One', sans-serif; font-weight: bold; font-size: 30px">${o.name}</span>
                                        <br>
                                        <span style="background: greenyellow">${o.price}$</span>
                                    </p>

                                    <p class="lead font-weight-bold">Description</p>

                                    <p class="p1" class="modal fade" id="descrip" >${o.description}</p>
                                    <p class ="p1" class="modal fade" id="alimen">${o.alimentation}</p>

                                    <form action="CartControl?id=${o.id}" class="d-flex justify-content-left" method="post">
                                        <!-- Default input -->
                                        <input type="number" name="amount" value="1" aria-label="Search" class="form-control" style="width: 100px;">
                                        <a><button class="btn btn-primary btn-md my-0 p" type="submit">Add to cart
                                                <i class="fas fa-shopping-cart ml-1"></i>
                                            </button></a>

                                    </form>

                                </div>
                                <!--Content-->


                            </div>
                            <!--Grid column-->

                        </div>
                        <!--Grid row-->

                        <hr>
                        <!-- den day -->
                    </c:forEach>



                </div>
                <div class="row d-flex justify-content-center wow fadeIn" >
                    <button onclick="loadMore()" class="btn btn-primary">Load More</button>
                </div>

                <!--Grid row-->
                <div class="row d-flex justify-content-center wow fadeIn">

                    <!--Grid column-->
                    <div class="col-md-6 text-center">
                        <div class="bottom-logo" style="width: auto">
                        </div>
                        <h4 class="my-4 h4" style="font-family: 'PT Serif', serif; font-size:40px">Shop Bán Chó</h4>

                        <p></p>

                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

                <!--Grid row-->
                <div class="row wow fadeIn">

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-12 mb-4">

                        <img src="Removal-9.png" class="img-fluid" alt="">

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-6 mb-4">

                        <img src="Removal-519.png" class="img-fluid" alt="">

                    </div>
                    <!--Grid column-->

                    <!--Grid column-->
                    <div class="col-lg-4 col-md-6 mb-4">

                        <img src="Removal-39.png" class="img-fluid" alt="">

                    </div>
                    <!--Grid column-->

                </div>
                <!--Grid row-->

        </div>
    </main>
    <!--Main layout-->

    <!--Footer-->
    <footer class="page-footer text-center font-small mt-4 wow fadeIn">


        <hr class="my-4">

        <!-- Social icons -->
        <div class="pb-4">
            <a href="#" target="_blank">
                <i class="fab fa-facebook-f mr-3"></i>
            </a>

            <a href="#" target="_blank">
                <i class="fab fa-twitter mr-3"></i>
            </a>

            <a href="#" target="_blank">
                <i class="fab fa-youtube mr-3"></i>
            </a>

            <a href="#" target="_blank">
                <i class="fab fa-google-plus-g mr-3"></i>
            </a>

            <a href="#" target="_blank">
                <i class="fab fa-dribbble mr-3"></i>
            </a>

            <a href="#" target="_blank">
                <i class="fab fa-pinterest mr-3"></i>
            </a>

            <a href="#" target="_blank">
                <i class="fab fa-github mr-3"></i>
            </a>

            <a href="#" target="_blank">
                <i class="fab fa-codepen mr-3"></i>
            </a>
        </div>
        <!-- Social icons -->

        <!--Copyright-->
        <!--                <div class="footer-copyright py-3">
                            © 2018 Copyright:
                            <a href="https://mdbootstrap.com/education/bootstrap/" target="_blank"> MDBootstrap.com </a>
                        </div>-->
        <div class="contact">
            <h5>Contact</h5>
            <hr class="bg-white mb-2 mt-0 d-inline-block mx-auto w-25">
            <ul class="list-unstyled">
                <li><i class="fa fa-home mr-2"></i>Shop Bán Chó</li>
                <li><i class="fa fa-envelope mr-2"></i> ngoclong.thaihoa@gmail.com</li>
                <li><i class="fa fa-phone mr-2"></i> 0888722026</li>
                <li><i class="fa fa-print mr-2"></i> 123456789 </li>
            </ul>
        </div>
        <!--/.Copyright-->

    </footer>
    <!--/.Footer-->
</div>


<script src="manager.js" type="text/javascript"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
                        function description1() {
                            document.getElementsByClassName("p1")[0].style.display = "block";
                            document.getElementsByClassName("p1")[1].style.display = "none";
                        }
                        function alimetation1() {
                            document.getElementsByClassName("p1")[1].style.display = "block";
                            document.getElementsByClassName("p1")[0].style.display = "none";
                        }

                        function loadMore() {
                            var index = document.getElementsByClassName("product").length;
                            $.ajax({
                                url: "/projectprj321/loadmore",
                                type: "get", //send it through get method
                                data: {
                                    exits: index
                                },
                                success: function (data) {
                                    var row = document.getElementById("content-dog");
                                    row.innerHTML += data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }

</script>
</body>
</html>

