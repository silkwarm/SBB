package ru.tsystems.sbb.service;

import ru.tsystems.sbb.dao.*;
import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TicketPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class UserServiceImp implements UserService {
    private StationDAO stationDAO = new StationDAO();
    private ScheduleDAO scheduleDAO = new ScheduleDAO();
    private TicketDAO ticketDAO = new TicketDAO();
    private PassengerDAO passengerDAO = new PassengerDAO();
    private TrainDAO trainDAO = new TrainDAO();

    private int getFreeSits(TrainPO train) {
        return train.getSitCount() - train.getPassengers().size();
    }
    private boolean isPassengerRegisteredOnTrain(TrainPO train, PassengerPO passenger) {
        return train.getPassengers().contains(passenger);
    }

    public List<TrainPO> getTrainByStationsAndTime(String stationNameA, String stationNameB, Date startTime, Date endTime) {
        StationPO stationA = stationDAO.getStationByName(stationNameA);
        StationPO stationB = stationDAO.getStationByName(stationNameB);
        List<TrainPO> trainsA = stationA.getTrains();
        List<TrainPO> trainsB = stationB.getTrains();
        List<TrainPO> trains = null;

        for (TrainPO train : trainsA) {
            // && schedule.getTimeByStationAndTrain(stationA, train)
            if (trainsB.contains(train)
                    && (scheduleDAO.getTimeByStationAndTrain(stationA, train).compareTo(startTime) >= 0)
                    && (scheduleDAO.getTimeByStationAndTrain(stationB, train).compareTo(endTime) <= 0)) {
                trains.add(train);
            }
        }
        return trains;
    }

    public List<TrainPO> getTrainsByStation(String stationName) {
        return stationDAO.getTrainsByStation(stationName);
    }

    public boolean buyTicket(String passengerName, String passengerSurname, String trainNumber, Date date) {
        LocalDateTime myDate = LocalDateTime.now();
        LocalDateTime pDate = LocalDateTime.now();
        TicketPO ticket = new TicketPO();
        PassengerPO passenger = passengerDAO.getPassengerByName(passengerName, passengerSurname);
        TrainPO train = trainDAO.getTrainByNumber(trainNumber);
        // add date!!!!
        if ((getFreeSits(train) > 0) && !isPassengerRegisteredOnTrain(train, passenger)) {
            ticket.setPassenger(passenger);
            ticket.setTrain(train);
            try {
                ticketDAO.add(ticket);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
