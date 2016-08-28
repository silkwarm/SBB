import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table
public class TrainPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    private long id;
    @Column(name = "NUMBER")
    private String number;
    @Column (name = "SIT_COUNT")
    private Integer sit_count;
    @ManyToMany
    @JoinTable(name = "SCHEDULE", joinColumns = @JoinColumn(name = "ID_TRAIN"), inverseJoinColumns = @JoinColumn(name = "ID_STATION"))
    private Set<StationPO> stations;
    @OneToMany
    @JoinColumn(name = "TRAIN_ID")
    private TicketPO ticket;
}