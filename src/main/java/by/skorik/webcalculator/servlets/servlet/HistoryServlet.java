package by.skorik.webcalculator.servlets.servlet;

import by.skorik.webcalculator.dao.OperationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    PrintWriter writer;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        @SuppressWarnings("unchecked")
        final AtomicReference<OperationDAO> daoOperation = (AtomicReference<OperationDAO>) req.getServletContext().getAttribute("daoOperation");

        resp.setContentType("application/json");
        writer = resp.getWriter();
        writer.print(daoOperation.get().getStoreOperation());
    }

    @Override
    public void destroy() {
        writer.close();
    }
}
