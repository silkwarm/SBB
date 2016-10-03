package ru.tsystems.sbb.service;

import ru.tsystems.sbb.dao.StationDAO;
import ru.tsystems.sbb.dao.TrainDAO;
import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public class AdminServiceImp implements AdminService{
    private StationDAO stationDAO = new StationDAO();
    private TrainDAO trainDAO = new TrainDAO();

    public void addStation(String stationName) {
        StationPO station = new StationPO();
        station.setName(stationName);

        try {
            stationDAO.add(station);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrain(String trainNumber, int sitCount) {
        TrainPO train = new TrainPO();

        train.setNumber(trainNumber);
        train.setSitCount(sitCount);
        try {
            trainDAO.add(train);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PassengerPO> getPassengerListByTrainNumber(String trainNumber) {
        return trainDAO.getPassengersByTrain(trainNumber);
    }

    public List<TrainPO> getTrainList() throws SQLException {
        return trainDAO.getAll(new TrainPO());
    }
}
