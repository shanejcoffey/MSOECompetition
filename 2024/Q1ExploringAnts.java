import java.util.Scanner;

public class Q1ExploringAnts {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int h = scan.nextInt();
        int w = scan.nextInt();
        int l = scan.nextInt();
        double total = Math.sqrt(h*h + w*w) + Math.sqrt(h*h + l*l) + Math.sqrt(w*w + l*l);
        System.out.println(total);
    }
}
