<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Document</title>

    <style>
      table, th, td {
        border: 1px solid black;
      }
    </style>
  </head>
  <body>
    <table>
      <tr>
        <th>id</th>
        <th>firstname</th>
        <th>lastname</th>
        <th>company</th>
        <th>salary</th>
        <th>username</th>
        <th>password</th>
      </tr>
      <c:forEach var = "employee" items = "${employees}">
        <tr>
          <td>${employee.getId()}</td>
          <td>${employee.getFirstname()}</td>
          <td>${employee.getLastname()}</td>
          <td>${employee.getCompany()}</td>
          <td>${employee.getSalary()}</td>
          <td>${employee.getUsername()}</td>
          <td>${employee.getPassword()}</td>
        </tr>
      </c:forEach>
    </table>
  </body>
</html>
