import java.util.Scanner;
public class RequestDonation{ //από εδώ θα ζητάμε material ή service
    private Entity entity;
    private double quantity;
    public RequestDonation()
    {
        //Organization.listEntities();
        //System.out.println("Which en
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
