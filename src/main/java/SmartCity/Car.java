package SmartCity;

import java.util.*;

import IA.Comparticion.*;


/**
 * @author joan
 * Class that contains the attributes and methods related to cars
 */
public class Car {

    //-----Attributes
    private Pos pos;
    private Pos destination;
    private ArrayList<Usuario> passengers;    //List of next positions

    //Traffic speed: 30km/h -> 500m/min
    //100m/square at 500m/min -> 0.2min/square -> 12 seconds to travel 1 square
    private int remTime;    //In seconds

    //-----Constructors:

    //Constructor with parameters
    public Car(Pos ini, Pos dest, Usuario driver) {
        this.pos = ini;
        this.destination = dest;
        this.remTime = 3600;
        this.passengers.add(driver);    //The driver
    }

    //Constructor with only position
    public Car(Pos ini, Pos dest) {
        this.pos = ini;
        this.destination = dest;
        this.remTime = 3600;
        this.passengers = new ArrayList<>();
    }

    //-----Getters:
    public int getRemTime() { return this.remTime; }
    public Pos getPos() { return this.pos; }
    public Pos getDest() {return this.destination; }
    public int getPassengers() { return this.passengers.size(); }
    public ArrayList<Usuario> getUsers() {return this.passengers; }

    //-----Operations:

    //Checks if the car reached destination
    public boolean hasFinished() { return this.pos.equals(this.destination);}

    //Checks if the car is empty
    public boolean isEmpty() { return this.passengers.isEmpty();}

    //Moves the car to a position, using time
    public void moveTo(Pos dest) {
        //Remaining time calculus (12 seconds per square)
        this.remTime -= 12 * pos.distance(dest);
        this.pos = dest;
    }

    //Takes a passenger
    public void takeUser(Usuario pass) { this.passengers.add(pass); }

    //Leaves a passenger
    public void leaveUser(Usuario pass) { this.passengers.remove(pass); }

    //Returns the sum of time to drive all passengers to their destination
    public int getTotalTime(){
        int total = 0;
        Pos aux = new Pos(passengers.get(0).getCoordOrigenX(), passengers.get(0).getCoordOrigenY());

        for (int i = 0; i < passengers.size(); ++i) {
            Pos dest = new Pos(passengers.get(i).getCoordDestinoX(), passengers.get(i).getCoordDestinoY());
            total += 12 * aux.distance(dest);
            aux = dest;
        }

        return total;
    }

}