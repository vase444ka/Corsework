package app.servlets;

import app.dbc.YearbookDAO;
import app.entities.Yearbook;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

@WebServlet(name = "add", value = "/add")
public class AddServlet extends HttpServlet {
    public AddServlet(){

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int grade = Integer.parseInt(req.getParameter("grade"));
        String schoolName = req.getParameter("school_name");
        String type = req.getParameter("type");
        int price = Integer.parseInt(req.getParameter("price"));

        Yearbook yearbook = new Yearbook(grade, schoolName, type, price);
        InputStream input = getServletContext().getResourceAsStream("WEB-INF/db.conf");
        YearbookDAO.insert(yearbook, input);

        req.setAttribute("new_yearbook", yearbook.toString());
        doGet(req, resp);
        //loads all the necessary info into Database as we hit submit and returns to the same page
    }
}
