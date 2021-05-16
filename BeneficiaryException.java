public class BeneficiaryException extends IllegalArgumentException
{
    public BeneficiaryException()
    {
        super("Beneficiary already exists");
    }
}