package salestax;

public class App 
{
    public static void main( String[] args )
    {
        String[] input1 = { "1 book at 12.49", "1 music CD at 14.99", "1 chocolate bar at 0.85" };
        String[] input2 = { "1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50" };
        String[] input3 = {
            "1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99", "1 packet of headache pills at 9.75",
            "1 box of imported chocolates at 11.25" };
        
        Process process = new Process();
        process.processInput(input1);
        process.processInput(input2);
        process.processInput(input3);
    }

}
