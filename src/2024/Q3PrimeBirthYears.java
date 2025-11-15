import java.util.Scanner;

public class Q3PrimeBirthYears {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.println("What is the difference between the parent's age and the child's age?");
        int gap = scan.nextInt();
        
        int numGifts = 0;
        int lastGift = -1;
        
        for(int i = 2; i < 100 - gap; i++) {
            if(isPrime(i) && isPrime(i + gap)) {
                numGifts++;
                lastGift = i;
            }
        }
        
        if(numGifts == 0) {
            System.out.println("A " + gap + " year difference gives 0 gifts.");
        } else {
            System.out.println("A " + gap + " year difference gives " + numGifts + " gifts with the last at " + lastGift + " and " + (lastGift + gap) + ".");
        }
    }
    
    private static boolean isPrime(int num) {
        for(double i = Math.floor(Math.sqrt(num)); i > 1; i--) {
            if((num / i) % 1 == 0) {
                return false;
            }
        }
        return true;
    }
}
