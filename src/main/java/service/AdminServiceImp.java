package service;

import dao.TrainDAO;
import persistence.PassengerPO;
import persistence.StationPO;
import persistence.TrainPO;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class AdminServiceImp implements AdminService{
    public void addStation(StationPO station) {

    }

    public void addTrain(TrainPO train) {

    }

    public Set<PassengerPO> getPassengerListByTrain(TrainPO train) {
        return null;
    }

    public Set<TrainPO> getTrainrList() throws SQLException {
        TrainPO train = new TrainPO();
        TrainDAO trains = new TrainDAO();
        Set<TrainPO> set = new HashSet<TrainPO>();

        set = trains.getAll(train);
        return set;
    }
}
