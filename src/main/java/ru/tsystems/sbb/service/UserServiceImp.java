package ru.tsystems.sbb.service;

import ru.tsystems.sbb.dao.*;
import ru.tsystems.sbb.persistence.PassengerPO;
import ru.tsystems.sbb.persistence.StationPO;
import ru.tsystems.sbb.persistence.TicketPO;
import ru.tsystems.sbb.persistence.TrainPO;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

public class UserServiceImp implements UserService {

    private int getFreeSits(TrainPO train) {
        return train.getSitCount() - train.getPassengers().size();
    }
    private boolean isPassengerRegisteredOnTrain(TrainPO train, PassengerPO passenger) {
        return train.getPassengers().contains(passenger);
    }

    public Set<TrainPO> getTrainByStationsAndTime(String stationNameA, String stationNameB, Date startTime, Date endTime) {
        ScheduleDAO schedule = new ScheduleDAO();
        StationDAO stationD = new StationDAO();
        StationPO stationA = stationD.getStationByName(stationNameA);
        StationPO stationB = stationD.getStationByName(stationNameB);
        Set<TrainPO> trainsA = stationA.getTrains();
        Set<TrainPO> trainsB = stationB.getTrains();
        Set<TrainPO> trains = null;


        for (TrainPO train : trainsA) {
            // && schedule.getTimeByStationAndTrain(stationA, train)
            if (trainsB.contains(train)
                    && (schedule.getTimeByStationAndTrain(stationA, train).compareTo(startTime) >= 0)
                    && (schedule.getTimeByStationAndTrain(stationB, train).compareTo(endTime) <= 0)) {
                trains.add(train);
            }
        }

        return trains;
    }

    public Set<TrainPO> getTrainsByStation(String stationName) {
        StationDAO stationD = new StationDAO();
        StationPO station = stationD.getStationByName(stationName);
        return station.getTrains();
    }

    public boolean buyTicket(String passengerName, String passengerSurname, String trainNumber, Date date) {
        LocalDateTime myDate = LocalDateTime.now();
        LocalDateTime pDate = LocalDateTime.now();
        TicketPO ticket = new TicketPO();
        TicketDAO ticketD = new TicketDAO();
        PassengerDAO passD = new PassengerDAO();
        PassengerPO passenger = passD.getPassengerByName(passengerName, passengerSurname);
        TrainDAO trainD = new TrainDAO();
        TrainPO train = trainD.getTrainByNumber(trainNumber);
        // add date!!!!
        if ((getFreeSits(train) > 0) && !isPassengerRegisteredOnTrain(train, passenger)) {
            ticket.setPassenger(passenger);
            ticket.setTrain(train);
            try {
                ticketD.add(ticket);
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
