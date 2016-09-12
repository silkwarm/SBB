package ru.tsystems.sbb.persistence;

import javax.persistence.*;

@MappedSuperclass
@Entity
public abstract class AbstractPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_object")
    @SequenceGenerator(name = "seq_object", sequenceName = "seq_object")
    protected long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
