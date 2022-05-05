package by.skorik.webcalculator.servlets;

import by.skorik.webcalculator.dao.OperationDAO;
import by.skorik.webcalculator.dao.UserDAO;
import by.skorik.webcalculator.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static by.skorik.webcalculator.entity.User.ROLE.ADMIN;
import static by.skorik.webcalculator.entity.User.ROLE.USER;

@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<UserDAO> dao;
    private AtomicReference<OperationDAO> daoOperation;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "Admin", "admin1", "admin1", ADMIN));
        dao.get().add(new User(2, "Olga", "olga", "123123", USER));

        daoOperation = new AtomicReference<>(new OperationDAO());

        final ServletContext servletContext =
                servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
        servletContext.setAttribute("daoOperation", daoOperation);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
