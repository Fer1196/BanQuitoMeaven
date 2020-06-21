package com.banquito.jpa;

import com.banquito.jpa.XeperPerfil2;
import com.banquito.jpa.XesisSistem;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T14:59:44")
@StaticMetamodel(Aplicacion.class)
public class Aplicacion_ { 

    public static volatile SingularAttribute<Aplicacion, Long> codigoAplicacion;
    public static volatile SingularAttribute<Aplicacion, String> descripcionapp;
    public static volatile CollectionAttribute<Aplicacion, XeperPerfil2> xeperPerfil2Collection;
    public static volatile SingularAttribute<Aplicacion, String> nombre;
    public static volatile CollectionAttribute<Aplicacion, XesisSistem> xesisSistemCollection;

}