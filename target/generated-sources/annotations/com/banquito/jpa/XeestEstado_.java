package com.banquito.jpa;

import com.banquito.jpa.XeestEstadoPK;
import com.banquito.jpa.XesisSistem;
import com.banquito.jpa.XeusuUsuar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T14:59:44")
@StaticMetamodel(XeestEstado.class)
public class XeestEstado_ { 

    public static volatile SingularAttribute<XeestEstado, XeusuUsuar> xeusuUsuar;
    public static volatile SingularAttribute<XeestEstado, String> xeestDescri;
    public static volatile SingularAttribute<XeestEstado, XeestEstadoPK> xeestEstadoPK;
    public static volatile SingularAttribute<XeestEstado, XeusuUsuar> peempCodigo;
    public static volatile CollectionAttribute<XeestEstado, XesisSistem> xesisSistemCollection;

}