package ru.tsystems.sbb.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_STATION")
public class StationPO  extends AbstractPO  implements Serializable {
    @Column(name="NAME",unique = true, nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "station")
    private List<TrainPO> trains;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<TrainPO> getTrains() {
        return trains;
    }

    public void setTrains(List<TrainPO> trains) {
        this.trains = trains;
    }
}