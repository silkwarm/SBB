<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Passenger list</title>
</head>
<body>
  <table>
    <c:forEach var="passenger" items="${passengerList}">
      <tr>
        <td>${passenger}</td>
      </tr>
    </c:forEach>
  </table>
</body>
</html>
