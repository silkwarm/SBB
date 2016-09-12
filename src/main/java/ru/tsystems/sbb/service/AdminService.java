package ru.tsystems.sbb.service;

import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.sql.SQLException;
import java.util.Set;

public interface AdminService {
    void addStation(String stationName);
    void addTrain(String trainNumber, int sitCount);

    Set<PassengerPO> getPassengerListByTrainNumber(String trainNumber);
    Set<TrainPO> getTrainrList() throws SQLException;
}
