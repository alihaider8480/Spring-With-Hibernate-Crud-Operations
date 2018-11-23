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
<div align="center"><br><br>
<form:form action="${pageContext.request.contextPath}/Update" method="Post" modelAttribute="update_attribute" >
<h1>Update Record</h1><br>
${cheack1 }
 <table>
  <tr>
    <td>ID<br>
        <input type="text" name="id" value="${update_list.getId()}">
    </td>
  </tr>
  <tr>
    <td>Name<br>
        <input type="text" name="name" value="${update_list.getName()}">
    </td>
  </tr> 
  <tr>
     <td>Phone<br>
        <input type="text" name="phone" value="${update_list.getPhone()}">
    </td>
  </tr>
  <tr>
     <td>Address<br>
        <input type="text" name="address" value="${update_list.getAddress()}">
    </td>
  </tr>
   <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form><br><br>
 <a href="${pageContext.request.contextPath}/">Home Page</a>
         /
 <a href="${pageContext.request.contextPath}/GetAllStudentRecord">Show All Records</a>
</div>
</body>
</html>