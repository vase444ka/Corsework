package app.servlets;

import app.dbc.YearbookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "list", value = "/list")
public class ListServlet extends HttpServlet {
    public ListServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InputStream input = getServletContext().getResourceAsStream("/WEB-INF/db.conf");
        List<String> flights = YearbookDAO.stringList(input);
        req.setAttribute("classes", flights);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
