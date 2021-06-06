import java.util.Scanner;
public class Menu
{
   private boolean exists = false, login = true;
   private String enteredNumber;
   private int type,choice,choice2,choice3;
   private char answer;
   private Scanner keyboard = new Scanner(System.in);
   private User menuUser; 
   private Entity entity;
   public Menu(Organization org)
   {
      while(true){
       exists=false;
       // login=true;
       System.out.println("Welcome to the login menu! ");
       System.out.println("Please enter your phone number: ");
       enteredNumber=keyboard.nextLine();
       if(exists==false){
           if(org.getAdmin().getPhoneNumber().equals(enteredNumber)) //σύγκριση strings
           {  menuUser = org.getAdmin();
              type=3; exists=true; 
           }
       }
       if(exists==false){
           for(Donator thisDonator : org.getDonatorList()) {
                if(thisDonator.getPhoneNumber().equals(enteredNumber))
                    { menuUser = thisDonator;
                      type=1;
                      exists=true;  //αν βρεθεί κατάλληλος donator, σπάμε το loop
                      break;
                }
           } 
       }
       if(exists==false){
           for(Beneficiary thisBeneficiary : org.getBeneficiaryList()){ 
                if(thisBeneficiary.getPhoneNumber().equals(enteredNumber))
                { menuUser = thisBeneficiary;
                  type=2;
                  exists=true;
                  break;
                }      
            }
       }
       if(exists==false){
           System.out.println("You are not signed up! What type of user do you wanna sign up as?\n1.Donator\n2.Beneficiary");
           type= Integer.parseInt(keyboard.nextLine());
           switch(type){
               case 1:
               Donator donator = new Donator();
               org.insertDonator(donator);           
               for(Donator thisDonator : org.getDonatorList()){
                    if(thisDonator.getPhoneNumber().equals(enteredNumber))      //πρεπει το entered number της αρχης να ειναι ιδιο με νεο αριθμο
                    { menuUser=thisDonator;
                       type=1;
                       break;
                    }
               }
               break;                              
               case 2: 
               Beneficiary beneficiary = new Beneficiary();
               org.insertBeneficiary(beneficiary);
               for(Beneficiary thisBeneficiary : org.getBeneficiaryList()){   
                    if(thisBeneficiary.getPhoneNumber().equals(enteredNumber))    //πρεπει το entered number της αρχης να ειναι ιδιο με νεο αριθμο
                    { menuUser=thisBeneficiary;
                      type=2;
                      break;
                    }
                  }
               break;
           }
       }
       //type: 1=DONATOR 2=BENEFICIARY 3=ADMIN
       switch(type){
        //DONATOR
        case 1: 
        System.out.println("Hello "+ menuUser.getName()+ ", you have successfully logged in " + org.getName()+"'s menu.");
        System.out.println("You are a Donator.\nYour phone number is: "+ menuUser.getPhoneNumber());
        while(login==true){
          System.out.println("1.Add Offer\n2.Show Offers\n3.Commit\n4.Logout\n5.Exit");
          choice = Integer.parseInt(keyboard.nextLine());
          switch(choice){
            case 1:
            System.out.println("1.Material\n2.Services\n3.Go Back");
            choice2 = Integer.parseInt(keyboard.nextLine());
            switch(choice2){
                case 1: 
                if(org.listMaterials()==0)  //αν δεν έχει materials πρέπει να σταματάει
                {
                    break;
                }
                else
                {   System.out.println("Enter the number of your selected material from the list above: ");
                    choice3=Integer.parseInt(keyboard.nextLine());
                    entity=org.pickedMaterial(choice3);
                    System.out.println(entity.toString());
                    System.out.println("Do you wanna offer? (y/n)");
                    answer=keyboard.next().charAt(0);
                    keyboard.nextLine(); //απορροφάω το \n
                    switch(answer){
                        case 'y':
                        ((Donator)menuUser).addOffer(entity, org.getEntityList()); 
                        break;
                        case 'n':
                        break;
                    }
                }
                break;
                case 2:
                if(org.listServices()==0)
                { 
                    break;
                }
                else
                {
                    System.out.println("Enter the number of your selected service from the list above: ");
                    choice3=Integer.parseInt(keyboard.nextLine());
                    entity=org.pickedService(choice3);  
                    System.out.println(entity.toString());
                    System.out.println("Do you wanna offer? (y/n)");
                    answer=keyboard.next().charAt(0);
                    keyboard.nextLine();
                    switch(answer){
                        case 'y':
                        ((Donator)menuUser).addOffer(entity, org.getEntityList()); 
                        break;
                        case 'n':
                        break;
                    }
                }
                break;
                case 3:
                break;
                default:
                System.err.println("Invalid option selected");
                break;
            }
            break;
            case 2: 
            ((Donator)menuUser).printOfferList();
            System.out.println("Would you like to ");
            System.out.println("1. Remove/Modify selected donation");
            System.out.println("2. Remove every donation");
            System.out.println("3. Commit ");
            System.out.println("4. Go back ");
            System.out.println("Enter numbered option: ");
            choice3 = Integer.parseInt(keyboard.nextLine());
            switch(choice3){
              case 1:
              System.out.println ("Enter the ID of the selected donation from the list above: ");
              int chosenID = Integer.parseInt(keyboard.nextLine());
              System.out.println("1.Remove\n2.Modify");
              switch(Integer.parseInt(keyboard.nextLine())){
                  case 1:
                  ((Donator)menuUser).removeOffer(((Donator)menuUser).getOffer(chosenID));    
                  System.out.println("Donation successfully removed. "); System.out.println("Remember to commit removal. "); 
                  break;
                  case 2:
                  ((Donator)menuUser).modifyOffer(((Donator)menuUser).getOffer(chosenID));  
                  System.out.println("Donation successfully modified. "); System.out.println("Remember to commit modification. "); 
                  break;
              }
              break;
              case 2:
              ((Donator)menuUser).clearOfferList();
              System.out.println("Every donation successfully removed. "); System.out.println("Remember to commit removal. ");
              break;
              case 3:
              ((Donator)menuUser).commitOffer(org.getCurrentDonations(), org.getEntityList());
              break;
              case 4:
              break;
              default:
              System.err.println("Invalid option selected");
              break;
            }
            break;
            case 3: 
            ((Donator)menuUser).commitOffer(org.getCurrentDonations(), org.getEntityList());
            break;
            case 4: 
            System.out.println("Goodbye! "); login=false; 
            break;
            case 5:System.exit(0);
            default:
            System.err.println("Invalid option selected");
            break;
          }
        }
        break;
        
        //BENEFICIARY        
        case 2:
        System.out.println("Hello "+ menuUser.getName()+ ", you have successfully logged in " + org.getName()+"'s menu.");
        System.out.println("You are a Beneficiary.\nYour phone number is: "+ menuUser.getPhoneNumber());
        while(login==true){
          System.out.println("1.Add Request\n2.Show Requests\n3.Commit\n4.Logout\n5.Exit");
          choice = Integer.parseInt(keyboard.nextLine());
          switch(choice){
            case 1:System.out.println("1.Material\n2.Services\n3.Go back");
            choice2 = Integer.parseInt(keyboard.nextLine());
            switch(choice2){
                case 1:
                if(org.listMaterials()==0)
                {
                    break;
                }
                else
                {
                    System.out.println("Enter the number of your selected service from the list above: ");
                    choice3 = Integer.parseInt(keyboard.nextLine());
                    entity=org.pickedMaterial(choice3);
                    System.out.println(entity.toString());
                    System.out.println("Do you wanna request? (y/n)");
                    answer = keyboard.next().charAt(0);
                    keyboard.nextLine();
                    switch(answer){ 
                        case 'y':
                        ((Beneficiary)menuUser).addRequest(entity, org.getCurrentDonations(), org.getEntityList()); 
                        break;
                        case 'n':
                        break; 
                    }
                }
                break;
                case 2:
                if(org.listServices()==0)
                {
                    break;
                }
                else{
                    choice3 = Integer.parseInt(keyboard.nextLine());
                    entity=org.pickedService(choice3);
                    System.out.println(entity.toString());
                    System.out.println("Do you wanna request? (y/n)");
                    answer=keyboard.next().charAt(0);
                    keyboard.nextLine();
                    switch(answer){ 
                        case 'y':
                        ((Beneficiary)menuUser).addRequest(entity, org.getCurrentDonations(), org.getEntityList()); 
                        break;
                        case 'n':
                        break; 
                    }
                }
                break;
                case 3:
                break;
                default:
                System.err.println("Invalid option selected");
                break;
            }
            break;
            case 2: 
            ((Beneficiary)menuUser).printRequestList();
            System.out.println("Would you like to ");
            System.out.println("1. Remove/Modify selected request");
            System.out.println("2. Remove every request");
            System.out.println("3. Commit ");
            System.out.println("4. Go back");
            System.out.println("Enter numbered option: ");
            choice3 = Integer.parseInt(keyboard.nextLine());
            switch(choice3){
                case 1:
                System.out.println ("Enter the ID of the selected request from the list above: ");
                int chosenID = Integer.parseInt(keyboard.nextLine());
                System.out.println("1.Remove\n2.Modify");
                switch(Integer.parseInt(keyboard.nextLine())){
                    case 1:
                    ((Beneficiary)menuUser).removeRequest(((Beneficiary)menuUser).getRequest(chosenID));    
                    System.out.println("Request successfully removed. ");  System.out.println("Remember to commit removal. ");
                    break;
                    case 2:
                    ((Beneficiary)menuUser).modifyRequest(((Beneficiary)menuUser).getRequest(chosenID), org.getCurrentDonations());  
                    break; 
                }
                break;
                case 2:
                ((Beneficiary)menuUser).clearRequestList();
                System.out.println("Every request has been removed. ");  System.out.println("Remember to commit removal. ");
                break;
                case 3:
                ((Beneficiary)menuUser).commit(org.getCurrentDonations(), org.getEntityList());
                break;
                case 4:
                break;
                default:
                System.err.println("Invalid option selected");
                break;
            }
            break;
            case 3: 
            ((Beneficiary)menuUser).commit(org.getCurrentDonations(), org.getEntityList());
            break;
            case 4: 
            System.out.println("Goodbye! "); login=false; 
            break;
            case 5:System.exit(0);
            default:
            System.err.println("Invalid option selected");
            break;
          }
        }
        break;
        
        //ADMIN
        case 3:
        System.out.println("Hello "+ menuUser.getName()+ ", you have successfully logged in " + org.getName()+"'s menu.");
        System.out.println("You are a Admin.\nYour phone number is: "+ menuUser.getPhoneNumber());
        while(login==true){
          System.out.println("1.View\n2.Monitor Organization\n3.Logout\n4.Exit");
          choice = Integer.parseInt(keyboard.nextLine());
          switch(choice){
            case 1:
            System.out.println("Are you interested in: ");
            System.out.println("1.Material\n2.Services\n3.Go back");
            choice2 = Integer.parseInt(keyboard.nextLine());
            switch(choice2){
                case 1:
                if(org.listMaterials()==0)
                {
                    break;
                }
                else
                {   System.out.println("Enter the number of your selected material from the list above: ");
                    choice3 = Integer.parseInt(keyboard.nextLine());
                    entity=org.pickedMaterial(choice3);
                    System.out.println(entity.toString());
                }
                break;
                case 2:
                if(org.listServices()==0)
                {
                    break;
                }
                else 
                {
                    System.out.println("Enter the number of your selected service from the list above: ");
                    choice3 = Integer.parseInt(keyboard.nextLine());
                    entity=org.pickedService(choice3);
                    System.out.println(entity.toString());
                }
                break;
                case 3:
                break;
                default:
                System.err.println("Invalid option selected");
                break;
            }
            break;
            case 2:System.out.println("1.List Beneficiaries\n2.List Donators\n3.Reset Beneficiaries Lists\n4.Go back");
            choice2= Integer.parseInt(keyboard.nextLine());
            switch(choice2){
                case 1:
                if(org.listBeneficiaries()==0)  { break; }     //αν η λίστα είναι άδεια, σταματάει
                else{
                    System.out.println("Would you like to ");
                    System.out.println("1. Monitor a selected beneficiary's received entities list");
                    System.out.println("2. Clear a a selected beneficiary's received entities list");
                    System.out.println("3. Remove a selected beneficiary");
                    System.out.println("4. Go back");
                    System.out.println("Enter numbered option: ");
                    choice3 = Integer.parseInt(keyboard.nextLine());
                    switch(choice3){
                    case 1:
                    System.out.println("Enter the phone number of a selected beneficiary: ");
                    String selectedNumber = keyboard.nextLine();
                    for(Beneficiary beneficiary : org.getBeneficiaryList())
                    {
                        if(selectedNumber.equals(beneficiary.getPhoneNumber())) beneficiary.printReceivedList();
                    }
                    break;
                    case 2:
                    System.out.println("Enter the phone number of a selected beneficiary: ");
                    selectedNumber = keyboard.nextLine();
                    for(Beneficiary beneficiary : org.getBeneficiaryList())
                    {
                        if(selectedNumber.equals(beneficiary.getPhoneNumber())) { beneficiary.clearReceivedList(); System.out.println("Received List successfully cleared. "); }
                    }
                    break;
                    case 3:
                    org.removeBeneficiary();
                    System.out.println("Beneficiary successfully removed. ");
                    break;
                    case 4:
                    break;
                    default:
                    System.err.println("Invalid option selected");
                    break;
                    }
                }
                break;
                case 2:
                if(org.listDonators()==0) { break; }          // αν η λίστα είναι άδεια, πρέπει να σταματάει
                else{
                    System.out.println("Would you like to ");
                    System.out.println("1. Monitor a selected donator's offers list");
                    System.out.println("2. Remove a selected donator");
                    System.out.println("3. Go back");
                    System.out.println("Enter numbered option: ");
                    choice3 = Integer.parseInt(keyboard.nextLine());
                    switch(choice3){
                    case 1:
                    System.out.println("Enter the phone number of a selected donator: ");
                    String selectedNumber = keyboard.nextLine();
                    for(Donator donator : org.getDonatorList())
                    {
                        if(selectedNumber.equals(donator.getPhoneNumber())) donator.printOfferList();
                    }
                    break;
                    case 2:
                    org.removeDonator();
                    System.out.println("Donator successfully removed. ");
                    break;
                    case 3:
                    break;
                    default:
                    System.err.println("Invalid option selected");
                    break;
                    }
                }
                break;
                case 3:
                org.resetAll();
                System.out.println("Every beneficiary's list has been reset. ");
                break;
                case 4:
                break;
                default:
                System.err.println("Invalid option selected");
                break;
            }
            break;
            case 3: 
            System.out.println("Goodbye! "); login=false; 
            break;
            case 4:System.exit(0);
            default:
            System.err.println("Invalid option selected");
            break;
          }
        }
        break;
        }
      }
    }
}
