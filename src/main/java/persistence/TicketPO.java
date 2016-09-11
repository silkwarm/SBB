package persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_TICKET")
public class TicketPO extends AbstractPO implements Serializable {
    @Column(name = "ID_TRAIN")
    private long id_train;
    @Column(name = "ID_PASSENGER")
    private long id_passenger;
    @OneToOne(optional=false, mappedBy="ticket")
    private PassengerPO passenger;
    @OneToOne(optional=false, mappedBy="ticket")
    private TrainPO train;
}