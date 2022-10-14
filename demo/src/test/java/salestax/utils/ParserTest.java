package salestax.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import salestax.Products.BookProductFactory;
import salestax.Products.FoodProductFactory;
import salestax.Products.MedicineProductFactory;
import salestax.Products.MiscProductFactory;
import salestax.Products.Product;

public class ParserTest {
    Parser parser;
    double maxDelta = 0.001;

    public ParserTest() {
        parser = new Parser();
    }
    
    @Test
    public void testParse() {
        // Input 1
        String[] input1 = { "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85" };

        Product book = new BookProductFactory().makeProduct(12.49, false, "1 book");
        Product actualBook = parser.parse(input1[0]);
        assertEquals(actualBook, book);

        Product cd = new MiscProductFactory().makeProduct(14.99, false, "1 music CD");
        assertEquals(parser.parse(input1[1]), cd);

        Product choco = new FoodProductFactory().makeProduct(0.85, false, "1 chocolate bar");
        assertEquals(parser.parse(input1[2]), choco);

        // Input 2
        String[] input2 = { "1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50" };

        Product chocoImported = new FoodProductFactory().makeProduct(10.0, true, "1 imported box of chocolates");
        assertEquals(parser.parse(input2[0]), chocoImported);

        Product perfumeImported1 = new MiscProductFactory().makeProduct(47.5, true, "1 imported bottle of perfume");
        assertEquals(parser.parse(input2[1]), perfumeImported1);

        // Input 3
        String[] input3 = {
                "1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99",
                "1 packet of headache pills at 9.75",
                "1 box of imported chocolates at 11.25" };

        Product perfumeImported2 = new MiscProductFactory().makeProduct(27.99, true, "1 imported bottle of perfume");
        assertEquals(parser.parse(input3[0]), perfumeImported2);

        Product perfume = new MiscProductFactory().makeProduct(18.99, false, "1 bottle of perfume");
        assertEquals(parser.parse(input3[1]), perfume);

        Product pills = new MedicineProductFactory().makeProduct(9.75, false, "1 packet of headache pills");
        assertEquals(parser.parse(input3[2]), pills);

        Product chocoImported2 = new FoodProductFactory().makeProduct(11.25, true, "1 imported box of chocolates");
        assertEquals(parser.parse(input3[3]), chocoImported2);
    }
}
