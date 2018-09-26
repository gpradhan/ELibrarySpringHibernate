<%@ include file="/WEB-INF/views/htmlHeader.jsp" %>
<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>

<div class='container'>
<div><h2>${loginSuccessMessage} </h2></div>
	<h2>Book List</h2>
	<table class='table table-bordered table-striped'>
		<tr>
			<td><strong>Si No.</strong></td>
			<td><strong>Book Name</strong></td>
			<td><strong>Student Rollno</strong></td>
			<td><strong>Student Name</strong></td>
			<td><strong>Student Mobile</strong></td>
			<td><strong>Issue Date</strong></td>
			<td><strong>Issued</strong></td>
			<td><strong>Returned</strong></td>
		</tr>
		<%
			int siNo = 0;
		%>
		<c:if test="${!empty issueBookList}">
			<c:forEach items="${issueBookList}" var="issueBook">
				<tr>
					<td><%=++siNo%></td>
					<td>${issueBook.bookId.name}</td>
					<td>${issueBook.studentid}</td>
					<td>${issueBook.studentname}</td>
					<td>${issueBook.studentmobile}</td>
					<td>${issueBook.issueddate}</td>
					<td>${issueBook.issued}</td>
					<td>${issueBook.returned}</td>

				</tr>
			</c:forEach>
		</c:if>
	</table>

<%@ include file="/WEB-INF/views/htmlFooter.jsp" %>