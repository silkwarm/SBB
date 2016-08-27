import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Ticket implements Serializable {
    @Id
    private long id;

}