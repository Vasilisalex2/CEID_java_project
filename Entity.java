import java.util.Scanner;
public abstract class Entity{
    private String name;
    private String description;
    private int id;
    protected Scanner keyboard = new Scanner(System.in);
    public Entity()
    {
        System.out.println("Enter Name: ");
        name = keyboard.nextLine();
        System.out.println("Enter Description: ");
        description = keyboard.nextLine();
        System.out.println("Enter an Identification Code: ");
        id = Integer.parseInt(keyboard.nextLine()); 
    }
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getInfo()
    {
        return "Name: "+ name + '\n' + "Description: "+description;        
    }
    abstract String getDetails();
    @Override
    public String toString()
    {
        return this.getInfo() + '\n' + this.getDetails();
    }
}
