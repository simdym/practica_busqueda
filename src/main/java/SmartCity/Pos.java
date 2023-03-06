package SmartCity;

import static java.lang.Math.abs;

public class Pos {

    //-----Attributes
    private int x;
    private int y;

    //-----Constructors:

    //Empty constructor
    public Pos(){
        this.x = 0;
        this.y = 0;
    }

    //Constructor with parameters
    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //-----Getters:
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }

    //-----Setters:
    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }
    public void setPos(int x, int y) {this.x = x; this.y = y;}

    //-----Operators:

    //Checks if a position is equal to this instance
    public boolean equals(Pos p) { return this.x == p.getX() && this.y == p.getY();}

    //Tells the distance in units between this position and another position "p"
    public int distance(Pos p) {
        return abs(p.getX() - this.x) + abs(p.getY() - this.y);
    }
}
