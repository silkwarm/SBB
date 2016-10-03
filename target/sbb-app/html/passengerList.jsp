<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <title>Passenger list</title>
</head>
<body>
<table>
  <tr> <td>Name</td><td>SurName</td><td>Birthdate</td></tr>
  <c:forEach var="passenger" items="${passengerList}">
    <tr>
      <td>${passenger.name}</td>
      <td>${passenger.surname}</td>
      <td>${passenger.birthdate}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
