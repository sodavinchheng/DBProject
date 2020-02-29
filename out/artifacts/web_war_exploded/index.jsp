<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css"></link>
  </head>
  <body>
    <nav class="navbar justify-content-center bg-dark p-3 mb-5">
      <ul class="nav">
        <li class="nav-item mx-5">
          <button class="btn btn-primary btn-lg" onclick="showForm('insertForm')">Insert</button>
        </li>
        <li class="nav-item mx-5">
          <button class="btn btn-primary btn-lg" onclick="showForm('viewForm')">View</button>
        </li>
        <li class="nav-item mx-5">
          <button class="btn btn-primary btn-lg" onclick="showForm('updateForm')">Update</button>
        </li>
        <li class="nav-item mx-5">
          <button class="btn btn-primary btn-lg" onclick="showForm('deleteForm')">Delete</button>
        </li>
      </ul>
    </nav>

    <div class="container my-form" id="insertForm">
      <form action="InsertRecord" method="post">
        <div class="form-group">
          <label for="firstNameInsertInput">First Name:</label>
          <input type="text" class="form-control" id="firstNameInsertInput" name="first_name_insert">
        </div>

        <div class="form-group">
          <label for="lastNameInsertInput">Last Name:</label>
          <input type="text" class="form-control" id="lastNameInsertInput" name="last_name_insert">
        </div>

        <div class="form-group">
          <label for="batchInsertInput">Batch:</label>
          <select class="form-control" id="batchInsertInput" name="batch_insert">
            <option disabled selected value> -- Select A Batch -- </option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6A</option>
            <option>6B</option>
            <option>6C</option>
            <option>7</option>
            <option>8A</option>
            <option>8B</option>
            <option>8C</option>
          </select>
        </div>

        <div class="form-group">
          <label for="rankInsertInput">Rank:</label>
          <select class="form-control" id="rankInsertInput" name="rank_insert">
            <option disabled selected value> -- Select A Rank -- </option>
            <option>S</option>
            <option>A</option>
            <option>B</option>
            <option>C</option>
          </select>
        </div>

        <button type="submit" class="btn btn-primary">Insert Record</button>
      </form>
    </div>

    <div class="container my-form" id="viewForm">
      <form action="ViewRecord" method="post">
        <div class="form-group">
          <label for="idViewInput">Id:</label>
          <input type="text" class="form-control" id="idViewInput" name="id_view">
        </div>

          <button type="submit" class="btn btn-primary">View Record</button>
      </form>

      <p>--Or--</p>

      <form action="ViewAllRecords" method="post">
        <button type="submit" class="btn btn-primary">View All Records</button>
      </form>
    </div>

    <div class="container my-form" id="updateForm">
      <form action="UpdateRecord" method="post">
        <div class="form-group">
          <label for="idUpdateInput">Id:</label>
          <input type="text" class="form-control" id="idUpdateInput" name="id_update">
        </div>

        <div class="form-group">
          <label for="firstNameUpdateInput">First Name:</label>
          <input type="text" class="form-control" id="firstNameUpdateInput" name="first_name_update">
        </div>

        <div class="form-group">
          <label for="lastNameUpdateInput">Last Name:</label>
          <input type="text" class="form-control" id="lastNameUpdateInput" name="last_name_update">
        </div>

        <div class="form-group">
          <label for="batchUpdateInput">Batch:</label>
          <select class="form-control" id="batchUpdateInput" name="batch_update">
            <option disabled selected value> -- Select A Batch -- </option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6A</option>
            <option>6B</option>
            <option>6C</option>
            <option>7</option>
            <option>8A</option>
            <option>8B</option>
            <option>8C</option>
          </select>
        </div>

        <div class="form-group">
          <label for="rankUpdateInput">Rank:</label>
          <select class="form-control" id="rankUpdateInput" name="rank_update">
            <option disabled selected value> -- Select A Rank -- </option>
            <option>S</option>
            <option>A</option>
            <option>B</option>
            <option>C</option>
          </select>
        </div>

        <button type="submit" class="btn btn-primary">Update Record</button>
      </form>
    </div>

    <div class="container my-form" id="deleteForm">
      <form action="DeleteRecord" method="post">
        <div class="form-group">
          <label for="idDeleteInput">Id:</label>
          <input type="text" class="form-control" id="idDeleteInput" name="id_delete">
        </div>

        <button type="submit" class="btn btn-primary">Delete Record</button>
      </form>
    </div>

    <script src="app.js"></script>
  </body>
</html>