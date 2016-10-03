package ru.tsystems.sbb.servlet;

import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;
import ru.tsystems.sbb.service.AdminServiceImp;
import ru.tsystems.sbb.service.UserServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetTrainsByStation extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ServletContext context = getServletContext();
        UserServiceImp userService = new UserServiceImp();
        String stationName = req.getParameter("stationName");
        List<TrainPO> trains = userService.getTrainsByStation(stationName);

        RequestDispatcher dispatcher = context.getRequestDispatcher("/html/trainList.jsp");

        req.setAttribute("trainList", trains);
        dispatcher.forward(req, res);
    }
}
