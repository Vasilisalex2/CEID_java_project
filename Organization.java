import java.util.*;
public class Organization
{
    private Scanner keyboard = new Scanner(System.in);
    private String name;
    private Admin admin;
    private List<Entity> entityList = new ArrayList<Entity>();    
    private List<Donator> donatorList = new ArrayList<Donator>();
    private List<Beneficiary> beneficiaryList = new ArrayList<Beneficiary>();
    private RequestDonationList currentDonations = new RequestDonationList();
    public Organization()
    {
        System.out.println("Enter Organization Name: ");
        name = keyboard.nextLine();
    }
    public String getName(){
         return name;   
    }
    public List<Entity> getEntityList()
    {
        return entityList;
    }
    public List<Donator> getDonatorList()
    {
        return donatorList;
    }
    public List<Beneficiary> getBeneficiaryList()
    {
        return beneficiaryList;
    }
    public RequestDonationList getCurrentDonations()
    {
        return currentDonations;
    }
    public void setAdmin()
    {
        System.out.println("New System Admin ");
        admin = new Admin();
    }
    public Admin getAdmin()
    {
        return admin;
    }
    public void addEntity() 
    {
        Entity newEntity;
        System.out.println("Are you adding a material or a service?");
        System.out.println("Enter '1' for Material, '2' for Service");
        if(Integer.parseInt(keyboard.nextLine()) == 1) { newEntity = new Material(); }
        else { newEntity = new Service(); }
        try{
            for(Entity entity : entityList) 
            {
                if(newEntity.getID() == entity.getID()) throw new EntityExistsException();
            }
            entityList.add(newEntity);
        }
        catch(EntityExistsException eee){}
    }
    public void removeEntity(Entity entity)
    {
        List <Entity> toRemove = new ArrayList<Entity>(); 
        for(Entity thisEntity : entityList) 
            {
                if(entity.getID() == thisEntity.getID()) toRemove.add(entity);
            }        
        entityList.removeAll(toRemove);
    }
    public void insertDonator(Donator donator)
    {
        try{
            for(int i=0; i<donatorList.size(); i++) 
            {
                if(donator.getPhoneNumber().equals(donatorList.get(i).getPhoneNumber())) { throw new DonatorException(); }
            } 
            donatorList.add(donator);
        }
        catch (DonatorException de){}
    }
    public void removeDonator()
    {
        System.out.println("Enter donator's phone number: ");
        String phoneNumber = keyboard.nextLine();
        List <Donator> toRemove = new ArrayList<Donator>();   //δεν μπορούμε να αφαιρέσουμε από το donatorList ενώ κάνουμε iteration
        for(Donator donator : donatorList)
        {
            if(phoneNumber.equals(donator.getPhoneNumber()) ) { toRemove.add(donator) ;}
        } 
        donatorList.removeAll(toRemove);
    }
    public void insertBeneficiary(Beneficiary beneficiary)
    {
        try{
            for(int i=0; i<beneficiaryList.size(); i++) 
            {
                if(beneficiary.getPhoneNumber().equals(beneficiaryList.get(i).getPhoneNumber()) ) { throw new BeneficiaryException(); }
            }
            beneficiaryList.add(beneficiary);
        }
        catch(BeneficiaryException be){}
    }
    public void removeBeneficiary()
    {
        System.out.println("Enter beneficiary's phone number: ");
        String phoneNumber = keyboard.nextLine();
        List <Beneficiary> toRemove = new ArrayList<Beneficiary>();   //δεν μπορούμε να αφαιρέσουμε από το beneficiaryList ενώ κάνουμε iteration
        for(Beneficiary beneficiary : beneficiaryList)
        {
            if(phoneNumber.equals(beneficiary.getPhoneNumber()) )  { toRemove.add(beneficiary); }
        } 
        beneficiaryList.removeAll(toRemove);
    }
    public int listServices()
    {
        int number=0;
        System.out.println("Services: ");
        for(Entity entity : entityList)
        {
            if(entity instanceof Service){
                number++;
                System.out.println(number+". " + entity.getName()+"  ("+ (currentDonations.get(entity.getID())).getQuantity() +")");
            }
        }
        if(number==0){System.out.println("The list is empty of services.");}
        return number;
    }
    public int listMaterials()
    {
        int number=0;
        System.out.println("Materials: ");
        for(Entity entity : entityList)
        {
            if(entity instanceof Material){
                number++;
                System.out.println(number+". " + entity.getName()+"  ("+ (currentDonations.get(entity.getID())).getQuantity() +")");
            }
        }
        if(number==0){System.out.println("The list is empty of materials.");}
        return number;
    }
    public Entity pickedMaterial(int number)
    {
        int place=0;
        for(Entity entity : entityList)
        {
            if(entity instanceof Material){
             place++;
            }
            if(place==number){return entity;}
        }
        return null;
    }
    public Entity pickedService(int number)
    {
        int place=0;
        for(Entity entity : entityList)
        {
            if(entity instanceof Service){
               place++;
            }
            if(place==number) {return entity;}
        }
        return null;
    }
    public int listBeneficiaries()
    {
        int number=0;
        for(Beneficiary beneficiary : beneficiaryList)
        {
            number++;
            System.out.println(number+". "+beneficiary.getName()+" Phone Number: "+beneficiary.getPhoneNumber());
        }
        if(number==0) System.out.println("The list is empty. ");
        return number;
    }
    public int listDonators()
    {
        int number=0;
        for(Donator donator : donatorList)
        {
            number++;
            System.out.println(number+". "+donator.getName()+" Phone Number: "+donator.getPhoneNumber());
        }
        if(number==0) System.out.println("The list is empty. ");
        return number;
    }
    public void resetAll(){
        for(Beneficiary beneficiary : beneficiaryList){
           beneficiary.clearReceivedList();
        }
    }
}