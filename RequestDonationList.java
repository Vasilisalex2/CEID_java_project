import java.util.List;
import java.util.ArrayList;
public class RequestDonationList
{
    protected List<RequestDonation> rdEntities = new ArrayList<RequestDonation>();
    protected RequestDonation get(int ID) 
    { 
        RequestDonation RD = new RequestDonation();
        for(RequestDonation thisRD : rdEntities) 
        {
             if(thisRD.getEntity().getID() == ID)  RD = thisRD;
        }    
        return RD;
    }
    protected void add(RequestDonation RD, List<Entity> entityList){  
        boolean exists = false;
        boolean exists1 = false;
        try{
            for(int i=0; i<entityList.size(); i++)  //ελέγχει αν το entity υπάρχει στο entityList του οργανισμού
            {
                if(entityList.get(i).getID() == RD.getEntity().getID() ) exists = true;
            }
            if(exists == false) { throw new NoSuchEntityException(); }  
            else{
                for(RequestDonation thisRD : rdEntities){  
                    if(thisRD.getEntity().getID() == RD.getEntity().getID()){   //ελέγχει αν υπάρχει ήδη στην rdEntities
                       thisRD.setQuantity(thisRD.getQuantity() + RD.getQuantity());
                       exists1 = true;   
                       System.out.println("Quantity of entity successfully updated. ");
                       break;
                    } 
                }
                if(exists1==false){ rdEntities.add(RD); System.out.println("Entity successfully added. "); }
            }
        } catch(NoSuchEntityException nse){}
    }
    protected void remove(RequestDonation RD){ rdEntities.remove(RD); }
    protected void modify(RequestDonation RD, double newQuantity){ 
        RD.setQuantity(newQuantity);
    } 
    protected void monitor(){
        int number = 0;
        for(RequestDonation thisRD : rdEntities){
            number++;
            System.out.println( number+". "+thisRD.getEntity().getName() + " in quantity of " + thisRD.getQuantity()+ "  ID: " + thisRD.getEntity().getID() );
        }
        if(number==0) System.out.println("The list is empty. ");
    }
    protected void reset() { rdEntities.clear(); } 
}