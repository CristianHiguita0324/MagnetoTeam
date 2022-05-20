package com.daecheve.core.exception;

/**
 *
 * @author daecheve
 */
public class DnaMatrixSizeException extends Exception {

    public DnaMatrixSizeException() {
        super("La secuencia de ADN ingresada no es una matriz cuadrada NxN");
    }
}
