import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
public class UserPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    private long id;
    @Column(name = "LOGIN", unique = true, nullable = false)
    private String login;
    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;

    public void setId (long id) {
        this.id = id;
    }
    public void setLogin (String login) {
        this.login = login;
    }
    public void setPassword (String password) {
        this.password = password;
    }
}
