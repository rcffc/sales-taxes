package salestax.Products;

public class FoodProduct extends Product{
    FoodProduct(double aPrice, boolean aImported) {
        super(aPrice, aImported);
        this.exemptedFromBasicSalesTax = true;
    }
}
