package misc;

import java.util.ArrayList;
import java.util.Arrays;

public class IngredientTagging {
    public static void main(String[] args) {
        String[] ingredients = {
            "1 tablespoon olive oil",
            "1/2 large onion, diced",
            "3 cloves garlic, minced",
            "2 bell peppers, diced",
            "1 / 4 teaspoon fresh cracked pepper",
            "2-4 large flour tortillas",
            "2 - 4 large flour tortillas",
            "1 (15.5 ounces) can kidney beans, drained and rinsed",
            "1 tablespoon olive oil",
            "1/2 large onion, diced", 
            "3 cloves garlic, minced",
            "2 bell peppers, diced",
            "1 cup cooked black beans",
            "1 cup cooked brown rice",
            "1 cup cooked corn",
            "1 teaspoon chili powder",
            "1 teaspoon cumin",
            "1 teaspoon oregano",
            "1/4 teaspoon salt",
            "1/4 teaspoon fresh cracked pepper",
            "2-4 large flour tortillas",
            "1 cup of pizza sauce",
            "2 cups of shredded mozzarella cheese",
            "1-2 cups of assorted toppings such as olives, bell peppers, onions, pepperoni, etc.",
            "1/2 lb short pasta",
            "3 tablespoons extra-virgin olive oil",
            "2 cloves garlic, minced",
            "1/4 teaspoon salt",
            "1/4 teaspoon freshly ground black pepper",
            "3 cups fresh spinach leaves, roughly chopped",
            "1 cup ricotta cheese",
            "1/2 cup grated Parmesan cheese",
            "2 tablespoons of cooking oil",
            "1 cup of long grain white rice",
            "1 chopped onion",
            "Half a teaspoon of ground turmeric",
            "1 diced bell pepper",
            "1 diced carrot",
            "2 beaten eggs",
            "One quarter teaspoon of white pepper",
            "Salt to taste",
            "2 tablespoons olive oil",
            "1 pound chicken breast, cut into strips",
            "1 onion, thinly sliced",
            "1 bell pepper, thinly sliced",
            "1 teaspoon chili powder",
            "1 teaspoon garlic powder",
            "1 teaspoon cumin",
            "1/2 teaspoon salt",
            "1/2 teaspoon pepper",
            "Flour or corn tortillas, for serving",
            "1/2 lb short pasta",
            "3 tablespoons extra-virgin olive oil",
            "2 cloves garlic, minced",
            "1/4 teaspoon salt",
            "1/4 teaspoon freshly ground black pepper",
            "3 cups fresh spinach leaves, roughly chopped",
            "1 cup ricotta cheese",
            "1/2 cup grated Parmesan cheese",
            "1 tablespoon olive oil",
            "2 cloves garlic, minced",
            "1 small onion, diced",
            "1 pound lean ground turkey",
            "1 (14.5 ounces) can diced tomatoes, undrained",
            "1 (8 ounces) can tomato sauce",
            "2 tablespoons chili powder",
            "1 teaspoon ground cumin",
            "1/4 teaspoon black pepper",
            "1/4 teaspoon salt",
            "1 (15.5 ounces) can kidney beans, drained and rinsed",
            "1 lb ground beef",
            "1/4 cup taco seasoning",
            "1/2 cup salsa",
            "2 cups macaroni noodles",
            "1 cup water",
            "1/2 cup canned black beans, drained and rinsed",
            "1/2 cup frozen corn",
            "1 cup shredded Mexican cheese blend",
            "Penne Pasta",
            "Pesto Sauce",
            "Kosher Salt",
            "Garlic",
            "1 cup cooked rice",
            "1/2 cup canned black beans, drained and rinsed",
            "3/4 cup frozen corn, thawed",
            "1/2 cup store bought salsa",
            "1/2 cup store bought guacamole",
            "1/4 cup shredded cheese",
            "1 pound spaghetti",
            "1/2 cup prepared or homemade pesto",
            "1 pound large shrimp, peeled and deveined",
            "Salt and freshly ground black pepper",
            "Extra-virgin olive oil",
            "2 cloves garlic, minced",
            "1/4 cup freshly grated Parmigiano-Reggiano cheese",
            "2 tablespoons freshly chopped Italian parsley leaves",
            "2 tablespoons olive oil",
            "1 pound chicken breast, cut into strips",
            "1 onion, thinly sliced",
            "1 bell pepper, thinly sliced",
            "1 teaspoon chili powder",
            "1 teaspoon garlic powder",
            "1 teaspoon cumin",
            "1/2 teaspoon salt",
            "1/2 teaspoon pepper",
            "Flour or corn tortillas, for serving",
            "Penne Pasta",
            "Pesto Sauce",
            "Kosher Salt",
            "Garlic",
            "3 eggs",
            "3 tbsp vegetable oil",
            "3 tbsp chopped onion",
            "3 tbsp chopped bell pepper",
            "1/4 tsp salt",
            "1/4 tsp black pepper"
        };

        for(String ingredient: ingredients) {
            ingredientTagging(ingredient);
        }
    }

    public static void ingredientTagging(String ingredient) {
        
        String[] ingredientArr = ingredient.split(" ");
        String amount = "";
        String measure = "";
        String name = "";
        String note = "";
        int prevIdx = -1;

        // first find amount, also look for "/" such as "1/4", "-" such as "1-2", "to" such as "1 to 2"
        // stopped when the next element in the array is neither a number nor one of the special symbol / words above

        // find amount
        for(int i = 0; i < ingredientArr.length; i++) {
            
            if(Character.isDigit(ingredientArr[i].charAt(0))) {
                amount += ingredientArr[i] + " ";
                prevIdx = i;
            } else if (ingredientArr[i].charAt(0) == '¼' || ingredientArr[i].charAt(0) == '½') {
                amount += ingredientArr[i].charAt(0) == '¼' ? "1/4 " : "1/2 ";
                prevIdx = i;
            } else if (
                ((ingredientArr[i].charAt(0) == '/' || ingredientArr[i].charAt(0) == '-') && ingredientArr[i].length() == 1) 
                || 
                ((ingredientArr[i].charAt(0) == '/' || ingredientArr[i].charAt(0) == '-') && Character.isDigit(ingredientArr[i].charAt(1)))
                ) {
                amount += ingredientArr[i];
                prevIdx = i;
            } else if(ingredientArr[i].charAt(0) == '(') {
                // starting searching for closing parenthesis and add them to note variable
                note += ingredientArr[i] + " ";
                if(ingredientArr[i].charAt(ingredientArr[i].length()-1) == ')') {
                    prevIdx = i;
                } else {
                    for(int j = i+1; j < ingredientArr.length; j++ ) {
                        note += ingredientArr[j] + " ";
                        if(ingredientArr[j].charAt(ingredientArr[j].length()-1) == ')') {
                            i = j;
                            prevIdx = i;
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }

        // find measurement
        String measurement = measureConversion(ingredientArr[prevIdx + 1]);
        if(measurement != "") {
            String[] measureArr = measurement.split(" ");
            if(measureArr.length == 1) {
                measure = measurement;
            } else {
                measure = measureArr[0];
                note += measureArr[1];
            }
            prevIdx++;
        } else {
            measure = "whole";
        }
       
        for(int i = prevIdx+1; i < ingredientArr.length; i++) {
            if(ingredientArr[i].charAt(0) == '(') {
                // starting searching for closing parenthesis and add them to note variable
                note += ingredientArr[i] + " ";
                if(ingredientArr[i].charAt(ingredientArr[i].length()-1) == ')') {
                    continue;
                } else {
                    for(int j = i+1; j < ingredientArr.length; j++ ) {
                        note += ingredientArr[j] + " ";
                        if(ingredientArr[j].charAt(ingredientArr[j].length()-1) == ')') {
                            i = j;
                            prevIdx = i;
                            break;
                        }
                    }
                }
            } else if(!ingredientArr[i].toLowerCase().equals("of")){
                name += ingredientArr[i] + " ";    
            }
        }

        System.out.println();
        System.out.println("Name: " + name + ", Amount: " + amount + ", Measure: " + measure + ", Note: " + note + ", Index: " + prevIdx);
        // System.out.println("Amount: " + amount);
        // System.out.println("Measure: " + measure);System.out.println("Note: " + note);
        // System.out.println("Index: " + prevIdx);
    }

    private static String measureConversion(String measure) {
        // removing plural
        measure = measure.charAt(measure.length()-1) == 's' ? measure.substring(0, measure.length() - 1) : measure;
        measure = measure.toLowerCase();

        
        // tsp, tbsp, lb, oz
        String[] measureArr = {"clove", "slice", "dash", "pinch", "drop", "can", "jar", "cup"};
        ArrayList<String> measureList = new ArrayList<>(Arrays.asList(measureArr));

        switch(measure) {
            case "tsp" :
            case "teaspoon" : 
                return "teaspoon";
            case "tbsp" :
            case "tablespoon" :
                return "tablespoon";
            case "lb" :
            case "pound" :
                return "pound";
            case "oz" :
            case "ounce" :
                return "ounce";
            case "small" :
            case "medium" :
            case "large" :
                return "whole " + measure;
            case "qt" :
            case "quart" :
                return "quart";
            case "pt" :
            case "pint" :
                return "pint";
            default:
                if(measureList.contains(measure)) {
                    return measure;
                }
                return "";

        }
    }
}
