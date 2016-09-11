package persistence;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class StationPO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    private long id;
    @Column(name="NAME",unique = true, nullable = false, length = 100)
    private String name;
}