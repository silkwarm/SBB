package service;

import dao.PassengerDAO;
import dao.StationDAO;
import dao.TrainDAO;
import persistence.PassengerPO;
import persistence.StationPO;
import persistence.TrainPO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AdminServiceImp implements AdminService{
    public void addStation(StationPO station) {
        StationDAO stations = new StationDAO();
        try {
            stations.add(station);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addTrain(TrainPO train) {
        TrainDAO trains = new TrainDAO();
        try {
            trains.add(train);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Set<PassengerPO> getPassengerListByTrainNumber(String trainNumber) {
        PassengerDAO passengers = new PassengerDAO();
        TrainDAO trains = new TrainDAO();
        Set<PassengerPO> set = new HashSet<PassengerPO>();
        TrainPO train = trains.getTrainByNumber(trainNumber);

        try {
            set = passengers.getPassangersByTrain(train);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return set;
    }

    public Set<TrainPO> getTrainrList() throws SQLException {
        TrainPO train = new TrainPO();
        TrainDAO trains = new TrainDAO();
        Set<TrainPO> set = new HashSet<TrainPO>();

        set = trains.getAll(train);
        return set;
    }
}
