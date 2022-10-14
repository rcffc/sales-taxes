package salestax.Products;

public class MiscProductFactory implements ProductFactory {
    @Override
    public Product makeProduct(double aPrice, boolean aImported) {
        return new MiscProduct(aPrice, aImported);
    }

    @Override
    public Product makeProduct(double aPrice, boolean aImported, String aDescription) {
        return new MiscProduct(aPrice, aImported, aDescription);
    }   
}
