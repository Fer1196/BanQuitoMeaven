package com.banquito.jpa;

import com.banquito.jpa.Contrasena;
import com.banquito.jpa.PeempEmple;
import com.banquito.jpa.XeestEstado;
import com.banquito.jpa.XerolRol2;
import com.banquito.jpa.XesisSistem;
import com.banquito.jpa.XeuxpUsuper;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T14:59:44")
@StaticMetamodel(XeusuUsuar.class)
public class XeusuUsuar_ { 

    public static volatile SingularAttribute<XeusuUsuar, String> xeusuPiefirma;
    public static volatile SingularAttribute<XeusuUsuar, PeempEmple> peempEmple;
    public static volatile CollectionAttribute<XeusuUsuar, XeuxpUsuper> xeuxpUsuperCollection;
    public static volatile SingularAttribute<XeusuUsuar, Date> xeusuFecUltimoCambio;
    public static volatile CollectionAttribute<XeusuUsuar, Contrasena> contrasenaCollection;
    public static volatile SingularAttribute<XeusuUsuar, String> xeusuPassword;
    public static volatile SingularAttribute<XeusuUsuar, Date> xeusuFecCrea;
    public static volatile CollectionAttribute<XeusuUsuar, XerolRol2> xerolRol2Collection;
    public static volatile SingularAttribute<XeusuUsuar, String> peempCodigo;
    public static volatile CollectionAttribute<XeusuUsuar, XeestEstado> xeestEstadoCollection1;
    public static volatile CollectionAttribute<XeusuUsuar, XesisSistem> xesisSistemCollection;
    public static volatile CollectionAttribute<XeusuUsuar, XeestEstado> xeestEstadoCollection;

}