import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Passenger implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "BIRTHDATE")
    private Date birthdate;
    @OneToOne
    @JoinColumn(name = "PASSENGER_ID")
    private Ticket ticket;
}
