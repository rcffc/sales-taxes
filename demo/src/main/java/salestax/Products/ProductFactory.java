package salestax.Products;

public interface ProductFactory {
    public Product makeProduct(double aPrice, boolean aImported);
}
