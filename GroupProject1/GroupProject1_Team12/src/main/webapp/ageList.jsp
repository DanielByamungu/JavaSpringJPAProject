<%@ page import="bean.AgeRecord" %>
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
        table th:not(:first-child) {
            text-align: center;
        }
        table td:not(:first-child) {
            text-align: center;
        }
    </style>
</head>

<body>
<jsp:include page="navbar.jsp" />
<div style="text-align: center">
    <div class="container">
        <h1>Age List</h1>
        <table>
            <thead>
            <tr>
                <th rowspan="2" style="border-right: 2px solid white;">Age</th>
                <th colspan="2">2016</th>
                <th colspan="2">2021</th>
            </tr>
            <tr>
                <th>Male</th>
                <th style="border-right: 2px solid white;">Female</th>
                <th>Male</th>
                <th>Female</th>
            </tr>
            </thead>
            <tbody>
            <% List<AgeRecord> ageRecordList = (List<AgeRecord>)request.getAttribute("ageRecordList");
                for (AgeRecord ageRecord : ageRecordList) { %>
            <tr>
                <td><%=ageRecord.getDescription()%></td>
                <td><%=ageRecord.getMale2016()%></td>
                <td><%=ageRecord.getFemale2016()%></td>
                <td><%=ageRecord.getMale2021()%></td>
                <td><%=ageRecord.getFemale2021()%></td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>