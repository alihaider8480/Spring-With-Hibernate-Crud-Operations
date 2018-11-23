<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<br><br><br>
    <table width="50%" border="2px">
<tr>
  <th>ID</th>
  <th>Name</th>
  <th>Phone</th>
  <th>Address</th>
  <th>Update / Delete</th>
  
</tr>
  <c:forEach items="${all_List}" var="slist">
  <tr>
    <td>${slist.id}</td>
    <td>${slist.name}</td>
    <td>${slist.phone}</td>
    <td>${slist.address}</td>
    <td>
        <a href="${pageContext.request.contextPath}/GetSingleRecordForUpdate/${slist.id}">Update</a>
                                /
        <a href="${pageContext.request.contextPath}/Delete/${slist.id}">Delete</a>
    </td>
  </tr>
  </c:forEach>
</table><br><br>

 <a href="${pageContext.request.contextPath}/">Home Page</a>
</div>
</body>
</html>