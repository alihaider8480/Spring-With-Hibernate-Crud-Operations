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
<div align="center"><a href="${pageContext.request.contextPath}/GetAllStudentRecord">Show All Records</a>
 <form:form action="cInsert" method="Post" modelAttribute="insert_attribute">
<h1>Insert Record</h1>
   ${cheack1}<br>
 <table>
  <tr>
    <td>ID<br>
        <input type="text" name="id">
    </td>
  </tr>
  <tr>
    <td>Name<br>
        <input type="text" name="name">
    </td>
  </tr> 
  <tr>
     <td>Phone<br>
        <input type="text" name="phone">
    </td>
  </tr>
  <tr>
     <td>Address<br>
        <input type="text" name="address">
    </td>
  </tr>
   <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>

<form:form action="${pageContext.request.contextPath}/GetSingleStudentRecord" method="Post" modelAttribute="getsingle_attribute">
<h1>Search Record</h1>   
   <br>
 <table>
  <tr>
    <td>ID<br>
        <input type="text" name="id">
    </td>
   <tr>
     <td>Submit<br>
        <input type="submit">
    </td>
  </tr>
</table>
</form:form>
   ${single_List.getId()}
   ${single_List.getName()}
   ${single_List.getPhone()}
   ${single_List.getAddress()}
</div>
</body>
</html>