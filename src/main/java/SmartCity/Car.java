package SmartCity;

import java.util.*;
import static java.lang.Math.abs;

/**
 * @author joan
 * Class that contains the attributes and methods related to cars
 */
public class Car {

    //-----Attributes
    private Pos pos;
    private Pos destination;
    private Queue<Pos> instructions;    //List of next positions

    //Traffic speed: 30km/h -> 500m/min
    //100m/square at 500m/min -> 0.2min/square -> 12 seconds to travel 1 square
    private int remTime;    //In seconds

    private int passengers;     //Number of people in the car

    //-----Constructors:

    //Empty constructor
    public Car(){
        this.pos.setPos(0,0);
        this.destination.setPos(0,0);
        this.remTime = 3600;
        this.passengers = 1;    //The driver
    }

    //Constructor with parameters
    public Car(Pos ini, Pos dest) {
        this.pos = ini;
        this.destination = dest;
        this.remTime = 3600;
        this.passengers = 1;    //The driver
    }

    //-----Getters:
    public int getRemTime() { return this.remTime; }
    public Pos getPos() { return this.pos; }
    public Pos getDest() {return this.destination; }
    public int getPassengers() { return this.passengers; }

    //-----Operations:

    //Checks if the car reached destination
    public boolean hasFinished() { return this.pos.equals(this.destination);}

    //Adds a move to the instructions
    public void addMove(Pos p) {
        this.instructions.add(p);
    }

    //Moves the car to a position, using time
    public void moveTo(Pos dest) {
        //Remaining time calculus (12 seconds per square)
        this.remTime -= 12 * pos.distance(dest);
        this.pos = dest;
    }

    //Moves the car to the next position of the instructions, using time
    public void nextMove() {
        Pos dest = instructions.poll();
        this.moveTo(dest);
    }

    //Takes a passenger
    public void takeUser() { ++this.passengers; }

    //Leaves a passenger
    public void leaveUser() { --this.passengers; }

    //Move and Take user
    public void moveNTake(Pos dest) {
        this.moveTo(dest);
        this.takeUser();
    }

    //Move and leave user
    public void moveNLeave(Pos dest) {
        this.moveTo(dest);
        this.leaveUser();
    }

}
