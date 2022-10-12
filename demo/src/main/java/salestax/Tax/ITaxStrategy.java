package salestax.Tax;

import salestax.Products.Product;

public interface ITaxStrategy {
    public double calculateTax(Product aProduct);
    public double round(double aTax);
}