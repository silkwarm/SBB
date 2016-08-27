import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class Train implements Serializable {
    @Id
    private long id;
    @Column(name = "NUMBER")
    private String number;
    @Column (name = "SIT_COUNT")
    private Integer sit_count;
    @ManyToMany
    @JoinTable(name = "SCHEDULE", joinColumns = @JoinColumn(name = "ID_TRAIN"), inverseJoinColumns = @JoinColumn(name = "ID_STATION"))
    private Set<Station> stations;
}