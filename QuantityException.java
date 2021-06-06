public class QuantityException extends IllegalArgumentException
{
    public QuantityException()
    {
        System.out.println("The requested quantity is not currently available. ");
    }
}