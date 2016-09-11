package persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USER")
public class UserPO extends AbstractPO implements Serializable {
    @Column(name = "LOGIN", unique = true, nullable = false)
    private String login;
    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;

    public void setLogin (String login) {
        this.login = login;
    }
    public void setPassword (String password) {
        this.password = password;
    }
}
