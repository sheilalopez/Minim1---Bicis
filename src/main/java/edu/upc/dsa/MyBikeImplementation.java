package edu.upc.dsa;

import org.apache.log4j.Logger;

import java.util.*;

public class MyBikeImplementation implements MyBike {


    private final static Logger log = Logger.getLogger(MyBikeImplementation.class.getName());
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
            this.stations[this.numStations] = new Station(idStation,description,max,lat,lon);
            this.numStations++;
            log.info("Station added: " + Arrays.toString(this.stations));
    }

    @Override
    public void addBike(String idBike, String description, double kms, String idStation) throws StationFullException, StationNotFoundException {
    Bike bike = new Bike(idBike, description, kms, idStation);
    Station station = null;
    for (int i =0; i<numStations; i++){
        if (idStation.equals(this.stations[i].getIdStation())){
            log.info("Station inside if: " + this.stations[i]);
            log.info("Current bikes: " +  this.stations[i].getBikes());
            station = this.stations[i];
            log.info(station);
        }
    }

    log.info("Station: " + station);

    if (station != null) {
        station.addBike(bike);
    }

    }

    @Override
    public List<Bike> bikesByStationOrderByKms(String idStation) throws StationNotFoundException {
        Station station = new Station();
        for (int i= 0; i<numStations; i++ ){
            if (idStation.equals(this.stations[i].getIdStation())){
                station = this.stations[i];

            }else {
                log.info("Station not found");
            }
        }
        log.info("Station encontrada");
        List<Bike> bikes = station.getBikes();
        log.info("Lista de bicis desordenadas:" + bikes);
        Collections.sort(bikes, new Comparator<Bike>(){
            @Override
            public int compare(Bike o1, Bike o2){
                return (int) (o1.getKm() - o2.getKm());
            }
        });

        log.info("Lista de bicis en orden:" + bikes);
        return bikes;
    }

    @Override
    public Bike getBike(String stationId, String userId) throws UserNotFoundException, StationNotFoundException {
        int stationPos = this.getStationById(stationId);
        log.info("station encontrada");
        Bike bike = this.stations[stationPos].getBikes().removeFirst();
        User user = this.users.get(userId);
        if (user != null){
            log.info("Primera bici:" + bike);
            user.addBike(bike);
            return bike;
        }else {
            log.info("bici no encontrada");

            throw new UserNotFoundException();
        }

    }

    @Override
    public List<Bike> bikesByUser(String userId) throws UserNotFoundException {
        User user = this.users.get(userId);
        if(user != null){
            LinkedList<Bike> bikes = user.getBikes();
            log.info("Lista de bicis:" + userId + ":" + bikes);
            return bikes;
        }else {
            log.info("Bici no encontrada");
            throw new UserNotFoundException ();

        }

    }

    @Override
    public int numUsers() {
        log.info("Numero de usuarios: " +this.users.size());
        return this.users.size();

    }

    @Override
    public int numStations() {
        log.info("Numero de estaciones:" + this.numStations);
        return this.numStations;

    }

    @Override
    public int numBikes(String idStation) throws StationNotFoundException {
        int stationPos = this.getStationById(idStation);
        log.info("Station found");
        log.info("Number of bikes: " + this.stations[stationPos].getBikes().size());
        return this.stations[stationPos].getBikes().size();

    }

    private int getStationById(String idStation) {
        return 0;
    }

    @Override
    public void clear() {
        instance = null;
        this.stations = null;
        this.users = null;
        log.info("Data cleared");
    }
}
