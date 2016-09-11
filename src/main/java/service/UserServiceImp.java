package service;

import dao.TicketDAO;
import persistence.PassengerPO;
import persistence.StationPO;
import persistence.TicketPO;
import persistence.TrainPO;

import java.sql.SQLException;
import java.util.Date;
import java.util.Set;

public class UserServiceImp implements UserService {

    private int getFreeSits(TrainPO train) {
        return train.getSitCount() - train.getPassengers().size();
    }
    private boolean isPassengerRegisteredOnTrain(TrainPO train, PassengerPO passenger) {
        return train.getPassengers().contains(passenger);
    }

    public Set<TrainPO> getTrainByStationsAndTime(StationPO aStation, StationPO bStation) {
        return null;
    }

    public Set<TrainPO> getTrainsByStation(StationPO station) {
        return station.getTrains();
    }

    public boolean buyTicket(PassengerPO passeneger, TrainPO train, Date date) {
        TicketPO ticket = new TicketPO();
        TicketDAO ticketD = new TicketDAO();
        // add date!!!!
        if ((getFreeSits(train) > 0) && !isPassengerRegisteredOnTrain(train, passeneger)) {
            ticket.setPassenger(passeneger);
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
