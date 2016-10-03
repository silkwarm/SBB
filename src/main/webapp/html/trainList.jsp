<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Train list</title>
</head>
<body>
<table>
  <tr> <td>Train number</td><td>Sit count</td> </tr>
  <c:forEach var="train" items="${trainList}">
    <tr>
      <td>${train.getNumber()}</td>
      <td>${train.getSitCount()}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
