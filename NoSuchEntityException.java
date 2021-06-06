public class NoSuchEntityException extends Exception{
    public NoSuchEntityException()
    {
        System.out.println("No entity with such ID exists");
    }
}
