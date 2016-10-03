package ru.tsystems.sbb.servlet;

import ru.tsystems.sbb.dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetPassengers extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext context = getServletContext();

        RequestDispatcher dispatcher = context.getRequestDispatcher("/html/passengerList.jsp");
        dispatcher.forward(req, res);
    }
}
