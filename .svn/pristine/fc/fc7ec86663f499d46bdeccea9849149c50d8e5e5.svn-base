<%@ include file="/WEB-INF/views/htmlHeader.jsp" %>
<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>

<div class='container'>
<div><h2>${loginSuccessMessage} </h2></div>
	<h2>Book List</h2>
	<table class='table table-bordered table-striped'>
		<tr>
			<td><strong>Si No.</strong></td>
			<td><strong>Name</strong></td>
			<td><strong>Author</strong></td>
			<td><strong>Publisher</strong></td>
			<td><strong>Quantity</strong></td>
			<td><strong>Issued</strong></td>
			<td><strong>Update Book</strong></td>
			<td><strong>Delete Book</strong></td>
		</tr>
		<%
			int siNo = 0;
		%>
		<c:if test="${!empty books}">
			<c:forEach items="${books}" var="book1">
				<tr>
					<td><%=++siNo%></td>
					<td>${book1.name}</td>
					<td>${book1.author}</td>
					<td>${book1.publisher}</td>
					<td>${book1.quantity}</td>
					<td>${book1.issued}</td>
					<td><form:form action="updateBookForm" method="post"
							modelAttribute="book">
							<form:hidden path="id" value="${book1.id}" />
							<form:hidden path="name" value="${book1.name}" />
							<form:hidden path="author" value="${book1.author}" />
							<form:hidden path="publisher" value="${book1.publisher}" />
							<form:hidden path="quantity" value="${book1.quantity}" />
							<form:hidden path="issued" value="${book1.issued}" />
							<button type="submit">Update</button>
							<%-- <c:url value="/book/delete/${book1.id}" var="deleteBook" />
				<a href="<c:out value='${deleteBook}'/>">delete</a> --%>
						</form:form></td>
					<td><form:form action="deleteBook" method="post"
							modelAttribute="book">
							<form:hidden path="id" value="${book1.id}" />
							<button type="submit">Delete</button>
							<%-- <c:url value="/book/delete/${book1.id}" var="deleteBook" />
				<a href="<c:out value='${deleteBook}'/>">delete</a> --%>
						</form:form></td>

				</tr>
			</c:forEach>
		</c:if>
	</table>


<%@ include file="/WEB-INF/views/htmlFooter.jsp" %>