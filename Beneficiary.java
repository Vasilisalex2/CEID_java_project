import java.util.Scanner;
public class Beneficiary extends User
{
    private int noPersons = 1;
    private RequestDonationList receivedList;
    private Requests requestlList;
    public Beneficiary()
    {
        System.out.println("Enter number of family members: ");
        noPersons = keyboard.nextInt();
    }
    public int getNoPersons() {
        return noPersons;
    }
    public void addRequest()  //αυτά που ζητάει
    {
        /*RequestDonation request = new RequestDonation();
        requestList.add(request); //θέλει πείραγμα με τα exceptions
        requestlList.commit(request); */
    }
    public void receiveRequest() //τα πράγματα που έχει παραλάβει
    {
        //receivedList.add(request);
    }
    public Requests getRequestList()
    {
    }
}