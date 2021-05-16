public class DonatorException extends IllegalArgumentException
{
    public DonatorException()
    {
        super("Donator already exists");
    }
}
