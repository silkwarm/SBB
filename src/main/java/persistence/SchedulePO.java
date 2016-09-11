package persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class SchedulePO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    private long id;
    @Column(name="ID_STATION", nullable = false)
    private long id_station;
    @Column(name="ID_TRAIN", nullable = false)
    private long id_train;
    @Column(name="TIME")
    private Date time;
}