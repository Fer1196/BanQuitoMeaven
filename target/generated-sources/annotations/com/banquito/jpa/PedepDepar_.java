package com.banquito.jpa;

import com.banquito.jpa.PecarCargo;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T14:59:44")
@StaticMetamodel(PedepDepar.class)
public class PedepDepar_ { 

    public static volatile SingularAttribute<PedepDepar, String> pedepCodigo;
    public static volatile SingularAttribute<PedepDepar, String> pedepDescri;
    public static volatile CollectionAttribute<PedepDepar, PecarCargo> pecarCargoCollection;

}