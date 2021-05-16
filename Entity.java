import java.util.Scanner;
import java.util.InputMismatchException;
public abstract class Entity{
    private String name;
    private String description;
    private int id;
    protected Scanner keyboard = new Scanner(System.in);
    public Entity()
    {
        //try
        System.out.println("Enter material or service name: ");
        name = keyboard.nextLine();
        System.out.println("Enter description: ");
        description = keyboard.nextLine();
        System.out.println("Enter an identification code: ");
        id = keyboard.nextInt(); 
        /*catch (InputMismatchException e) {
            System.out.print(e.getMessage()); }*/
    }
    public int getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getInfo()
    {
        return name + "\n" + description;        
    }
    abstract String getDetails();
    @Override
    public String toString()
    {
        return this.getInfo() + "" + this.getDetails();
    }
}
