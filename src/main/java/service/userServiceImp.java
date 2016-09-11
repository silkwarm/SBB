package service;

import persistence.PassengerPO;
import persistence.SchedulePO;
import persistence.StationPO;
import persistence.TrainPO;

import java.util.Date;
import java.util.Set;

public class userServiceImp implements UserService {

    public Set<TrainPO> getTrainByStationsAndTime(StationPO aStation, StationPO bStation) {
        return null;
    }

    public Set<SchedulePO> getScheduleByStation(StationPO station) {
        return null;
    }

    public boolean buyTicket(PassengerPO passeneger, TrainPO train, Date date) {
        return false;
    }
}
