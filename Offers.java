public class Offers extends RequestDonationList
{
    public void commit(){
        /*for(RequestDonation thisOffer : rdEntities)
        {
          Organization.currentDonations.add(thisOffer);
        }*/
        reset();
    }
}