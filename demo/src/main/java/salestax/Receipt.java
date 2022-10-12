package salestax;

import java.util.Collection;

import salestax.Products.Product;
import salestax.Tax.ITaxStrategy;

public class Receipt {
    
    private double totalTax;
    private double totalCostBeforeTax;
    private double totalCostAfterTax;

    private Collection<Product> products;
    private ITaxStrategy strategy;

    public Receipt() {

    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double aTotalTax) {
        this.totalTax = aTotalTax;
    }

    public double getTotalCostBeforeTax() {
        return totalCostBeforeTax;
    }

    public void setTotalCostBeforeTax(double aTotalCostBeforeTax) {
        this.totalCostBeforeTax = aTotalCostBeforeTax;
    }

    public double getTotalCostAfterTax() {
        return totalCostAfterTax;
    }

    public void setTotalCostAfterTax(double aTotalCostAfterTax) {
        this.totalCostAfterTax = aTotalCostAfterTax;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> aProducts) {
        this.products = aProducts;
    }

    public void calculateCosts() {

    }

    public void printReceipt() {

    }
    
    
}
