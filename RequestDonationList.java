import java.util.List;
import java.util.ArrayList;
public class RequestDonationList
{
    List<RequestDonation> rdEntities = new ArrayList<RequestDonation>();
    //methods
    public int get(RequestDonation RD){ 
        Entity RDEntity=RD.getEntity();
        int id= RDEntity.getID();
        return id;
    }
    public void add(RequestDonation RD){ //θέλει μια μέθοδο που να ψάχνει αν το entity ανήκει στο entityList
        boolean exists = false;
        for(RequestDonation thisRD : rdEntities){
            if(get(thisRD) == get(RD)){
               thisRD.setQuantity(thisRD.getQuantity() + RD.getQuantity());
               exists=true;   
               break;
            } 
        }
        if(exists==false){ rdEntities.add(RD); }
    }
    public void remove(RequestDonation RD){ rdEntities.remove(RD); }
    public void modify(RequestDonation RD,int newQuantity){RD.setQuantity(newQuantity);} //ίσως να ζητάμε νέα τιμή μέσα στη κλάση
    public void monitor(){
        for(RequestDonation thisRD : rdEntities){
            System.out.println( thisRD.getEntity().getName() + " in quantity of " + thisRD.getQuantity() );
        }
    }
    public void reset() { rdEntities.clear(); } //μπορεί να χρειαστεί επιλογή που σβήνει μόνο ένα αντικείμενο
}