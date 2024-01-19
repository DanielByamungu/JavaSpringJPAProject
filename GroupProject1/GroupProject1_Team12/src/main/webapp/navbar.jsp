<%--
  Created by IntelliJ IDEA.
  User: nmysh
  Date: 3/3/2023
  Time: 7:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <style>
    nav {
      background-color: #0096b0;
      position: fixed;
      top: 0;
      left: 0;
      right: 0;
      padding: 10px;
    }
    ul {
      list-style: none;
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: space-evenly;
      align-items: center;
    }
    li {
      margin-right: 10px;
    }
    a {
      color: #fff;
      text-decoration: none;
      font-weight: bold;
      font-size: 18px;
    }

  </style>

</head>
<body>
<nav>
  <ul>
    <li><a href="<%= request.getContextPath()%>/canada">Canada</a></li>
    <li><a href="<%= request.getContextPath()%>/province">Provinces and Territories</a></li>
    <li><a href="<%= request.getContextPath()%>/cma">CMA and CA</a></li>
    <li><a href="<%= request.getContextPath()%>/provincial">Provincial Parts of Larger Areas</a></li>
    <li><a href="<%= request.getContextPath()%>/ageList">Age List</a></li>
  </ul>
</nav>
</body>
</html>
