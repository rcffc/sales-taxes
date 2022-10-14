package salestax.Products;

public class MedicineProductFactory implements ProductFactory {
    @Override
    public Product makeProduct(double aPrice, boolean aImported) {
        return new MedicineProduct(aPrice, aImported);
    }   

    @Override
    public Product makeProduct(double aPrice, boolean aImported, String aDescription) {
        return new MedicineProduct(aPrice, aImported, aDescription);
    }   
}
