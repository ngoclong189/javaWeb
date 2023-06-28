<%-- 
    Document   : Login
    Created on : Feb 4, 2021, 4:22:57 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styleLogin.css" rel="stylesheet" type="text/css"/>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.gstatic.com">
        <link href="https://fonts.googleapis.com/css2?family=Yusei+Magic&display=swap" rel="stylesheet">
        <title>Login</title>
    </head>
    <body>


        <section class="login-block">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 login-sec">
                        <h2 class="text-center">Login Now</h2>
                        <div class="ds-form">
                            <form class="box" action="login" method="post">
                                <p style="color: red">${mess}</p>
                                <input type="text" value="${user}" name="user" placeholder="UserName">
                                <input type="password" value="${pass}" name="pass" placeholder="Password">
                                <div class="form-group form-check">
                                    <input name="remember" value="1" type="checkbox" class="form-check-input" id="exampleCheck1">
                                    <label class="form-check-label" for="exampleCheck1">Remember me</label>
                                </div>
                                <input type="submit" value="Login">
                            </form>
                        </div>

                        <div class="ds-signup">
                            <a href="signup.jsp">
                                <button id="btn-signup">Sign Up</button>
                            </a>
                        </div>

                    </div>

                    <div class="col-md-8 banner-sec">
                        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">

                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active">
                                    <img class="d-block img-fluid" src="https://www.petcity.vn/media/news/0708_elle-viet-nam-cuoc-thi-nhiep-anh-danh-cho-cho-3-768x513.jpg" alt="dog">
                                    <div class="carousel-caption d-none d-md-block">
                                        <div class="banner-text">
                                            <h2>Shop Bán Chó</h2>
                                            <p>Chó nào có thể ăn được đều có ở đây <i class="fas fa-dog"></i></p>
                                        </div>	
                                    </div>
                                </div>
                            </div>	   

                        </div>
                    </div>
                </div>
        </section>


    </body>
</html>
