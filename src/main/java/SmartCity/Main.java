package SmartCity;

import java.util.Scanner;
import IA.Comparticion.Usuarios;

public class Main {
    public static void main(String[] args) {

        //Ask how many users are in the app, how many of them are drivers and the seed of the rng
        Scanner n = new Scanner(System.in);
        System.out.println("How many people do you to organize?");
        int n_users = n.nextInt();
        System.out.println("How many drivers do you have?");
        int n_cond = n.nextInt();
        System.out.println("Introduce una seed");
        int seed = n.nextInt();
        n.close();
        //I think that the class Usuarios, takes the seed and randomizes every position of the users, so its not necessary to make it ourselves
        Usuarios users = new Usuarios(n_users, n_cond, seed);
        CarSet CS = new CarSet(users);
        CS.generateInitSol();
        //CS.print_CarSet();
    }

    /*private static Set<int[]> getPoblationN(int n){
        Set<int[]> poblation = new HashSet<>();
        for (int i = 0; i < n; ++i){
            int[] p = new int[4];
            for (int j = 0; j < 4; ++j){
                p[j] = getRandomNumber(0, 100);
            }
            poblation.add(p);
        }
        return poblation;
    }
    
    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }*/

}