package com.banquito.jpa;

import com.banquito.jpa.Aplicacion;
import com.banquito.jpa.XeestEstado;
import com.banquito.jpa.XeopcOpcion;
import com.banquito.jpa.XeusuUsuar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T14:59:44")
@StaticMetamodel(XesisSistem.class)
public class XesisSistem_ { 

    public static volatile SingularAttribute<XesisSistem, Aplicacion> codigoAplicacion;
    public static volatile CollectionAttribute<XesisSistem, XeopcOpcion> xeopcOpcionCollection;
    public static volatile SingularAttribute<XesisSistem, String> xesisCodsis;
    public static volatile SingularAttribute<XesisSistem, String> xesisDescri;
    public static volatile CollectionAttribute<XesisSistem, XeusuUsuar> xeusuUsuarCollection;
    public static volatile SingularAttribute<XesisSistem, XeestEstado> xeestEstado;

}