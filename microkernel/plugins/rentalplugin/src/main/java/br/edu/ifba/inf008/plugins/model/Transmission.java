package br.edu.ifba.inf008.plugins.model;

public enum Transmission {
    MANUAL,
    AUTOMATIC;

    public static Transmission fromString(String value) {
        return Transmission.valueOf(value.toUpperCase());
    }
}
