<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/commonCssAndJS.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href='<c:url value="index"/>'>eLibrary</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="#" class="active">Home</a></li>
        <li><a href='<c:url value="adminloginform"/>'>Admin</a></li>
        <li><a href='<c:url value="librarianloginform"/>'>Librarian</a></li>
       </ul>

    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid">
<h1>eLibrary</h1>

<div class="row">
  <div class="col-md-6">
  <h3>Admin Login</h3>
  <form:form action="login" method="post" modelAttribute="admin" mstyle="width:300px">
  <div class="form-group">
    <label for="email">Email address</label>
    <form:input type="email" class="form-control" path="email" placeholder="Email"/>
  </div>
  <div class="form-group">
    <form:label for="password" path="password">Password</form:label>
    <form:password class="form-control" path="password" placeholder="Password" showPassword="false"/>
  </div>  
  <button type="submit" class="btn btn-primary">Login</button>
</form:form>
  
  </div>
  <%-- <div class="col-md-6">
  <h3>Librarian Login</h3>
  <form:form action="user/login" method="post" modelAttribute="myUser" style="width:300px">
  <div class="form-group">
    <label for="email">Email address</label>
    <form:input class="form-control" id="email1" path="email" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <form:password id="password1" class="form-control" path="password" placeholder="Password"/>
  </div>  
  <button type="submit" class="btn btn-primary">Login</button>
</form:form>
</div> --%>
  </div>
</div>

</body>
</html>