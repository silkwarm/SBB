package persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_TICKET")
public class TicketPO extends AbstractPO implements Serializable {


    @OneToOne(mappedBy = "ticket")
    PassengerPO passenger;

    @ManyToOne
    @JoinColumn(name = "ID_TRAIN")
    private TrainPO train;

    public PassengerPO getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerPO passenger) {
        this.passenger = passenger;
    }

    public TrainPO getTrain() {
        return train;
    }

    public void setTrain(TrainPO train) {
        this.train = train;
    }
}