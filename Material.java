import java.util.Scanner;
public class Material extends Entity{
    private final double level1; //δεν μπορεί να αλλάζει η τιμή τους μετά την δημιουργία ενός αντικειμένου
    private final double level2;
    private final double level3;
    public Material()
    {
        System.out.println ("Quantity a one member family is entitled to: ");
        level1 = Double.parseDouble(keyboard.nextLine());
        System.out.println ("Quantity a two-four member family is entitled to: ");
        level2 = Double.parseDouble(keyboard.nextLine());
        System.out.println ("Quantity a five or more member family is entitled to: ");
        level3 = Double.parseDouble(keyboard.nextLine());
    }
    public String getDetails()
    {
        return "Type: Material \nOne member families:" + getLevel1() + "\nTwo-four member families: " + getLevel2() + "\nFive or more member families: " + getLevel3();
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
