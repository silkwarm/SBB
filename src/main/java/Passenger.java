import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Passenger implements Serializable {
    @Id
    private long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "BIRTHDATE")
    private Date birthdate;
}
