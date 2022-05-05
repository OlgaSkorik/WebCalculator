package by.skorik.webcalculator.servlets.servlet.servlet_calc;


import by.skorik.webcalculator.dao.OperationDAO;
import by.skorik.webcalculator.dao.UserDAO;
import by.skorik.webcalculator.entity.Operation;
import by.skorik.webcalculator.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet("/calcU")
public class CalculatorServletUser extends HttpServlet {


    public static Logger logger = LoggerFactory.getLogger("CalculatorServletAdmin");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/pages/user_calc.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double num1 = Double.parseDouble(req.getParameter("num1"));
        double num2 = Double.parseDouble(req.getParameter("num2"));
        String operation = req.getParameter("operation");
        switch (operation) {
            case "addition":
                req.setAttribute("result", CalculatorService.addition(num1, num2));
                break;
            case "subtraction":
                req.setAttribute("result", CalculatorService.subtraction(num1, num2));
                break;
            case "multiplication":
                req.setAttribute("result", CalculatorService.multiplication(num1, num2));
                break;
            case "division":
                req.setAttribute("result", CalculatorService.division(num1, num2));
                break;
        }
        logger.info("Calculation operation completed!");

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<OperationDAO> daoOperation = (AtomicReference<OperationDAO>) req.getServletContext().getAttribute("daoOperation");
        @SuppressWarnings("unchecked")
        final AtomicReference<UserDAO> dao = (AtomicReference<UserDAO>) req.getServletContext().getAttribute("dao");

        long id = daoOperation.get().getStoreOperation().size()+1;

        daoOperation.get().getStoreOperation().add(new Operation(id, num1, num2, operation,dao.get().getUserByLoginPassword(login, password)));

        getServletContext().getRequestDispatcher("/WEB-INF/pages/user_calc.jsp").forward(req, resp);
    }
}
