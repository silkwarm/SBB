<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Train list</title>
</head>
<body>
<table>
  <tr> <td>Train number</td><td>Sit count</td> </tr>
  <c:forEach var="train" items="${trainList}">
    <tr>
      <td>${train.number}</td>
      <td>${train.sitCount}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
