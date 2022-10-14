package salestax.Products;

public class FoodProduct extends Product{
    FoodProduct(double aPrice, boolean aImported) {
        super(aPrice, aImported);
        this.exemptedFromBasicSalesTax = true;
    }

    FoodProduct(double aPrice, boolean aImported, String aDescription) {
        super(aPrice, aImported, aDescription);
        this.exemptedFromBasicSalesTax = true;
    }
}
