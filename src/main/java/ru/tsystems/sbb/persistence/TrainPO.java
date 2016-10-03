package ru.tsystems.sbb.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_TRAIN")
public class TrainPO  extends AbstractPO  implements Serializable {
    @Column(name = "TRAIN_NUMBER")
    private String number;
    @Column (name = "SIT_COUNT")
    private Integer sitCount;

    @ManyToOne
    @JoinTable(name = "T_SCHEDULE", joinColumns = @JoinColumn(name = "ID_STATION"), inverseJoinColumns = @JoinColumn(name = "ID_TRAIN"))
    private StationPO station;

    @OneToMany(mappedBy = "train")
    private List<PassengerPO> passengers;

    @OneToMany(mappedBy = "train")
    private Set<TicketPO> tickets;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getSitCount() {
        return sitCount;
    }

    public void setSitCount(Integer sit_count) {
        this.sitCount = sit_count;
    }

    public StationPO getStation() {
        return station;
    }

    public void setStation(StationPO station) {
        this.station = station;
    }


    public List<PassengerPO> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerPO> passengers) {
        this.passengers = passengers;
    }

    public Set<TicketPO> getTickets() {
        return tickets;
    }

    public void setTickets(Set<TicketPO> tickets) {
        this.tickets = tickets;
    }
}