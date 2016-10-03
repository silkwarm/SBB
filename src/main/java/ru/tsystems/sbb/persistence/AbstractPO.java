package ru.tsystems.sbb.persistence;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractPO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_pk")
    @SequenceGenerator(name = "seq_pk", sequenceName = "seq_pk")
    protected long id;

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
