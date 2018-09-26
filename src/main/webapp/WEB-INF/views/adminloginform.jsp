<%@ include file="/WEB-INF/views/htmlHeader.jsp" %>
<%@ include file="/WEB-INF/views/navhome.html" %>
<div class='container'>
${error}
<h3>Admin Login</h3>
  <form:form action="login" modelAttribute="admin" method="post" style="width:300px">
  <div class="form-group">
    <label for="email1">Email address</label>
    <form:input type="email" class="form-control" path="email" id="email1" placeholder="Email"/>
  </div>
  <div class="form-group">
    <label for="password1">Password</label>
    <form:password class="form-control" path="password" id="password1" placeholder="Password" />
  </div>  
  <button type="submit" class="btn btn-primary">Login</button>
</form:form>
</div>
<%@ include file="/WEB-INF/views/htmlFooter.jsp" %>