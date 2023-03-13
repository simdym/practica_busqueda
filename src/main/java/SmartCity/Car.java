package SmartCity;

import java.lang.reflect.Array;
import java.util.*;
import static java.lang.Math.abs;

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

    //Empty constructor
    public Car(){
        this.pos.setPos(0,0);
        this.destination.setPos(0,0);
        this.remTime = 3600;
        this.passengers.add(new Usuario());    //The driver
    }

    //Constructor with parameters
    public Car(Pos ini, Pos dest, Usuario driver) {
        this.pos = ini;
        this.destination = dest;
        this.remTime = 3600;
        this.passengers.add(driver);    //The driver
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

}