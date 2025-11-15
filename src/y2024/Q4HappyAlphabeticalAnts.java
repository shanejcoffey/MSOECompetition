package y2024;

import java.util.*;

public class Q4HappyAlphabeticalAnts {
    public static void solve() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the line");

        String lineOriginal = sc.nextLine();
        String line = lineOriginal.toLowerCase();

        int maxLength = 0;
        int maxStart = 0;
        int currLength = 0;
        int currStart = 0;
        char lastLetter = 0;

        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if(c < 'a' || c > 'z') {
                continue;
            }

            if(currLength == 0) {
                currStart = i;
                currLength = 1;
                lastLetter = c;
            } else if(c > lastLetter) {
                currLength++;
                lastLetter = c;
            } else {
                if(currLength > maxLength) {
                    maxLength = currLength;
                    maxStart = currStart;
                }
                currStart = i;
                currLength = 1;
                lastLetter = c;
            }
        }

        if (currLength > maxLength) {
            maxLength = currLength;
            maxStart = currStart;
        }

        String maxString = "";
        for(int i = maxStart; maxString.length() < maxLength; i++) {
            if(line.charAt(i) < 'a' || line.charAt(i) > 'z') {
                continue;
            }
            maxString += line.charAt(i);
        }

        System.out.println("Happiest: " + (maxString) + " starting at character " + (maxStart + 1));
    }
}
