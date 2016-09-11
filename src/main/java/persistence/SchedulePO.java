package persistence;

import javax.persistence.*;
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