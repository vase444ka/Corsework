<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Classes</title>
</head>

<body>
<div>
    <h1>Yearbook prod</h1>
</div>

<div>
    <div>
        <div>
            <h2>Classes</h2>
        </div>
        <ul>
            <%
                List<String> classes = (List<String>) request.getAttribute("classes");

                if (classes != null && !classes.isEmpty()) {
                    for (String s : classes) {
                        out.println("<li>" + s + "</li>");
                    }
                }
                else{
                    out.println("<p>The photographer is starving!</p>");
                }
            %>
        </ul
    </div>
</div>

<div>
    <button onclick="location.href='../../web'">Back to main</button>
</div>
</body>
</html>