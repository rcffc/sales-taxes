package salestax.Products;

public class BookProduct extends Product{
    BookProduct(double aPrice, boolean aImported) {
        super(aPrice, aImported);
        this.exemptedFromBasicSalesTax = true;
    }
    
    BookProduct(double aPrice, boolean aImported, String aDescription) {
        super(aPrice, aImported, aDescription);
        this.exemptedFromBasicSalesTax = true;
        this.setDescription(aDescription);
    }
    
}
