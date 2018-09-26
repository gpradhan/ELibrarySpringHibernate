<%@ include file="/WEB-INF/views/htmlHeader.jsp" %>
<%@ include file="/WEB-INF/views/navlibrarian.jsp" %>

<div class='container'>
<div><h2>${loginSuccessMessage} </h2></div>
<div><h3>${successMessage}</h3></div>
<div><c:url value="/home" var="home" /><a href="<c:out value='${home}'/>">Home</a></div>
<div><c:url value="/books/viewAllBooks" var="viewAllBooks1" /><a href="<c:out value='${viewAllBooks1}'/>">View All Books</a></div>
<div><c:url value="/books/addBook" var="addBook" /><a href="<c:out value='${addBook}'/>">Add Book</a></div>
<div><c:url value="/books/issueBook" var="issueBook" /><a href="<c:out value='${issueBook}'/>">Issue Book</a></div>
<div><c:url value="/books/viewAllIssuedBooks" var="viewAllIssuedBooks" /><a href="<c:out value='${viewAllIssuedBooks}'/>">View All Issued Books</a></div>
<div><c:url value="/books/returnBook" var="returnBook" /><a href="<c:out value='${returnBook}'/>">Return Book</a></div>
<div><c:url value="logout" var="logout" /><a href="<c:out value='${logout}'/>">logout</a></div>

<%@ include file="/WEB-INF/views/htmlFooter.jsp" %>