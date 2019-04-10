package edu.upc.dsa;

public class Bike {
    private String idBike;
    private String description;
    private double kms;
    private String idStation;

    public Bike(){

    }

    public Bike(String idBike, String description, double kms, String idStation) {
        this.idBike = idBike;
        this.description = description;
        this.kms = kms;
        this.idStation = idStation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKms() {
        return kms;
    }

    public void setKms(double kms) {
        this.kms = kms;
    }

    public String getIdStation() {
        return idStation;
    }

    public void setIdStation(String idStation) {
        this.idStation = idStation;
    }

    public String getId() {
        return idBike;
    }

    public double getKm() {
        return kms;
    }
}
