<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<a href="${pageContext.request.contextPath}/user">User</a> | 
<a href="${pageContext.request.contextPath}/admin">Admin</a> | 
<a href="javascript:document.getElementById('logout').submit()">Logout</a>

<h3>Welcome to Spring boot security appliation </h3>
<ul>
   <li>Java 8 tutorial</li>
   <li>Spring tutorial</li>
   <li>BigData tutorial</li>
</ul>

<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  
</form>