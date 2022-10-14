package salestax.Products;

public abstract class Product {
    protected String description;
    protected double price;
    protected boolean imported;
    protected boolean exemptedFromBasicSalesTax;

    Product(double aPrice, boolean aImported) {
        this.price = aPrice;
        this.imported = aImported;
    }

    Product(double aPrice, boolean aImported, String aDescription) {
        this.description = aDescription;
        this.price = aPrice;
        this.imported = aImported;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        this.description = aDescription;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + (imported ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (imported != other.imported)
            return false;
        return true;
    }

    
}
