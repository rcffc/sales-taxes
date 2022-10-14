package salestax.Tax;

import static salestax.Tax.TaxRates.BASIC_SALES_TAX;
import static salestax.Tax.TaxRates.IMPORT_SALES_TAX;

import salestax.Products.Product;

public class TaxStrategy implements ITaxStrategy {

    /*
     * Calculates total tax by applying basic and import sales tax if applicable before rounding up
     * 
     * @param aProduct Total tax before applying rounding
     * 
     * @return  Total tax rounded up to the nearest rounding step in cents
     */
    public double calculateTax(Product aProduct) {
        double tax = 0;
        if (!aProduct.isExemptedFromBasicSalesTax()) {
            tax += calculateBasicSaleTax(aProduct);
        }
        if (aProduct.isImported()) {
            tax += calculateImportTax(aProduct);
        }
        return round(tax);
    }

    private double calculateBasicSaleTax(Product aProduct) {
        return aProduct.getPrice() * BASIC_SALES_TAX;
    }

    private double calculateImportTax(Product aProduct) {
        return aProduct.getPrice() * IMPORT_SALES_TAX;

    }

    /*
     * @param aTax  Total tax before applying rounding
     * 
     * @return  Total tax rounded up to the nearest rounding step in cents
     */
    public double round(double aTax) {
        double roundingStep = 0.05;
        return Math.ceil(aTax / roundingStep) * roundingStep;
    }
}
