package ru.tsystems.sbb.servlet;

import ru.tsystems.sbb.dao.UserDAO;
import ru.tsystems.sbb.persistence.UserPO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class Login extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //res.sendRedirect("/html/user.jsp");
        String dispatchTo;
        UserDAO  userD = new UserDAO();
        ServletContext context = getServletContext();

        if (userD.getUserTypeByLogin(req.getParameter("login")) == 0){
            dispatchTo = "user";
        }
        else {
            dispatchTo = "admin";
        }

        RequestDispatcher dispatcher = context.getRequestDispatcher("/html/"+dispatchTo+".jsp");
        dispatcher.forward(req, res);
    }
}
