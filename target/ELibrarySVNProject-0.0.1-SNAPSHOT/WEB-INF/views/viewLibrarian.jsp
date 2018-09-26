<%@ include file="/WEB-INF/views/htmlHeader.jsp"%>
<%@ include file="/WEB-INF/views/navadmin.jsp" %>
<div>
	<h2>${loginSuccessMessage}</h2>
</div>
<h2>Book List</h2>
<table class='table table-bordered table-striped'>
	<tr>
		<th>Si No.</th>
		<th>Id</th>
		<th>Name</th>
		<th>Email</th>
		<th>Password</th>
		<th>Mobile</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<%
		int siNo = 0;
	%>
	<c:if test="${!empty librarianList}">
		<c:forEach items="${librarianList}" var="librarian">
			<tr>
				<td><%=++siNo%></td>
				<td>${librarian.id}</td>
				<td>${librarian.userName}</td>
				<td>${librarian.email}</td>
				<td>${librarian.password}</td>
				<td>${librarian.mobile}</td>
				<td><form:form action="editLibrarianForm" method="post" modelAttribute="myUser">
				<form:hidden path="id" value="${librarian.id}"/>
						<button type="submit">Update</button>
						<%-- <c:url value="/book/delete/${book1.id}" var="deleteBook" />
				<a href="<c:out value='${deleteBook}'/>">delete</a> --%>
					</form:form></td>
				<td><form:form action="deleteLibrarianForm" method="post" modelAttribute="myUser">
				<form:hidden path="id" value="${librarian.id}"/>
						<button type="submit">Delete</button>
						<%-- <c:url value="/book/delete/${book1.id}" var="deleteBook" />
				<a href="<c:out value='${deleteBook}'/>">delete</a> --%>
					</form:form></td>

			</tr>
		</c:forEach>
	</c:if>
</table>

<%@ include file="/WEB-INF/views/htmlFooter.jsp"%>