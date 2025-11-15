import java.util.Scanner;

public class Q2CarsAfield {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
