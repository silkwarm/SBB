package ru.tsystems.sbb.persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_USER")
public class UserPO extends AbstractPO implements Serializable {
    @Column(name = "LOGIN", unique = true, nullable = false)
    private String login;
    @Column(name = "PASSWORD", unique = true, nullable = false)
    private String password;
    @Column(name = "IS_ADMIN", nullable = false)
    private int is_admin;

    public int getIs_admin() {
        return is_admin;
    }

    public void setIs_admin(int is_admin) {
        this.is_admin = is_admin;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin (String login) {
        this.login = login;
    }
    public void setPassword (String password) {
        this.password = password;
    }
}
