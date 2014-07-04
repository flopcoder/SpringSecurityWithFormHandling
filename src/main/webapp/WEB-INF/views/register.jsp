<%--
  Created by IntelliJ IDEA.
  User: Flop Coder
  Date: 6/15/14
  Time: 11:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title></title>
</head>
<body>
<form:form commandName="user" action="registration/user">

    <label>Name:</label>
    <form:input path="name" />
    </br>
    <label>Address:</label>
    <form:input path="address"/>
    </br>
    <label>Mobile:</label>
    <form:input path="mobile"/>
    </br>
    <label>E-mail:</label>
    <form:input path="email"/>
    </br>
    <label>Username:</label>
    <form:input path="userName"/>
    </br>
    <label>Password:</label>
    <form:input path="password" />
    </br>
    <form:button id="submit" name="submit" value="Submit">SUBMIT</form:button>

</form:form>
</body>
</html>
