import java.util.List;

public class Offers extends RequestDonationList
{
    public void commit(RequestDonationList currentDonations, List<Entity> entityList){  
        for(RequestDonation thisOffer : rdEntities)
        {
          currentDonations.add(thisOffer, entityList);
        }
        super.reset();
        System.out.println("Offers have been commited. ");
    }
}