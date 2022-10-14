package salestax;

import java.util.ArrayList;
import java.util.List;

import salestax.Products.Product;
import salestax.utils.Parser;

public class Process {

    /**
     * 
     * Processes the whole pipeline from reading the input lines of the purchase 
     * and returning a corresponding output with the costs of the purchase
     * as well as printing the results.
     * 
     * @param input The contents of the purchase
     * @return Receipt Output
     */
    public List<String> processInput(String[] input) {
        Parser parser = new Parser();
        Receipt receipt = new Receipt();
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < input.length; i++) {
            products.add(parser.parse(input[i]));
        }
        receipt.setProducts(products);
        receipt.calculateCosts();
        receipt.printReceipt();
        return receipt.getOutput();
    }
}
