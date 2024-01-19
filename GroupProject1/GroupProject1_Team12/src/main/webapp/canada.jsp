<%@ page import="bean.GeographicArea" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Canada</title>
    <style>
        body{
            font-family: Arial, sans-serif;
            margin-top: 80px;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            box-shadow: 0px 0px 10px #888888;
        }
        th, td {
            padding: 12px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th {
            background-color: #0096b0;
            color: white;
            font-weight: bold;
            border-top: 2px solid white;
            border-bottom: 2px solid white;
            text-transform: uppercase;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

    </style>
</head>

<body>
<jsp:include page="navbar.jsp" />
<div style="text-align: center">
        <div class="container">
            <h1>The country of Canada</h1>
            <table>
                <thead>
                <tr>
                    <th>Level</th>
                    <th>Name</th>
                    <th>Details</th>
                </tr>
                </thead>
                <tbody>
                <% List<GeographicArea> geographicAreas = (List<GeographicArea>)request.getAttribute("geographicAreas");
                    for (GeographicArea area : geographicAreas) { %>
                <tr>
                    <td><%=area.getLevel()%></td>
                    <td><%=area.getName()%></td>
                    <td><a href="<%= request.getContextPath()%>/canadaDetails/<%= area.getGeographicAreaID()%>" style="color:blue; font-weight: normal;">Details</a></td>
                </tr>
                <% } %>
                </tbody>
            </table>
            </div>
    </div>
</body>
</html>