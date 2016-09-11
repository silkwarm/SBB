package service;

import persistence.PassengerPO;
import persistence.StationPO;
import persistence.TrainPO;

import java.sql.SQLException;
import java.util.Set;

public interface AdminService {
    void addStation(StationPO station);
    void addTrain(TrainPO train);

    Set<PassengerPO> getPassengerListByTrain(TrainPO train);
    Set<TrainPO> getTrainrList() throws SQLException;
}
