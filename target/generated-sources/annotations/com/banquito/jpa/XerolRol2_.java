package com.banquito.jpa;

import com.banquito.jpa.XeperPerfil2;
import com.banquito.jpa.XerolRol2PK;
import com.banquito.jpa.XeusuUsuar;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T14:59:44")
@StaticMetamodel(XerolRol2.class)
public class XerolRol2_ { 

    public static volatile SingularAttribute<XerolRol2, XeusuUsuar> xeusuUsuar;
    public static volatile SingularAttribute<XerolRol2, String> xerolConsul;
    public static volatile SingularAttribute<XerolRol2, XerolRol2PK> xerolRol2PK;
    public static volatile SingularAttribute<XerolRol2, String> xerolInserc;
    public static volatile CollectionAttribute<XerolRol2, XeperPerfil2> xeperPerfil2Collection;
    public static volatile SingularAttribute<XerolRol2, String> xerolElimin;
    public static volatile SingularAttribute<XerolRol2, String> xerolActual;

}