import java.util.List;
public class Donator extends User
{
    private Offers offerList = new Offers();
    public void addOffer(Entity entity, List<Entity> entityList)
    {
        RequestDonation donation = new RequestDonation(entity);
        offerList.add(donation, entityList);
    }
    public void modifyOffer(RequestDonation offer)
    {
        System.out.println("Enter new quantity: "); 
        double newQuantity = Double.parseDouble(keyboard.nextLine());
        offerList.modify(offer, newQuantity);
    }
    public void removeOffer(RequestDonation offer)
    {
        offerList.remove(offer);
    }
    public void commitOffer(RequestDonationList currentDonations, List<Entity> entityList)   //currentDonations, entityList προστίθενται από το μενού
    {
        offerList.commit(currentDonations, entityList);
    }
    public RequestDonation getOffer(int ID)
    {
        return offerList.get(ID);
    }
    public void printOfferList()
    {
        offerList.monitor();
    }
    public void clearOfferList()
    {
        offerList.reset();
    }
}
