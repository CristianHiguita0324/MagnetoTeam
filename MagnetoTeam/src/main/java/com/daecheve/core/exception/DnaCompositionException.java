package com.daecheve.core.exception;

/**
 *
 * @author daecheve
 */
public class DnaCompositionException extends Exception {

    public DnaCompositionException() {
        super("La secuencia de ADN ingresada contiene caracteres no validos, "
                + "Valores admitidos (A,T,C,G)");
    }
}
