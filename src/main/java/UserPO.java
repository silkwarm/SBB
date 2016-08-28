import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class UserPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    private long id;
    @Column(name = "LOGIN", unique = true, nullable = false)
    private String login;
    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;
}
