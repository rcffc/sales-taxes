package salestax.Products;

public class MedicineProduct extends Product{
    MedicineProduct(double aPrice, boolean aImported) {
        super(aPrice, aImported);
        this.exemptedFromBasicSalesTax = true;
    }
}
