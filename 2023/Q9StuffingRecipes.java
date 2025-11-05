import java.io.*;
import java.util.*;

public class Q9StuffingRecipes {
    public static void main(String[] args) {
        Scanner scan = null;
        File file = new File("Breakfast.txt");
        try {
            scan = new Scanner(file);
        } catch(FileNotFoundException e) {
            System.out.println("file not found");
            return;
        }

        HashMap<String, HashMap<String, Double>> recipes = new HashMap<>();

        HashMap<String, Double> pantry = new HashMap<>();

        String newRecipeName = scan.nextLine();

        while(scan.hasNextLine()) {
            String recipeName = newRecipeName;
            if(recipeName.equals("END")) {
                break;
            }
            recipeName = recipeName.substring(0, recipeName.length() - 1);

            HashMap<String, Double> currMap = new HashMap<>();
            while(scan.hasNextLine()) {
                String[] itemParts = scan.nextLine().trim().split(" ");

                System.out.println("Item parts");
                for(String str : itemParts) {
                    System.out.println(str);
                }

                if(itemParts.length == 1) {
                    newRecipeName = itemParts[0];
                    break;
                }

                String itemName = itemParts[itemParts.length - 1];
                Double itemQuantity = Double.parseDouble(itemParts[0]);

                System.out.println("adding " + itemQuantity + " " + itemName);
                currMap.put(itemName, itemQuantity);
            }

            recipes.put(recipeName, currMap);
        }

        while(scan.hasNextLine()) {
            String[] itemParts = scan.nextLine().split(" ");

            String itemName = itemParts[0];
            Double itemQuantity = Double.parseDouble(itemParts[1]);

            pantry.put(itemName, itemQuantity);
        }

        System.out.println("pantry:----------------------");
        for(String key : pantry.keySet()) {
            System.out.println(key + ", " + pantry.get(key));
        }

        System.out.println("recipes-------------------");
        for(String str : recipes.keySet()) {
            System.out.println(str + ":");
            for(String key : recipes.get(str).keySet()) {
                System.out.println(key + ", " + recipes.get(str).get(key));
            }
        }
    }
}
