package service;

import persistence.PassengerPO;
import persistence.SchedulePO;
import persistence.StationPO;
import persistence.TrainPO;
import java.util.Set;
import java.util.Date;

public interface UserService {
    Set<TrainPO> getTrainByStationsAndTime(StationPO aStation, StationPO bStation); // + time
    Set<SchedulePO> getScheduleByStation(StationPO station);
    boolean buyTicket(PassengerPO passeneger, TrainPO train, Date date); // + time
}
