package SmartCity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner n = new Scanner(System.in);

        //Inicialize CarSet with n random Cars
        CarSet CS = new CarSet();
        CS.fillRand_CarSet(n.nextInt());


    }
}