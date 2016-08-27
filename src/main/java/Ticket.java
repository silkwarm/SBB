import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    private long id;
    @Column(name = "ID_TRAIN")
    private long id_train;
    @Column(name = "ID_PASSENGER")
    private long id_passenger;
    @OneToOne(optional=false, mappedBy="ticket")
    private Passenger passenger;
    @OneToOne(optional=false, mappedBy="ticket")
    private Train train;
}