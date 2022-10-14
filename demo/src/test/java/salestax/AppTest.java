package salestax;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    Process process;

    public AppTest() {
        process = new Process();
    }
    /**
     * Test whether the display output of its corresponding input is correct 
     */
    @Test
    public void testInputOutput()
    {
        String[] input1 = { "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85" };
        String[] expectedOutput1 = { "1 book: 12.49",
                "1 music CD: 16.49",
                "1 chocolate bar: 0.85",
                "Sales Taxes: 1.50",
                "Total: 29.83" };
        List<String> actualOutput1 = process.processInput(input1);

        for (int i=0; i < input1.length; i++) {
            assertEquals(expectedOutput1[i], actualOutput1.get(i));
        }

        String[] input2 = { "1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50" };
        String[] expectedOutput2 = { "1 imported box of chocolates: 10.50",
                            "1 imported bottle of perfume: 54.65",
                            "Sales Taxes: 7.65",
                "Total: 65.15" };
        List<String> actualOutput2 = process.processInput(input2);

        for (int i=0; i < input2.length; i++) {
            assertEquals(expectedOutput2[i], actualOutput2.get(i));
        }

        String[] input3 = {
            "1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75",
            "1 box of imported chocolates at 11.25" };
        String[] expectedOutput3 = { "1 imported bottle of perfume: 32.19",
                             "1 bottle of perfume: 20.89",
                             "1 packet of headache pills: 9.75",
                             "1 imported box of chocolates: 11.85",
                             "Sales Taxes: 6.70",
                "Total: 74.68" };
        List<String> actualOutput3 = process.processInput(input3);

        for (int i=0; i < input3.length; i++) {
            assertEquals(expectedOutput3[i], actualOutput3.get(i));
        }

    }
}
