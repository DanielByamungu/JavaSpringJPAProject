<%@ page import="bean.GeographicArea" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>Geographic Area</title>
  <style>
    body {
      margin: 0;
      padding: 0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      background-color: #f2f2f2;
    }
    .card {
      background-color: white;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
      padding: 20px;
      width: 400px;
      max-width: 100%;
      display: flex;
      flex-direction: column;
      align-items: center;
    }
    .card-title {
      background-color: #0096b0;
      color: white;
      font-weight: bold;
      font-size: 20px;
      text-align: center;
      padding: 10px;
      border-top-left-radius: 10px;
      border-top-right-radius: 10px;
      width: 100%;
      margin-bottom: 20px;
      margin-top: -10px;
    }
    .card-field {
      display: flex;
      width: 100%;
      justify-content: space-between;
      margin-bottom: 10px;
    }
    .card-field label {
      font-weight: bold;
      margin-right: 10px;
      width: 120px;
    }
    .card-field span {
      flex-grow: 1;
      text-align: right;
    }
    .button {
      background-color: #0096b0;
      border: none;
      color: white;
      padding: 5px 20px;
      margin-bottom: 25px;
      text-align: center;
      text-decoration: none;
      display: block;
      font-size: 18px;
      border-radius: 5px;
      cursor: pointer;
      margin-top: 25px;
    }
    .arrow {
      display: inline-block;
      width: 0.7em;
      height: 0.7em;
      border-top: 0.25em solid white;
      border-right: 0.25em solid white;
      transform: rotate(225deg);
      margin-left: 5px;
      margin-top: 5px;
    }
    .button-text{
      position: relative;
      bottom: 2px;
    }

  </style>
</head>
<body>
<jsp:include page="navbar.jsp" />
<% GeographicArea geographicArea = (GeographicArea)request.getAttribute("geographicArea");%>
<div class="card">
  <div class="card-title">Canada Details</div>
  <div class="card-field">
    <label>Name:</label>
    <span> <%=geographicArea.getName()%></span>
  </div>
  <div class="card-field">
    <label>Code:</label>
    <span> <%=geographicArea.getCode()%></span></span>
  </div>
  <div class="card-field">
    <label>Level:</label>
    <span> <%=geographicArea.getLevel()%></span></span>
  </div>
  <div class="card-field">
    <label>Total Population:</label>
    <span> <%=geographicArea.getTotalPopulation()%></span></span>
  </div>
  <button class="button">
    <span class="arrow"></span>
    <span class="button-text"><a href="<%= request.getContextPath()%>/canada">Back</a></span>
  </button>
</div>


</body>
</html>
