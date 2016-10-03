package ru.tsystems.sbb.servlet;

import ru.tsystems.sbb.dao.UserDAO;
import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.TrainPO;
import ru.tsystems.sbb.service.AdminServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class GetPassengers extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext context = getServletContext();
        AdminServiceImp adminService = new AdminServiceImp();
        String trainNumber = req.getParameter("trainNumber");
        List<PassengerPO> passengers = adminService.getPassengerListByTrainNumber(trainNumber);

        RequestDispatcher dispatcher = context.getRequestDispatcher("/html/passengerList.jsp");

        req.setAttribute("passengerList", passengers);
        dispatcher.forward(req, res);
    }
}
