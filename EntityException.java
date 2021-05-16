public class EntityException extends IllegalArgumentException
{
    public EntityException()
    {
        super("Entity already exists");
    }
}

