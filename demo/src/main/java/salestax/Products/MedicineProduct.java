package salestax.Products;

public class MedicineProduct extends Product{
    MedicineProduct(double aPrice, boolean aImported) {
        super(aPrice, aImported);
        this.exemptedFromBasicSalesTax = true;
    }

    MedicineProduct(double aPrice, boolean aImported, String aDescription) {
        super(aPrice, aImported, aDescription);
        this.exemptedFromBasicSalesTax = true;
    }
}
