/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.banquito.dao;

import com.banquito.jpa.XeusuUsuar;
import com.banquito.jpa.Contrasena;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author DIEGOPC
 */
public class UsuarioDao {
    public XeusuUsuar validarUsuario(String usuario, String password){
        EntityManagerFactory factory=
                Persistence.createEntityManagerFactory("prueba_P1_BanQuitoPU");
        EntityManager manager=factory.createEntityManager();
        String query="Select x FROM XeusuUsuar x WHERE x.xeusuPassword=?1 AND x.XeusuPiefirma=?2";
        //String query="Select u FROM Xeusu_Usuar WHERE u.XEUSU_PFIRM=?1";
        TypedQuery<XeusuUsuar> usu=
                manager.createQuery(query, XeusuUsuar.class);
        usu.setParameter(1, password);
        usu.setParameter(2, usuario);
        XeusuUsuar lista=null;
        //System.out.println("la lista es: "+usu.getSingleResult());
        try{
            lista=usu.getSingleResult();
            System.out.println("la lista es: "+lista.getXeusuPassword());
        }
        catch(Exception e)
        {
            System.out.println("d");
        }
        return lista;
    }
    
    public void crearUsuario(String codigo, String pass, String usu, Date fechaCrea, Date fechaCam, String
            codEmp, String codEst){
        try{
            System.out.println("fecha de creacion: "+fechaCrea);
            EntityManagerFactory factory=
                    Persistence.createEntityManagerFactory("prueba_P1_BanQuitoPU");
            EntityManager manager, manager1;
            manager=factory.createEntityManager();
            manager.createNativeQuery("INSERT INTO XeusuUsuar (PeempCodig, XeusuPassword,XeusuPiefirma, XeusuFecCrea,"
                    + "XeusuFecUltimoCambio) VALUES (?,?,?,?,?)")
                    .setParameter(1, codigo)
                    .setParameter(2, pass)
                    .setParameter(3, usu)
                    .setParameter(4, fechaCrea)
                    .setParameter(5, fechaCam)
                    .executeUpdate();
            manager1=factory.createEntityManager();
            manager1.createNativeQuery("INSERT INTO Contrasena (Contrasena_Actual, PeempCodig,Contrasena_Pasada" +
                    ") VALUES (?,?,?)")
                    .setParameter(1,pass)
                    .setParameter(2,pass)
                    .setParameter(3,codigo)
                    .executeUpdate();
        }
        catch(Exception e){
            System.out.println("error crear usuario");
                    }
    }
}
