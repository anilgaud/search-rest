<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New/Edit Contact</title>
        <style>
            .error { 
                color: red; font-weight: bold; 
            }
        </style>

    </head>
    <body background="<%=request.getContextPath()%>/resources/images/wp2596947.jpg">>
        <div align="center">
            <h1><font color="red">New/Edit Employee </font></h1>

            <%--<form:errors path="employee.*"/>--%>
            <form:form action="saveEmployee" method="post" modelAttribute="employee" commandName="employee">
                <form:errors path = "*" cssClass = "errorblock" element = "div" />
                <table>
                    <form:hidden path="id"/>
                    <tr>
                        <td><font color="yellow">Name:</font></td>
                        <td><form:input path="name" /></td>
                        <td><form:errors path="email" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><font color="yellow"> Email: </font></td>
                        <td><form:input path="email" type="email" /></td>
                    <tr>
                        <td><input type="submit" value="Send OTP" name="action1"/></td>     
                        <td><form:input path="otp" /></td>
                    </tr>
                    </tr>
                    <%-- <tr>
                       <td><input type="submit" value="Send OTP"></td>
                    </tr>
                    <tr>
                       <td>Enter OTP</td>
                       <td><form:input path="otp" /></td>
                    </tr> --%>
                    <tr>
                        <td><font color="yellow">Address:</font></td>
                        <td><form:input path="address" /></td>
                    </tr>
                    <tr>
                        <td><font color="yellow"> Telephone: </font></td>
                        <td><form:input path="telephone" /></td>
                    </tr>
                    <tr>
                        <td><font color="yellow"> Skills: </font></td>
                        <td>
                            <form:select path="skills" >

                                <form:options items="${listSkill}" />
                            </form:select>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2" align="center"><input type="submit" value="Save" name="action2"></td>
                    </tr>
                </table>
            </form:form>

        </div>
    </body>
</html>