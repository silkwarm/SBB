<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="POST" action="AddTrain">
  <p><input type="text" name="trainNumber" value="" placeholder="train number"></p>
  <p><input type="text" name="sitCount" value="" placeholder="sit count"></p>
  <input type="submit"  value="Add train">
</form>
<form method="POST" action="AddStation">
  <p><input type="text" name="stationName" value="" placeholder="station name"></p>
  <input type="submit"  value="Add station">
</form>
<form method="POST" action="GetPassengers">
  <p><input type="text" name="trainNumber" value="" placeholder="train number"></p>
  <input type="submit"  value="Show passengers">
</form>
<form method="POST" action="GetTrains">
  <input type="submit"  value="Show trains">
</form>
</body>
</html>
