package SmartCity;

import java.util.ArrayList;
import java.util.HashSet;

import IA.Comparticion.Usuarios;
import IA.Comparticion.Usuario;

public class CarSet {

    //-----Attributes
    private ArrayList<Car> instructions;
    private ArrayList<Integer> distances;
    private Usuarios users;

    //-----Constructors

    //Empty constructor
    public CarSet(Usuarios users){
        this.instructions = new ArrayList<>();
        this.distances = new ArrayList<>();
        this.users = users;
    }

    //1 to 1 constructor

    /*public void organize(Set<int[]> poblation, int nDrivers){
        if (poblation.size() == nDrivers) {
            for (int[] p : poblation) {
                Car aux = new Car(new Pos(p[0], p[1]), new Pos(p[2], p[3]));
                this.CS.add(aux);
            }
        }
    }*/

    /*public void execute(){
        for (Car c : this.CS){
            c.moveTo(c.getDest());
        }
    }*/

    /*public void print_CarSet(){
        for (Car c : this.CS) {
            System.out.println(c.getPos());
            System.out.println(c.getDest());
            System.out.println(c.getRemTime());
            System.out.println(c.getPassengers());
        }
    }*/

    /*private int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }*/

    public void generateInitSol() {
        ArrayList<Car> cars = new ArrayList<>(users.size());

        for (int i = 0; i<users.size(); ++i) {
            Car passengers_car = new Car();
            Usuario u = users.get(i);
            if (u.isConductor()) {
                passengers_car.setDriver(u);
                cars.add(passengers_car);
            }
        }

        int count = 0;
        for (int i = 0; i<users.size(); ++i) {
            
            Usuario u = users.get(i);
            if (!u.isConductor()) {
                cars.get(count%cars.size()).setPassenger(u);
                ++count;
            }
        }

        distances.clear();
        for (Car car : cars) {
            distances.add(distance(car));
        }
        this.instructions = cars;
    }

    public int distance(Car car) {   //Calculate the total distance of a car with its passengers and driver
        HashSet<Usuario> aux = new HashSet<Usuario>();
        
        Usuario driver = car.getDriver();
        Pos previouspos = new Pos (driver.getCoordOrigenX(), driver.getCoordOrigenY());
        
    
        Pos targetpos;
        int distance = 0;

        aux.add(car.getDriver());                                        //We start the hashset with the driver, whose we got the coordenates already

        for (int i = 1; i<car.getPassengers(); ++i) {
        	Usuario passenger = car.get_i_passenger(i); 
            if (aux.contains(passenger)) {                                 //We check if we got to the origin coordinates of the user (which means we got him in the car already)    
            	targetpos = new Pos (passenger.getCoordOrigenX(), passenger.getCoordOrigenY());         //if we did, we get his job coordinates
            }
            else {
            	targetpos = new Pos (passenger.getCoordOrigenX(), passenger.getCoordOrigenY());
            	
                //if we did not, we get his origin coordinates, which means we go get him
                aux.add(passenger);                                        //we add him in to the checked set
            }
            distance += calculate_distance(previouspos, targetpos);
            previouspos = targetpos;
        }
        return distance;
    }

    public int calculate_distance(Pos previouspos, Pos targetpos) {
        return Math.abs(targetpos.getX()-previouspos.getX())+Math.abs(targetpos.getY()-previouspos.getY());
    }

}
