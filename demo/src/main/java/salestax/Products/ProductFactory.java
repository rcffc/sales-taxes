package salestax.Products;

public interface ProductFactory {
    public Product makeProduct(double aPrice, boolean aImported);
    public Product makeProduct(double aPrice, boolean aImported, String description);
}
