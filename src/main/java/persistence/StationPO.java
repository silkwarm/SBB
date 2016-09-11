package persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "T_STATION")
public class StationPO  extends AbstractPO  implements Serializable {
    @Column(name="NAME",unique = true, nullable = false, length = 100)
    private String name;

    @OneToMany(mappedBy = "station", fetch = FetchType.LAZY)
    private Set<TrainPO> trains;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Set<TrainPO> getTrains() {
        return trains;
    }

    public void setTrains(Set<TrainPO> trains) {
        this.trains = trains;
    }
}