package org.acme;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "Pitch")
public class Pitch extends PanacheEntity{
    
    public String textoPitch;
    public String serie_investimento;
    @ManyToOne
    public Startup startup;

}
