package salestax.utils;

import salestax.Products.BookProductFactory;
import salestax.Products.FoodProductFactory;
import salestax.Products.MedicineProductFactory;
import salestax.Products.MiscProductFactory;
import salestax.Products.Product;
import salestax.Products.ProductFactory;
/**
 * Utitlity class for parsing an String input and instantiating the respective product.
 */
public class Parser {
    private final String IMPORTED = "imported";

    /**
     * Parses the contents of the input and creates a product for each line.
     * 
     * @param input
     * @return
     */
    public Product parse(String input) {
        String[] splitResult = input.split(" at ");
        if (splitResult.length != 2) {
            throw new IllegalArgumentException("Input line does not contain word 'at'");
        }
        String description = splitResult[0];
        boolean imported = false;
        int index = description.indexOf(IMPORTED);
        if (index > 0) {
            imported = true;
            description = parseDescription(description, index);
        }

        ProductFactory factory;
        if (description.contains("book")) {
            factory = new BookProductFactory();
        } else if (description.contains("chocolate")) {
            factory = new FoodProductFactory();
        } else if (description.contains("pills")) {
            factory = new MedicineProductFactory();
        } else {
            factory = new MiscProductFactory();
        }
        return factory.makeProduct(Double.parseDouble(splitResult[1]), imported, description);
    }
    
    /**
     * Re-arranges the keyword <i>imported</i> within the description
     * 
     * @param aString The description
     * @param index Start of the word <i>imported</i>
     * @return re-arranged description
     */
    public String parseDescription(String aString, int index) {
        return aString.substring(0, 2)
             + aString.substring(index, index + IMPORTED.length() + 1)
             + aString.substring(2, index)
             + aString.substring(index + IMPORTED.length() + 1, aString.length());
    }
}
