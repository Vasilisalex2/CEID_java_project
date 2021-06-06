import java.util.Scanner;
import java.util.List;
public class Beneficiary extends User
{
    private int noPersons = 1;
    private RequestDonationList receivedList = new RequestDonationList();
    private Requests requestList = new Requests();
    public Beneficiary()
    {
        System.out.println("Enter number of family members: ");
        noPersons = Integer.parseInt(keyboard.nextLine());
    }
    public RequestDonation getRequest(int ID)
    {
        return requestList.get(ID);
    }
    public void addRequest(Entity entity, RequestDonationList currentDonations, List<Entity> entityList)  
    {
        RequestDonation request = new RequestDonation(entity);
        requestList.add(noPersons, request, currentDonations, receivedList, entityList); 
    }
    public void modifyRequest(RequestDonation request, RequestDonationList currentDonations) 
    {
        System.out.println("Enter new quantity: ");
        double newQuantity = Double.parseDouble(keyboard.nextLine());
        requestList.modify(noPersons, newQuantity, request, currentDonations, receivedList);
    }
    public void removeRequest(RequestDonation request)
    {
        requestList.remove(request);
    }
    public void commit(RequestDonationList currentDonations, List<Entity> entityList)   //currentDonations, entityList προστίθενται από το μενού
    {
        requestList.commit(noPersons, currentDonations, receivedList, entityList); 
    }
    public void printRequestList()
    {
        requestList.monitor();
    }
    public void clearRequestList()
    {
        requestList.reset();
    }
    public void clearReceivedList()
    {
        receivedList.reset();
    }
     public void printReceivedList()
    {
        receivedList.monitor();
    }
}