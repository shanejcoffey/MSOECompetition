package y2024;
import java.util.Scanner;

public class Q2CarsAfield {
    public static void solve() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the field of cars");
        String input = scan.nextLine();
        int numCars = 0;
        for(int i = 0; i < input.length() - 2; i++) {
            if((input.charAt(i) == 'o' && input.charAt(i + 2) == 'o') || (input.charAt(i) == 'O' && input.charAt(i + 2) == 'O')) {
                numCars++;
                i += 2;
            }
        }
        System.out.println(numCars);
    }
}
