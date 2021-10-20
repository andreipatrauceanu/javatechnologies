<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Main page</title>
</head>
<body>
<form method="POST" action="hello-servlet" autocomplete="off">
    <jsp:useBean id="categories" scope="request" class="com.example.javalab2.Category"/>
    <label>Category:</label>
    <br>
    <select name="category" id="category">
    <%
            String lastcookie=null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("Category")) {
                        {
                            lastcookie = cookie.getValue();
                        }
                    }
                }
            }
            for (String category : categories.getTypes()) {
                if (category.equals(lastcookie)) {
                    out.println("<option value=" + category + " selected>" + category + "</option>");
                }
                else{
                    out.println("<option value=" + category + ">" + category + "</option>");
                }
            }
    %>
    </select>
    <br>
    <br>
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
    <img src="Captcha">
    <br>
    <br>
    <label>The captcha is:</label>
    <br>
    <br>
    <input type="text" name="captchaUser">
    <br>
    <br>
    <div style="color: #FF0000;">${errorMessage}</div>
    <br>
    <br>
    <input type="submit" value="Submit">
    <br>
</form>
</body>
</html>