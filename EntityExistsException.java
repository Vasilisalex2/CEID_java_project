public class EntityExistsException extends Exception{
    EntityExistsException()
    {
        System.out.println("An entity with the same ID already exists. ");
    }
}