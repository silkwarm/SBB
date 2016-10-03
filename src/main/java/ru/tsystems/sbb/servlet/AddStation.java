package ru.tsystems.sbb.servlet;

import ru.tsystems.sbb.dao.StationDAO;
import ru.tsystems.sbb.persistence.StationPO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddStation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StationDAO stationDAO = new StationDAO();
        StationPO station = new StationPO();
        station.setName(req.getParameter("stationName"));

        try {
            stationDAO.add(station);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
