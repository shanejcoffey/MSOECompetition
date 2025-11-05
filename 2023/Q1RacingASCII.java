import java.util.*;

public class Q1RacingASCII {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String l1 = scan.nextLine();
        String l2 = scan.nextLine();

        boolean firstCrashed = l1.charAt(l1.length() - 1) == '.';
        boolean secondCrashed = l2.charAt(l2.length() - 1) == '.';

        if(firstCrashed && secondCrashed) {
            System.out.println("scratch");
        } else if(firstCrashed) {
            System.out.println(l2.substring(l2.length() - 3));
        } else if(secondCrashed) {
            System.out.println(l1.substring(l1.length() - 3));
        } else {
            int indexOfBus = Math.max(l1.indexOf("bus"), l2.indexOf("bus"));
            int indexOfCar = Math.max(l1.indexOf("car"), l2.indexOf("car"));
            if(indexOfBus > indexOfCar) {
                System.out.println("bus");
            } else if(indexOfCar > indexOfBus) {
                System.out.println("car");
            } else {
                System.out.println("tie");
            }
        }
    }
}
