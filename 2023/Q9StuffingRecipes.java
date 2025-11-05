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

                if(itemParts.length == 1) {
                    newRecipeName = itemParts[0];
                    break;
                }

                String itemName = itemParts[itemParts.length - 1];
                Double itemQuantity = Double.parseDouble(itemParts[0]);

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

        while(true) {
            String foodToMake = "";
            double mostCalories = 0;
            int numToMake = 0;

            for(String name : recipes.keySet()) {
                int numCanMake = Integer.MAX_VALUE;

                HashMap<String, Double> recipe = recipes.get(name);

                for(String ingredient : recipes.get(name).keySet()) {
                    if(ingredient.equals("calories")) {
                        continue;
                    }

                    double numInPantry = pantry.getOrDefault(ingredient, 0.0);
                    double numNeeded = recipe.get(ingredient);

                    int mostCanMake = (int) (Math.floor(numInPantry / numNeeded));
                    numCanMake = Math.min(numCanMake, mostCanMake);
                }
                double numCalories = recipe.get("calories") * numCanMake;

                if(numCalories > mostCalories) {
                    mostCalories = numCalories;
                    foodToMake = name;
                    numToMake = numCanMake;
                }
            }

            if(numToMake == 0) {
                break;
            }

            System.out.println(foodToMake + ": " + numToMake + " servings for " + mostCalories + " calories");

            //remove ingredients
            for(String ingredient : recipes.get(foodToMake).keySet()) {
                if(ingredient.equals("calories")) {
                    continue;
                }
                double ingInPantry = pantry.get(ingredient);
                double amountInRecipe = recipes.get(foodToMake).get(ingredient);
                pantry.put(ingredient, pantry.get(ingredient) - recipes.get(foodToMake).get(ingredient) * numToMake);
            }
        }
    }
}
