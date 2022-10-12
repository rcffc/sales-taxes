package salestax.Products;

public class BookProduct extends Product{
    BookProduct(double aPrice, boolean aImported) {
        super(aPrice, aImported);
        this.exemptedFromBasicSalesTax = true;
    }
}
