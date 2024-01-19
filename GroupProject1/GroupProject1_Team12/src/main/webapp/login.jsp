<%--
  Created by IntelliJ IDEA.
  User: DFurs3133
  Date: 2/09/23
  Time: 5:36 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Database Login</title>
  <style>
    .container {
      background-color: white;
      border: 2px solid #00d8ff;
      border-radius: 10px;
      box-shadow: 5px 5px 5px grey;
      padding: 20px;
      margin: 50px auto;
      width: 300px;
      text-align: center;
    }
    input[type="text"], input[type="password"] {
      width: 100%;
      padding: 12px 20px;
      margin: 8px 0;
      display: inline-block;
      border: 2px solid #00d8ff;
      border-radius: 4px;
      box-sizing: border-box;
      font-size: 16px;
    }
    input[type="submit"] {
      background-color: white;
      padding: 12px 20px;
      border: 2px solid #00d8ff;
      border-radius: 4px;
      cursor: pointer;
      font-size: 16px;
    }
  </style>
</head>
<body>
<div  class="container">
  <h1>Login Form</h1>
  <form action="<%= request.getContextPath()%>/login" method="post">
    <table style="width: 80%">
      <tr>
        <td>UserName: </td>
        <td><input type="text" name="username" required></td>
      </tr>
      <tr>
        <td>Password: </td>
        <td><input type="password" name="password" required></td>
      </tr>
    </table>
    <input type="submit" value="Submit"/>
  </form>
  <br/>

  <div>
    <%
      String errorMessage = (String) request.getAttribute("error");

      if(errorMessage == null)
        errorMessage = "";
    %>
    <p style="color: red"><%=errorMessage%></p>
  </div>
</div>

</body>
</html>
