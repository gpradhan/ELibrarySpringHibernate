<%@ include file="/WEB-INF/views/htmlHeader.jsp" %>
<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>

<div class='container'>
<div><h2>${loginSuccessMessage} </h2></div>
	<h2>${myMessage}</h2>
	<h2>${errorMessage}</h2>
	<form:form action="returnBook" method="post" modelAttribute="issueBook">
		<table class='table table-bordered table-striped'>
			<tr>
				<td>Name</td>
				<td><form:select path="bookNo" >
				<form:option value="0" label="Select"/>
				<form:options items="${bookList}" itemValue="id"/>
				</form:select> <br /> <form:errors
						path="bookNo" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Student Rollno</td>
				<td><form:input path="studentid" /> <br /> <form:errors
						path="studentid" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form:form>
<%@ include file="/WEB-INF/views/htmlFooter.jsp" %>