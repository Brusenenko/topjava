<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create meal</title>
</head>
<body>
<section>
    <h2><a href="index.html">Home</a></h2>
    <h2>${param.action == "create" ? "Create meal" : "Edit meal"}</h2>
    <hr>
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.Meal" scope="request"/>
    <form method="post" action="meals">
        <input type="hidden" name="id" value="${meal.id}">
        <dl>
            <dt>DateTime:</dt>
            <dt><input type="datetime-local" value="${meal.dateTime}" name="dateTime"></dt>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dt><input type="text" value="${meal.description}" size=30 name="description"></dt>
        </dl>
        <dl>
            <dt>Calories:</dt>
            <dt><input type="number" value="${meal.calories}" size=30 name="calories"></dt>
        </dl>
        <button type="submit">Save</button>
        <input type="button" value="Cancel" onclick="window.history.back();"/>
    </form>
</section>
</body>
</html>
