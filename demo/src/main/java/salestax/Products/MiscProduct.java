package salestax.Products;

public class MiscProduct extends Product{
    MiscProduct(double aPrice, boolean aImported) {
        super(aPrice, aImported);
        this.exemptedFromBasicSalesTax = false;
    }
}
