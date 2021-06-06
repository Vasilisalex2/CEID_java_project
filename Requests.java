import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
public class Requests extends RequestDonationList
{
    public void add(int familyMembers,RequestDonation request, RequestDonationList currentDonations, RequestDonationList receivedList, List<Entity> entityList)
    {
        try{
                if(currentDonations.get(request.getEntity().getID()).getQuantity() < request.getQuantity())
                { throw new QuantityException(); }
                else
                { 
                    if(request.getEntity() instanceof Service) { super.add(request, entityList); System.out.println("Request successfully added. Remember to commit the request."); }
                    else if(request.getEntity() instanceof Material){
                        if(validRequestDonation(familyMembers, request.getQuantity(), request, receivedList)==true) 
                        { super.add(request, entityList); System.out.println("Request successfully added. Remember to commit the request."); }    
                    }
                }
        }
        catch(QuantityException qe){}
    }
    public void modify(int familyMembers,double newQuantity, RequestDonation request, RequestDonationList currentDonations, RequestDonationList receivedList)
    {  
        try{
                if(currentDonations.get(request.getEntity().getID()).getQuantity() < newQuantity )
                { throw new QuantityException(); }
                else
                { 
                    if(request.getEntity() instanceof Service) { super.modify(request, newQuantity); System.out.println("Request successfully modified. Remember to commit the request. "); }
                    else if(request.getEntity() instanceof Material){
                        if(validRequestDonation(familyMembers, newQuantity, request, receivedList)==true) 
                        {super.modify(request, newQuantity); System.out.println("Request successfully modified. Remember to commit the request. ");}
                    }
                }
              }
        catch(QuantityException qe){}
    }
    public void commit(int familyMembers, RequestDonationList currentDonations, RequestDonationList receivedList, List<Entity> entityList)
    {
        List <RequestDonation> toRemove = new ArrayList<RequestDonation>();   //δεν μπορούμε να αφαιρέσουμε από το rdEntities ενώ κάνουμε iteration
        for(RequestDonation request : rdEntities)
            {
            try{
                if(currentDonations.get(request.getEntity().getID()).getQuantity() < request.getQuantity())
                { throw new QuantityException(); }
                else
                { 
                    double newQuantity = currentDonations.get(request.getEntity().getID()).getQuantity() - request.getQuantity();  //αφαιρώ την καινούργια απο την παλιά ποσότητα
                    if(request.getEntity() instanceof Service) 
                    { 
                        currentDonations.get(request.getEntity().getID()).setQuantity(newQuantity); toRemove.add(request); 
                        receivedList.add(request, entityList); System.out.println("Request commited. ");
                    }
                    else if(request.getEntity() instanceof Material){
                        if(validRequestDonation(familyMembers, request.getQuantity(), request, receivedList)==true)
                        { 
                            currentDonations.get(request.getEntity().getID()).setQuantity(newQuantity); toRemove.add(request);  
                            receivedList.add(request, entityList);  System.out.println("Request commited. ");
                        }
                    }  
                }
            } 
            catch(QuantityException qe){}
        }
        rdEntities.removeAll(toRemove);
    }
    public boolean validRequestDonation(int familyMembers, double quantity, RequestDonation request, RequestDonationList receivedList){     
          boolean result = false;
          try{                            //το request.getEntity() επιστρέφει μεταβλητή Entity που είναι υπερκλάση της Material και δεν περιλαμβάνει τις μεθόδους getLevel()
              if(familyMembers == 1)
              {   
                  if(quantity + receivedList.get(request.getEntity().getID()).getQuantity() > ((Material)request.getEntity()).getLevel1()) { throw new ValidityException(); }  
                  else{ result = true; } 
              }      
              if(familyMembers >= 5)
              {
                  if(quantity + receivedList.get(request.getEntity().getID()).getQuantity() > ((Material)request.getEntity()).getLevel3()){ throw new ValidityException(); }   
                  else{ result = true; } 
              }
              else 
              {
                  if(quantity + receivedList.get(request.getEntity().getID()).getQuantity() > ((Material)request.getEntity()).getLevel2()){ throw new ValidityException(); }  
                  else{ result = true; } 
              } 
          }
          catch(ValidityException ve){} 
          return result; 
    }
}