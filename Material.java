import java.util.Scanner;
public class Material extends Entity{
    private final double level1; 
    private final double level2;
    private final double level3;
    public Material()
    {
        System.out.println ("Quantity eligible for one member family?");
        level1 = keyboard.nextDouble();
        System.out.println ("Quantity eligible for two-four member family?");
        level2 = keyboard.nextDouble();
        System.out.println ("Quantity eligible for five or more member family?");
        level3 = keyboard.nextDouble();
    }
    public String getDetails()
    {
        return "Material \n One member families:" + level1 + "\nTwo-four member families: " + level2 + "\nFive or more member families: " + level3;
    }
    public double getLevel1()
    {
        return level1;
    }
    public double getLevel2()
    {
        return level2;
    }
    public double getLevel3()
    {
        return level3;
    }
    
}
