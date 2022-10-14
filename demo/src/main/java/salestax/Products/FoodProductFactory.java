package salestax.Products;

public class FoodProductFactory implements ProductFactory {
    @Override
    public Product makeProduct(double aPrice, boolean aImported) {
        return new FoodProduct(aPrice, aImported);
    }
    
    @Override
    public Product makeProduct(double aPrice, boolean aImported, String aDescription) {
        return new FoodProduct(aPrice, aImported, aDescription);
    }   
}
