<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lab1</title>
</head>
<body>
<form action="hello-servlet" onsubmit="time()">
    <label>Value:</label>
    <br>
    <input type="number" name="value">
    <br>
    <br>
    <label>Key:</label>
    <br>
    <input type="text" name="key">
    <br>
    <br>
    <label>Mock:</label>
    <br>
    <select name="mock">
        <option value="true">True</option>
        <option value="false">False</option>
    </select>
    <br>
    <br>
    <label>Sync:</label>
    <br>
    <select name="sync">
        <option value="true">True</option>
        <option value="false">False</option>
    </select>
    <br>
    <br>
    <input type="submit" value="Submit">
    <br>
</form>
</body>
</html>