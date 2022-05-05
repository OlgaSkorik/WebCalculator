package by.skorik.webcalculator.servlets.servlet;

import by.skorik.webcalculator.dao.UserDAO;
import by.skorik.webcalculator.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static by.skorik.webcalculator.entity.User.ROLE.USER;

@WebServlet ("/registration")
public class RegistrationServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (dao.get().userIsExist(login, password)) {
            getServletContext().getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(req, resp);
        } else {
            long id = dao.get().getStore().size()+1;
            dao.get().add(new User(id, name, login, password, USER));
            resp.sendRedirect("http://localhost:8082/");
        }
    }
}
