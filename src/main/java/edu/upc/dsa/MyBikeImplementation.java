package edu.upc.dsa;

import java.util.*;

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
        this.users.put(idUser, new User(idUser,name,surname));
        log.info(users.size());
        log.info("User added:" + this.users.get(idUser));


    }

    @Override
    public void addStation(String idStation, String description, int max, double lat, double lon) {
        if (numStations!= S){
            this.stations[this.numStations++] = new Station(idStation,description,max,lat,lon);
            log.info("Station added: " + this.stations[numStations - 1]);
        }else {
            log.info("Lleno");
        }

    }

    @Override
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException {
    Bike bike = new Bike(idBike, description, kms, idStation);
    int Stationpos = this.getStationbyId(idStation);
    log.info("Station found");
    if (this.stations[Stationpos].getBikes().size() < this.stations[Stationpos].getMax()){
        this.stations[Stationpos].addBike(bike);
        log.info("bici añadida");

    }else {
        log.info("estación llena");
        throw new StationFullException();
    }
    }

    @Override
    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {
        int stationPos = this.getStationbyId(idStation);
        log.info("Station encontrada");
        LinkedList<Bike> bikes = this.stations[stationPos].getBikes();
        log.info("Lista de bicis en orden:" + bikes);
        Collection.sort(bikes, new Comparator<Bike>()){
            public int compare(Bike o1, Bike o2){
                return (int) (o1.getKm() - o2.getKm());
            }
        };
        log.info("Lista de bicis en orden:" + bikes);
        return bikes;
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
