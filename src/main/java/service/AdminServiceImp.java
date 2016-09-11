package service;

import dao.StationDAO;
import dao.TrainDAO;
import persistence.PassengerPO;
import persistence.StationPO;
import persistence.TrainPO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AdminServiceImp implements AdminService{
    public void addStation(String stationName) {
        StationPO station = new StationPO();
        StationDAO stations = new StationDAO();

        station.setName(stationName);
        try {
            stations.add(station);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTrain(String trainNumber, int sitCount) {
        TrainPO train = new TrainPO();
        TrainDAO trains = new TrainDAO();

        train.setNumber(trainNumber);
        train.setSitCount(sitCount);
        try {
            trains.add(train);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<PassengerPO> getPassengerListByTrainNumber(String trainNumber) {
        TrainDAO trains = new TrainDAO();
        TrainPO train = trains.getTrainByNumber(trainNumber);

        return train.getPassengers();
    }

    public Set<TrainPO> getTrainrList() throws SQLException {
        TrainPO train = new TrainPO();
        TrainDAO trains = new TrainDAO();
        Set<TrainPO> set = new HashSet<TrainPO>();

        set = trains.getAll(train);
        return set;
    }
}
