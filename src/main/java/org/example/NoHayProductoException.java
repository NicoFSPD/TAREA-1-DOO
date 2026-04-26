package org.example;

public class NoHayProductoException extends Exception {
    public NoHayProductoException(String message) {
        super(message);
    }
}
