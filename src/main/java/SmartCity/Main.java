package SmartCity;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //Inicialize CarSet with n random Cars
        CarSet CS = new CarSet();
        Scanner n = new Scanner(System.in);
        System.out.println("How many people do you to organize?");
        Set<int[]> poblation = getPoblationN(n.nextInt());
        System.out.println("How many drivers do you have?");
        CS.organize(poblation, n.nextInt());
        CS.execute();
        CS.print_CarSet();
    }

    private static Set<int[]> getPoblationN(int n){
        Set<int[]> poblation = new HashSet<>();
        for (int i = 0; i < n; ++i){
            int[] p = new int[4];
            for (int j = 0; j < n; ++j){
                p[j] = getRandomNumber(0, 100);
            }
            poblation.add(p);
        }
        return poblation;
    }

    private static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

}