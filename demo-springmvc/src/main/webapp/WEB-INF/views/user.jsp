<%@ page  contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>JSTL Demo</title>
</head>
<body>
    <table cellpadding=0 cellspacing=0 border="1px solid red;">
        <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>income</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${userList }" var="user">
            <tr>
                <td>${user.name }</td>
                <td>${user.age }</td>
                <td>${user.income }</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</body>
</html>
