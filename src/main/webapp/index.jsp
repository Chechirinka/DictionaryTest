<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Libraries menu</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<h2>Здравствуйте!</h2>--%>
<%--<a href="/work/start">Start</a>--%>
<%--</body>--%>
<%--</html>--%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns: lang="ru">

<head>
    <meta charset="UTF-8">
    <title>My app</title>
</head>

<body>

<p>Select language:</p>

<form action="/work/work-lib-menu" method="get">

    <div>
        <select name="id">
            <option value="1">English</option>
            <option value="2">Digital</option>
        </select>
    </div>
    <br/>
    <br/>
    <br/>

    <div>
        <button name="" value="">Send</button>
    </div>

</form>
</body>
</html>