package salestax.Products;

public abstract class Product {
    protected double price;
    protected boolean imported;
    protected boolean exemptedFromBasicSalesTax;

    Product(double aPrice, boolean aImported) {
        this.price = aPrice;
        this.imported = aImported;
    }

    public double getPrice() {
        return price;
    }
    
    public void setPrice(double aPrice) {
        this.price = aPrice;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean aImported) {
        this.imported = aImported;
    }

    public boolean isExemptedFromBasicSalesTax() {
        return exemptedFromBasicSalesTax;
    }
    
    public void setExemptedFromBasicSalesTax(boolean aExemptedFromBasicSalesTax) {
        this.exemptedFromBasicSalesTax = aExemptedFromBasicSalesTax;
    }
}
