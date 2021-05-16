public class ValidityException extends IllegalArgumentException
{
    public ValidityException()
    {
        super("Beneficiary request not valid");
    }
}