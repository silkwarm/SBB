package ru.tsystems.sbb.service;

import ru.tsystems.sbb.persistence.TrainPO;

import java.util.Date;
import java.util.Set;

public interface UserService {
    Set<TrainPO> getTrainByStationsAndTime(String stationNameA, String stationNameB, Date startTime, Date endTime); // + time
    Set<TrainPO> getTrainsByStation(String stationName);
    boolean buyTicket(String passengerName, String passengerSurname, String trainNumber, Date date); // + time
}
