package salestax.Products;

public class BookProductFactory implements ProductFactory {
    @Override
    public Product makeProduct(double aPrice, boolean aImported) {
        return new BookProduct(aPrice, aImported);
    }   
}
