package persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_TRAIN")
public class TrainPO  extends AbstractPO  implements Serializable {
    @Column(name = "TRAIN_NUMBER")
    private String number;
    @Column (name = "SIT_COUNT")
    private Integer sit_count;

    @ManyToOne
    @JoinTable(name = "T_SCHEDULE", joinColumns = @JoinColumn(name = "ID_STATION"), inverseJoinColumns = @JoinColumn(name = "ID_TRAIN"))
    private StationPO station;

    @OneToMany(mappedBy = "train", fetch = FetchType.LAZY)
    private Set<PassengerPO> passengers;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getSit_count() {
        return sit_count;
    }

    public void setSit_count(Integer sit_count) {
        this.sit_count = sit_count;
    }

    public StationPO getStation() {
        return station;
    }

    public void setStation(StationPO station) {
        this.station = station;
    }


    public Set<PassengerPO> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<PassengerPO> passengers) {
        this.passengers = passengers;
    }
}