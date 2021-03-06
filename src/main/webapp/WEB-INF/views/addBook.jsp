<%@ include file="/WEB-INF/views/htmlHeader.jsp" %>
<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>

<div class='container'>
	<%-- <spring:url value='/viewAllBooks1' var="/viewAllBooks1" />
        <a href="${viewAllBooks1}">View All Books</a> --%>
        <form:errors/>
        <div><h2>${loginSuccessMessage} </h2></div>
	<h2>${myMessage}</h2>
	<h1>Input Form</h1>
	<form:form action="saveBook" method="post" modelAttribute="book">
		<table class='table table-bordered table-striped'>
			<tr>
				<td>Name</td>
				<td><form:input path="name" /> <br /> <form:errors
						path="name" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Author</td>
				<td><form:input path="author" /> <br /> <form:errors
						path="author" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Publisher</td>
				<td><form:input path="publisher" /> <br /> <form:errors
						path="publisher" cssClass="error" /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><form:input path="quantity" /> <br /> <form:errors
						path="quantity" cssClass="error" /></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">Submit</button></td>
			</tr>
		</table>
	</form:form>

<%@ include file="/WEB-INF/views/htmlFooter.jsp" %>