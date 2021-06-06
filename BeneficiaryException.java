public class BeneficiaryException extends Exception
{
    public BeneficiaryException()
    {
        System.out.println("A beneficiary with the same phone number already exists");
    }
}