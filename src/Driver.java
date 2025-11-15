import y2023.Q1RacingASCII;
import y2023.Q9StuffingRecipes;
import y2024.Q1ExploringAnts;
import y2024.Q2CarsAfield;
import y2024.Q3PrimeBirthYears;
import y2024.Q9FindingAntFood;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("What year?");
        int year = sc.nextInt();
        System.out.println("What problem number?");
        int num = sc.nextInt();

        runProblem(year, num);
    }

    private static void runProblem(int year, int num) {
        switch(year) {
            case 2023:
                switch(num) {
                    case 1:
                        Q1RacingASCII.solve();
                        break;
                    case 9:
                        Q9StuffingRecipes.solve();
                        break;
                }
                break;

            case 2024:
                switch(num) {
                    case 1:
                        Q1ExploringAnts.solve();
                        break;
                    case 2:
                        Q2CarsAfield.solve();
                        break;
                    case 3:
                        Q3PrimeBirthYears.solve();
                        break;
                    case 9:
                        Q9FindingAntFood.solve();
                        break;
                }
                break;
        }
    }
}
