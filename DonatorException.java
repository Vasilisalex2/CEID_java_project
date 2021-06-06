public class DonatorException extends Exception
{
    public DonatorException()
    {
        System.out.println("A donator with the same phone number already exists");
    }
}
