
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="header.jsp" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>EShopper - Bootstrap Shop Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
  
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Categories</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>


            </div>
            <div class="col-lg-9">

            </div>
        </div>
    </div>
    <!-- Navbar End -->


    <!-- Page Header Start -->

<!-- Page Header End -->


    <!-- Contact Start -->
    <div class="container-fluid pt-5">
        <div class="text-center mb-4">
            <h2 class="section-title px-5"><span class="px-2">Signup</span></h2>
        </div>





                <div class="contact-form">
                    <div id="success" ></div>
                      <%
                    if(request.getAttribute("msg")!= null)
                    {
                    	out.println(request.getAttribute("msg"));
                    }
                    %>
                  
                  <form name="sentMessage" id="contactForm" method="post"  action="UserController">
    <div class="control-group">
        <input type="text" class="form-control" id="name" name="name" placeholder="Your Name"
          required="required"   data-validation-required-message="Please enter your name" autocomplete="name" />
        <p class="help-block text-danger"></p>
    </div>
    <div class="control-group">
        <input type="email" class="form-control" id="email" name="email" placeholder="Your Email"
          required="required"   data-validation-required-message="Please enter your email" autocomplete="username" />
        <p class="help-block text-danger"></p>
    </div>
    <div class="control-group">
        <input type="tel" class="form-control" id="mobile" name="mobile" placeholder="Mobile"
         required="required"    data-validation-required-message="Please enter your mobile number" autocomplete="tel" />
        <p class="help-block text-danger"></p>
    </div>
    <div class="control-group">
        <input type="password" class="form-control" id="password" name="password" placeholder="Password"
        required="required"     data-validation-required-message="Please enter a password" autocomplete="new-password" />
        <p class="help-block text-danger"></p>
    </div>
    <div class="control-group">
        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm Password"
         required="required"    data-validation-required-message="Please confirm your password" autocomplete="new-password" />
        <p class="help-block text-danger"></p>
    </div>
    <div>
        <button class="btn btn-primary py-2 px-4" name="action" value="signup" type="submit">Signup</button>
    </div>
</form>

                </div>
            </div>
            
            
            
            
            
            
            
         
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
     
</body>

</html>