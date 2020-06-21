package com.banquito.jpa;

import com.banquito.jpa.XeopeOperfi;
import com.banquito.jpa.XesisSistem;
import com.banquito.jpa.XevenVentan;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-06-21T14:59:44")
@StaticMetamodel(XeopcOpcion.class)
public class XeopcOpcion_ { 

    public static volatile SingularAttribute<XeopcOpcion, XesisSistem> xesisCodsis;
    public static volatile CollectionAttribute<XeopcOpcion, XevenVentan> xevenVentanCollection;
    public static volatile SingularAttribute<XeopcOpcion, String> xeopcCodopc;
    public static volatile SingularAttribute<XeopcOpcion, String> xeopcDescri;
    public static volatile CollectionAttribute<XeopcOpcion, XeopeOperfi> xeopeOperfiCollection;

}