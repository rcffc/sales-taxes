package salestax;

import java.util.Collection;

import salestax.Products.Product;
import salestax.Tax.ITaxStrategy;
import salestax.Tax.TaxStrategy;

public class Receipt {
    
    private double totalTax;
    private double totalCostAfterTax;

    private Collection<Product> products;
    private ITaxStrategy strategy = new TaxStrategy();

    public Receipt() {
        this.totalTax = 0;
        this.totalCostAfterTax = 0;
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

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> aProducts) {
        this.products = aProducts;
    }

    public void calculateCostsAndPrintReceipt() {
        for (Product product : products) {
            double productTax = strategy.calculateTax(product);
            double productPlusTax = product.getPrice() + productTax;
            System.out.println(product.getDescription() + ": " + productPlusTax);
            totalTax += productTax;
            totalCostAfterTax += productPlusTax;
        }
        System.out.println("Sales Taxes: " + totalTax);
        System.out.println("Total: " + totalCostAfterTax);       
    }
}
