<%-- 
    Document   : EditManagerAccount
    Created on : Mar 17, 2021, 11:02:11 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
        <link href="css/styleEditManagerAccount.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container rounded bg-white mt-5">
            <div class="row">
                <div class="col-md-4 border-right">
                    <div class="d-flex flex-column align-items-center text-center p-3 py-5"><img class="rounded-circle mt-5" src="https://static2.yan.vn/YanNews/2167221/202102/facebook-cap-nhat-avatar-doi-voi-tai-khoan-khong-su-dung-anh-dai-dien-e4abd14d.jpg" width="90"><span class="font-weight-bold">${detailManagerAccount.name}</span><span class="text-black-50">${detailManagerAccount.email}</span><span>${detailManagerAccount.phone}</span><span>${detailManagerAccount.address}</span></div>
                </div>
                <div class="col-md-8">
                    <div class="p-3 py-5">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <div class="d-flex flex-row align-items-center back"><i class="fa fa-long-arrow-left mr-1 mb-1"></i>
                                <a href="showManagerAccount"><h6>Back to home</h6></a>
                            </div>
                            <h6 class="text-right">Edit Profile</h6>
                        </div>
                        <form action="EditInforManagerAccount" method="post">
                        <div class="row mt-2">
                            <div class="col-md-6">UserName<input name="username" type="text" class="form-control" placeholder="user" value="${detailManagerAccount.username}"></div>
                            <div class="col-md-6">Password<input type="text" class="form-control" placeholder="password" value="${detailManagerAccount.password}" name="pass"></div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6">Name<input type="text" class="form-control" placeholder="Email" value="${detailManagerAccount.name}" name="name"></div>
                            <div class="col-md-6">Address<input type="text" class="form-control" value="${detailManagerAccount.address}" name="address" placeholder="Country"></div>

                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6">Email<input type="text" class="form-control" placeholder="address" value="${detailManagerAccount.email}" name="email"></div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-md-6">Phone<input type="text" class="form-control" placeholder="Phone" value="${detailManagerAccount.phone}" name="phone"></div>
                        </div>
                        <div class="mt-5 text-right"><button class="btn btn-primary profile-button" type="button">Save Profile</button></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
