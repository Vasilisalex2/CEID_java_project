import java.util.Scanner;
public class RequestDonation{ 
    private Entity entity;
    private double quantity;
    private Scanner keyboard = new Scanner(System.in);
    public RequestDonation(){}
    public RequestDonation(Entity entity)
    {
        this.entity = entity;
        System.out.println("Enter quantity: ");
        quantity = Double.parseDouble(keyboard.nextLine());
    }
    public Entity getEntity(){
        return entity;
    }
    public void setQuantity(double newQuantity){
        quantity = newQuantity;
    }
    public double getQuantity(){
        return quantity;
    }
}
