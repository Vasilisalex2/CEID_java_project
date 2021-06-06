public class ValidityException extends IllegalArgumentException
{
    public ValidityException()
    {
        System.out.println("Beneficiary request not valid. Your family is not eligible for the requested quantity.");
    }
}