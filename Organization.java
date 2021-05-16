import java.util.*;
public class Organization
{
    private Scanner keyboard = new Scanner(System.in);
    private String name;
    private Admin admin;
    List<Entity> entityList = new ArrayList<Entity>();    
    private List<Donator> donatorList = new ArrayList<Donator>();
    private List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
    private RequestDonationList currentDonations;
    public Organization()
    {
        System.out.println("Enter organization name: ");
        name = keyboard.nextLine();
    }
    public List getEntityList()
    {
        return entityList;
    }
    public List getDonatorList()
    {
        return donatorList;
    }
    public List getBeneficiaryList()
    {
        return beneficiaryList;
    }
    public RequestDonationList getCurrentDonations()
    {
        return currentDonations;
    }
    public void setAdmin()
    {
        admin = new Admin();
    }
    public Admin getAdmin()
    {
        return admin;
    }
    public void addEntity()
    {
        System.out.println("Are you interested in material or service?");
        System.out.println("Enter '1' for Material, '2' for Service");
        if(keyboard.nextInt() == 1) { Material newEntity = new Material(); }
        else { Service newEntity = new Service(); }
        for(Entity entity : entityList) 
        {
            if(newEntity.getID() == entity.getID()) throw new EntityException();
        }
    }
    public void removeEntity() //μόνο ο admin
    {
    }
    public void insertDonator()
    {
        Donator donator = new Donator();  
        for(int i=0; i<donatorList.size(); i++) 
        {
            if(donator.getPhoneNumber() == donatorList.get(i).getPhoneNumber()) { throw new DonatorException(); }
        }
    }
    public void removeDonator()
    {
    }
    public void insertBeneficiary()
    {
        Beneficiary donator = new Beneficiary();  
        for(int i=0; i<beneficiaryList.size(); i++) 
        {
            if(donator.getPhoneNumber() == beneficiaryList.get(i).getPhoneNumber()) { throw new BeneficiaryException(); }
        }
    }
    public void removeBeneficiary()
    {
    }
    public static void listEntities()
    {
        for(Entity entity : entityList)
        {
            System.out.println("entity.toString()");
        }
    }
    public void listBeneficiaries()
    {
    }
    public void listDonators()
    {
    }
}