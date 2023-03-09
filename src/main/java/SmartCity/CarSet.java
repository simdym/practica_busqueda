package SmartCity;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class CarSet {

    //-----Attributes
    private Set<Car> CS;

    //-----Constructors

    //Empty constructor
    public CarSet(){
        this.CS = new Set<new Car>;
    }

    //1 to 1 constructor

    public void fillRand_CarSet(int n){
        for (int i = 0; i < n; ++i){
            int x0, y0, x1, y1;
            x0 = getRandomNumber(0, 100);
            y0 = getRandomNumber(0, 100);
            x1 = getRandomNumber(0, 100);
            y1 = getRandomNumber(0, 100);
            Car aux = new Car(new Pos(x0,y0), new Pos(x1,y1));
            this.CS.add(aux);
        }
    }

    public void print_CarSet(){
        for (Car c : CS) {
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
