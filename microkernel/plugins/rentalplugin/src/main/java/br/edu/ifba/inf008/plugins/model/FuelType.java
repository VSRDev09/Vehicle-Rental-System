package br.edu.ifba.inf008.plugins.model;

public enum FuelType {
    GASOLINE,
    DIESEL,
    ELECTRIC,
    HYBRID,
    CNG;

    public static FuelType fromString(String value) {
        return FuelType.valueOf(value.toUpperCase());
    }
}
