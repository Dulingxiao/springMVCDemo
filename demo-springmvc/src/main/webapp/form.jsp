<%@ page  contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="/hello/show8.do" >
        name:<input type="text" name="name" /><br />
        age:<input type="text" name="age" /><br />
        isMarry:<input type="checkbox" name="isMarry"/><br />
        income:<input type="text" name="income" /><br />
        interests:<input type="checkbox" name="interests" value="bb" />basketball
        <input type="checkbox" name="interests" value="fb" />football
        <input type="checkbox" name="interests" value="vb" />vollyball<br />
        <input type="submit" value="提交" />
    </form>

</body>
</html>
