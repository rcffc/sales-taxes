package salestax;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import salestax.Products.Product;
import salestax.Tax.ITaxStrategy;
import salestax.Tax.TaxStrategy;

public class Receipt {
    
    private double totalTax;
    private double totalCostAfterTax;
    private List<String> output;

    private Collection<Product> products;
    private ITaxStrategy strategy = new TaxStrategy();
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public Receipt() {
        this.totalTax = 0;
        this.totalCostAfterTax = 0;
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double aTotalTax) {
        this.totalTax = aTotalTax;
    }

    public double getTotalCostAfterTax() {
        return totalCostAfterTax;
    }

    public void setTotalCostAfterTax(double aTotalCostAfterTax) {
        this.totalCostAfterTax = aTotalCostAfterTax;
    }

    public List<String> getOutput() {
        return output;
    }

    public void setOutput(List<String> output) {
        this.output = output;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> aProducts) {
        this.products = aProducts;
    }

    /**
     * Calculate final price for each product as well as total tax and total cost of purchase
     * 
     * @return The lines to be printed on the receipt
     */
    public List<String> calculateCosts() {
        List<String> result = new LinkedList<String>();
        for (Product product : products) {
            double productTax = strategy.calculateTax(product);
            double productPlusTax = product.getPrice() + productTax;
            result.add(product.getDescription() + ": " + df.format(productPlusTax));
            totalTax += productTax;
            totalCostAfterTax += productPlusTax;
        }
        result.add("Sales Taxes: " + df.format(totalTax));
        result.add("Total: " + df.format(totalCostAfterTax));
        this.output = result;
        return result;
    }
    
    public void printReceipt() {
        for (String line: output) {
            System.out.println(line);
        }
    }
}
