package ru.tsystems.sbb.servlet;

import ru.tsystems.sbb.dao.StationDAO;
import ru.tsystems.sbb.dao.TrainDAO;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddTrain extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TrainDAO trainDAO = new TrainDAO();
        TrainPO train = new TrainPO();
        train.setNumber(req.getParameter("trainNumber"));
        train.setSitCount(new Integer(req.getParameter("sitCount")));

        try {
            trainDAO.add(train);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}