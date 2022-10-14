package salestax;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import salestax.Products.BookProductFactory;
import salestax.Products.FoodProductFactory;
import salestax.Products.MedicineProductFactory;
import salestax.Products.MiscProductFactory;
import salestax.Products.Product;

public class ReceiptTest {
    private double maxDelta = 0.001;

    @Test
    public void testCalculateCosts() {
        // Input 1
        Receipt receipt1 = new Receipt();
        Product book = new BookProductFactory().makeProduct(12.49, false);
        Product cd = new MiscProductFactory().makeProduct(14.99, false);
        Product choco = new FoodProductFactory().makeProduct(0.85, false);
        receipt1.setProducts(Arrays.asList(book, cd, choco));
        receipt1.calculateCosts();

        assertEquals(1.5, receipt1.getTotalTax(), maxDelta);
        assertEquals(29.83, receipt1.getTotalCostAfterTax(), maxDelta);

        // Input 2
        Receipt receipt2 = new Receipt();
        Product chocoImported = new FoodProductFactory().makeProduct(10.0, true);
        Product perfumeImported1 = new MiscProductFactory().makeProduct(47.5, true);
        receipt2.setProducts(Arrays.asList(chocoImported, perfumeImported1));
        receipt2.calculateCosts();

        assertEquals(7.65, receipt2.getTotalTax(), maxDelta);
        assertEquals(65.15, receipt2.getTotalCostAfterTax(), maxDelta);

        // Input 3
        Receipt receipt3 = new Receipt();
        Product perfumeImported2 = new MiscProductFactory().makeProduct(27.99, true);
        Product perfume = new MiscProductFactory().makeProduct(18.99, false);
        Product pills = new MedicineProductFactory().makeProduct(9.75, false);
        Product chocoImported2 = new FoodProductFactory().makeProduct(11.25, true);
        receipt3.setProducts(Arrays.asList(perfumeImported2, perfume, pills, chocoImported2));
        receipt3.calculateCosts();

        assertEquals(6.7, receipt3.getTotalTax(), maxDelta);
        assertEquals(74.68, receipt3.getTotalCostAfterTax(), maxDelta);
    }
}