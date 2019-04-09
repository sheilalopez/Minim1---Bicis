package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;

public class MyBikeImplementation implements MyBike {
    //Singleton
    private static MyBikeImplementation instance;
    private int numStations;
    private Station[] stations;
    private HashMap<String,User> users;

    //contstructor privado
    private MyBikeImplementation () {
        this.numStations = 0;
        this.stations = new Station[S];
        this.users = new HashMap<>();
    }
    //metodo getInstance
    public static MyBike getInstance(){
        if (instance == null) instance = new MyBikeImplementation();
        return instance;
    }
    //acaba Singleton
    @Override
    public void addUser(String idUser, String name, String surname) {

    }

    @Override
    public void addStation(String idStation, String description, int max, double lat, double lon) {

    }

    @Override
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException {

    }

    @Override
    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {
        return null;
    }

    @Override
    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException {
        return null;
    }

    @Override
    public List<Bike> bikesByUser(String userId) throws UserNotFoundException {
        return null;
    }

    @Override
    public int numUsers() {
        return 0;
    }

    @Override
    public int numStations() {
        return 0;
    }

    @Override
    public int numBikes(String idStation) throws StationNotFoundException {
        return 0;
    }

    @Override
    public void clear() {

    }
}
