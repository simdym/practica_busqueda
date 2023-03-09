package SmartCity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class CarSet {

    //-----Attributes
    private Set<Car> CS;

    //-----Constructors

    //Empty constructor
    public CarSet(){
        this.CS = new HashSet<>();
    }

    //1 to 1 constructor

    public void organize(Set<int[]> poblation, int nDrivers){
        if (poblation.size() == nDrivers) {
            for (int[] p : poblation) {
                Car aux = new Car(new Pos(p[0], p[1]), new Pos(p[2], p[3]));
                this.CS.add(aux);
            }
        }
    }

    public void execute(){
        for (Car c : this.CS){
            c.moveTo(c.getDest());
        }
    }

    public void print_CarSet(){
        for (Car c : this.CS) {
            System.out.println(c.getPos());
            System.out.println(c.getDest());
            System.out.println(c.getRemTime());
            System.out.println(c.getPassengers());
        }
    }

    private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}
