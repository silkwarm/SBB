package ru.tsystems.sbb.service;

import ru.tsystems.sbb.persistence.TrainPO;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface UserService {
    List<TrainPO> getTrainByStationsAndTime(String stationNameA, String stationNameB, Date startTime, Date endTime); // + time
    List<TrainPO> getTrainsByStation(String stationName);
    boolean buyTicket(String passengerName, String passengerSurname, String trainNumber, Date date); // + time
}
