import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Station implements Serializable {
    @Id
    private long id;
    @Column(name="NAME",unique = true, nullable = false, length = 100)
    private String name;
}