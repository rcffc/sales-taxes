package salestax.Tax;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import salestax.Products.BookProductFactory;
import salestax.Products.FoodProductFactory;
import salestax.Products.MedicineProductFactory;
import salestax.Products.MiscProductFactory;
import salestax.Products.Product;

public class TaxStrategyTest {
    TaxStrategy taxCalculator;
    double maxDelta = 0.001;

    public TaxStrategyTest() {
        taxCalculator = new TaxStrategy();
    }
    
    @Test
    public void testRounding() {
        double beforeRound = 0.23;
        double expectedAfterRound = 0.25;
        assertEquals(expectedAfterRound, taxCalculator.round(beforeRound), maxDelta);

        beforeRound = 0.2;
        expectedAfterRound = 0.2;
        assertEquals(expectedAfterRound, taxCalculator.round(beforeRound), maxDelta);
    }

    @Test
    public void testCalculateTax() {
        // Input 1
        Product book = new BookProductFactory().makeProduct(12.49, false);
        assertEquals(0.0, taxCalculator.calculateTax(book), maxDelta);

        Product cd = new MiscProductFactory().makeProduct(14.99, false);
        double cdPriceDiff = 16.49 - cd.getPrice();
        assertEquals(cdPriceDiff, taxCalculator.calculateTax(cd), maxDelta);

        Product choco = new FoodProductFactory().makeProduct(0.85, false);
        double chocoPriceDiff = 0.85 - choco.getPrice();
        assertEquals(chocoPriceDiff, taxCalculator.calculateTax(choco), maxDelta);

        // Input 2
        Product chocoImported = new FoodProductFactory().makeProduct(10.0, true);
        double chocoImportedPriceDiff = 10.5 - chocoImported.getPrice();
        assertEquals(chocoImportedPriceDiff, taxCalculator.calculateTax(chocoImported), maxDelta);

        Product perfumeImported1 = new MiscProductFactory().makeProduct(47.5, true);
        double perfumeImported1PriceDiff = 54.65 - perfumeImported1.getPrice();
        assertEquals(perfumeImported1PriceDiff, taxCalculator.calculateTax(perfumeImported1), maxDelta);

        // Input 3
        Product perfumeImported2 = new MiscProductFactory().makeProduct(27.99, true);
        double perfumeImported2PriceDiff = 32.19 - perfumeImported2.getPrice();
        assertEquals(perfumeImported2PriceDiff, taxCalculator.calculateTax(perfumeImported2), maxDelta);

        Product perfume = new MiscProductFactory().makeProduct(18.99, false);
        double perfumePriceDiff = 20.89 - perfume.getPrice();
        assertEquals(perfumePriceDiff, taxCalculator.calculateTax(perfume), maxDelta);

        Product pills = new MedicineProductFactory().makeProduct(9.75, false);
        assertEquals(0.0, taxCalculator.calculateTax(pills), maxDelta);

        Product chocoImported2 = new FoodProductFactory().makeProduct(11.25, true);
        double chocoImported2PriceDiff = 11.85 - chocoImported2.getPrice();
        assertEquals(chocoImported2PriceDiff, taxCalculator.calculateTax(chocoImported2), maxDelta);
        
    }
}
