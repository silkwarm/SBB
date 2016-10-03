package ru.tsystems.sbb.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "T_PASSENGER")
public class PassengerPO  extends AbstractPO  implements Serializable {
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "BIRTHDATE")
    private Date birthdate;

    @ManyToOne
    @JoinTable(name = "T_TICKET", joinColumns = @JoinColumn(name = "ID_PASSENGER"),inverseJoinColumns = @JoinColumn(name = "ID_TRAIN"))
    private TrainPO train;

    @OneToOne(mappedBy = "passenger")
   // @JoinColumn(name = "ID_PASSENGER")
    private TicketPO ticket;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public TrainPO getTrain() {
        return train;
    }

    public void setTrain(TrainPO train) {
        this.train = train;
    }

    public TicketPO getTicket() {
        return ticket;
    }

    public void setTicket(TicketPO ticket) {
        this.ticket = ticket;
    }
}
