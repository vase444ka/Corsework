<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add new class</title>
</head>
<body>

<div>
    <h1>Yearbook prod</h1>
</div>

<div>
    <%
        if (request.getAttribute("new_yearbook") != null) {
            out.println("<p>" + request.getAttribute("new_yearbook") + " added!</p>");
        }
    %>
    <div>
        <div>
            <h2>Add flight</h2>
        </div>

        <form method="post">
            <label>grade of the class:
                <input type="number" name="grade"><br />
            </label>

            <label>The name of the school:
                <input type="text" name="school_name"><br />
            </label>

            <label>Type of the book:
                <input type="text" name="type"><br />
            </label>

            <label>Price per student, UAH:
                <input type="number" name="price"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>
</body>

</body>
</html>