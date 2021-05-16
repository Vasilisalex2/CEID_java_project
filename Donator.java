public class Donator extends User
{
    private Offers offerList;
    public void AddOffer()
    {
        RequestDonation donation = new RequestDonation();
        offerList.commit();
    }
}
