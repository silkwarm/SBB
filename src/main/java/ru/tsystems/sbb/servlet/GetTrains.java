package ru.tsystems.sbb.servlet;

import ru.tsystems.sbb.service.AdminServiceImp;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class GetTrains extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext context = getServletContext();
        AdminServiceImp adminService = new AdminServiceImp();

        RequestDispatcher dispatcher = context.getRequestDispatcher("/html/trainList.jsp");
        try {
            req.setAttribute("trainList", adminService.getTrainList());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dispatcher.forward(req, res);
    }
}
