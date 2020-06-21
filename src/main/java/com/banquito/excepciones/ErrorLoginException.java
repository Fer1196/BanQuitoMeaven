/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.banquito.excepciones;

import org.omg.CORBA.UserException;

/**
 *
 * @author token
 */
public class ErrorLoginException extends UserException{

    public ErrorLoginException(String mensaje) {
        super(mensaje);
    }
    
}
