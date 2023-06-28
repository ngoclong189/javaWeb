<%-- 
    Document   : signup
    Created on : Feb 4, 2021, 6:29:44 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link href="css/styleSignUp.css" rel="stylesheet" type="text/css"/>
        <!------ Include the above in your HEAD tag ---------->
        <title>Sign Up</title>
    </head>
    <body>
        <div class="container register">
            <div class="row">
                <div class="col-md-3 register-left">
                    <img src="https://i.pinimg.com/originals/6f/1e/8b/6f1e8b15a860d0083116f8bd9e2778d6.png" alt=""/>
                    <h3>Welcome</h3>
                    <p>Shop Bán Chó uy tín hàng đầu Việt Nam</p>
                    <a href="Login.jsp">
                        <button id="btn-login">Login</button>
                    </a><br/>
                </div>
                <div class="col-md-9 register-right">

                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <h1 class="register-heading">Create Account</h1>
                            <form action="signup" method="post">
                                <div class="row register-form" >
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="user" placeholder="User Name *" value="" />
                                        </div>

                                        <div class="form-group">
                                            <input type="password" class="form-control" name="pass" placeholder="Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="password" class="form-control" name="repass" placeholder="Confirm Password *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <div class="maxl">
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="1" checked>
                                                    <span> Male </span> 
                                                </label>
                                                <label class="radio inline"> 
                                                    <input type="radio" name="gender" value="0">
                                                    <span>Female </span> 
                                                </label>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="fullname" placeholder="Full Name *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="email" class="form-control" name="email" placeholder="Your Email *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" class="form-control" name="address" placeholder="Your Address *" value="" />
                                        </div>
                                        <div class="form-group">
                                            <input type="text" minlength="10" maxlength="10"  name="phone" class="form-control" placeholder="Your Phone *" value="" />
                                        </div>
                                        
                                        <p style="color: red;font-weight:bold">${mess1}</p>
                                        <p style="color: red; font-weight:bold">${mess2}</p>

                                        <input type="submit" class="btnRegister"  value="Sign Up"/>
                                    </div>
                                </div>
                            </form>
                                        
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
