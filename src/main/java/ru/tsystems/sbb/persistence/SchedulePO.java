package ru.tsystems.sbb.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "T_SCHEDULE")
public class SchedulePO  extends AbstractPO  implements Serializable {
    @Column(name="TIME")
    private Date time;

    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
}