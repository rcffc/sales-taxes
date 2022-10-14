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
    public Product parse(String input) {
        String[] splitResult = input.split(" at ");
        boolean imported = splitResult[0].contains("imported");

        ProductFactory factory;
        if (splitResult[0].contains("book")){
            factory = new BookProductFactory();
        } else if (splitResult[0].contains("chocolate")){
            factory = new FoodProductFactory();
        } else if (splitResult[0].contains("pills")) {
            factory = new MedicineProductFactory();
        } else {
            factory = new MiscProductFactory();
        }
        return factory.makeProduct(Double.parseDouble(splitResult[1]), imported);
    }   
}
