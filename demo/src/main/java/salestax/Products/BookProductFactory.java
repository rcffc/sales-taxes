package salestax.Products;

public class BookProductFactory implements ProductFactory {
    @Override
    public Product makeProduct(double aPrice, boolean aImported) {
        return new BookProduct(aPrice, aImported);
    }
    
    @Override
    public Product makeProduct(double aPrice, boolean aImported, String aDescription) {
        return new BookProduct(aPrice, aImported, aDescription);
    }   
}
