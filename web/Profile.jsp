<%-- 
    Document   : Profile
    Created on : Mar 7, 2021, 10:31:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <!------ Include the above in your HEAD tag ---------->
        <title>JSP Page</title>

        <style>
            body{
                align-items: center;
                position: absolute;

            }

            .well{
                margin-top: 50px;
                margin-left: 500px;
            }
        </style>
    </head>
    <body>

        <div class="well">
            <ul class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab">Profile</a></li>
                <li><a href="#profile" data-toggle="tab">Password</a></li>
            </ul>
            <div id="myTabContent" class="tab-content">
                <div class="tab-pane fade in active" id="home">
                    <form action="editAccount" method="post" id="tab">
                        <label>Name</label>
                        <input name="name" type="text" value="${acc.name}" class="input-xlarge">

                        <label>Email</label>
                        <input name="email" type="text" value="${acc.email}" class="input-xlarge">
                        <label>Gender</label>
                        <input name="gender" type="radio" value="1" ${acc.gender==1?"checked":""}>Male
                        <input name="gender" type="radio" value="0" ${acc.gender==0?"checked":""}>Female
                        <label>Address</label>
                        <input name="address" type="text" value="${acc.address}" class="input-xlarge">

                        <label>Phone</label>
                        <input name="phone" type="text" value="${acc.phone}" class="input-xlarge">

                        <div>
                            <button type="submit" class="btn btn-primary">Update</button>
                            <a href="home"><button type="button" class="btn btn-primary">Back to home</button></a>
                        </div>
                    </form>
                         
                </div>
                <div class="tab-pane" id="profile">
                    
                    <form action="changepassword" method="post" id="tab2">
                        <p style="color: red">${mess}</p>
                        <label>Old Password</label>
                        <input name="oldpass" type="password" class="input-xlarge">
                        <label>New Password</label>
                        <input name="newpass" type="password" class="input-xlarge">
                        <label>Confirm New Password</label>
                        <input name="confirmnewpass" type="password" class="input-xlarge">
                        <div>
                            <button type="submit" class="btn btn-primary">Update</button>
                            <a href="home"><button type="button" class="btn btn-primary">Back to home</button></a>
                        </div>
                    </form>
                </div>
            </div>
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
            <script src="https://cdn.rawgit.com/twbs/bootstrap/v4-dev/dist/js/bootstrap.js"></script>
    </body>
</html>
