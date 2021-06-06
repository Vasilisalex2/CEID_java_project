public class main
{
    public static void main (String[] args){
        Organization org= new Organization();
        org.setAdmin();
        System.out.println("Adding six entities to the organization..");
        org.addEntity();
        //org.addEntity();
        //org.addEntity();
        //org.addEntity();
        //org.addEntity();
        //org.addEntity();
        System.out.println("Adding 2 beneficiaries..");
        Beneficiary beneficiary1 = new Beneficiary();
        Beneficiary beneficiary2 = new Beneficiary();
        org.insertBeneficiary(beneficiary1);
        org.insertBeneficiary(beneficiary2);
        System.out.println("Adding donator..");
        Donator donator = new Donator();
        org.insertDonator(donator);
        System.out.println("Adding the first entity to the offerList of the first donator...");
        donator.addOffer(org.getEntityList().get(0), org.getEntityList());
        System.out.println("Adding the first entity to the requestList of the beneficiary..");
        beneficiary1.addRequest(org.getEntityList().get(0), org.getCurrentDonations(), org.getEntityList());
        Menu menu=new Menu(org);
    }
}
