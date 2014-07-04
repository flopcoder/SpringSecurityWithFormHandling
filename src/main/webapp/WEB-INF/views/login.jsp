<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>

</head>
<body>

<div id="login_wrap">


    <!-- Login Error Message -->
    <c:if test="${not empty message}">
        <c:out value="${message}"></c:out>
    </c:if>
    <!-- Login Error Message -->

    <form:form id="loginForm" name="form1"
               action="${pageContext.servletContext.contextPath}/login"
               method="POST" modelAttribute="user">

        <form:hidden path="name"/>
        <form:hidden path="address"/>
        <form:hidden path="mobile"/>
        <table>
            <tr>
                <td>User Name</td>
                <td><form:input path="userName" id="userName"/></td>
                <td><font color="red"><form:errors path="userName"/></font></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><form:password path="password" id="password"/></td>

                <td class="check"><font color="red"><form:errors
                        path="password"/></font></td>

            </tr>

            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" name="submit" value="Login" class="loginbutton">
                </td>
            </tr>
        </table>

    </form:form>
</div>
</body>
</html>