package org.acme;



import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name = "Startup")
public class Startup extends PanacheEntity {
    
    public String nome;
    public String local;
    public int funcionarios;
    
    

}
