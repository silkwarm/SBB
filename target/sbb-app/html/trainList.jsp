<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Train list</title>
</head>
<body>
<table border = 1>
  <tr> <td>Train number</td><td>Sit count</td> </tr>
  <c:forEach var="train" items="${trainList}">
    <tr>
      <td>1</td>
      <td>2</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
