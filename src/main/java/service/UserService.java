package service;

import persistence.PassengerPO;
import persistence.StationPO;
import persistence.TrainPO;

import java.util.Date;
import java.util.Set;

public interface UserService {
    Set<TrainPO> getTrainByStationsAndTime(StationPO aStation, StationPO bStation); // + time
    Set<TrainPO> getTrainsByStation(StationPO station);
    boolean buyTicket(PassengerPO passeneger, TrainPO train, Date date); // + time
}
