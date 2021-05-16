import java.util.Scanner;
public abstract class User{
    private String name;
    private String phone;
    protected Scanner keyboard = new Scanner(System.in);
    public User()
    {
        System.out.println("Enter full name: ");
        name = keyboard.nextLine();
        System.out.println("Enter phone number: ");
        phone = keyboard.nextLine();
    }
    public String getPhoneNumber()
    {
        return phone;
    }
}