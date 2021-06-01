import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Menu
{
    private boolean exists=false,going=true;
    private int enteredNumber,type,choice,choice2,choice3;
    private char answer;
    protected Scanner keyboard = new Scanner(System.in);
    User menuUser;
    User pickedUser;
    Entity entity;
    //Organization org=new Organization();
    public Menu(Organization org)
    {
        List<Beneficiary> beneficiaryList=org.getBeneficiaryList();
        List<Donator> donatorList=org.getDonatorList();
    while(true){
    exists=false;
    going=true;
    System.out.println("Please enter your phone number: ");
    enteredNumber=keyboard.nextInt();
    if(exists==false){
        menuUser=org.getAdmin();
        if(menuUser.getPhoneNumber()==enteredNumber){type=3;exists=true;}
    }
    if(exists==false){
    for(Donator thisDonator : donatorList){
    if(thisDonator.getPhoneNumber()==enteredNumber){
        menuUser=thisDonator;
        type=1;
        exists=true;
        break;}
        }
    }
    if(exists==false){
    for(Beneficiary thisBeneficiary : beneficiaryList){   
        if(thisBeneficiary.getPhoneNumber()==enteredNumber){
            menuUser=thisBeneficiary;
            type=2;
            exists=true;
            break;}      
        }
    }
    if(exists==false){
    System.out.println("You are not signed up! What type of user do you wanna sign up as?\n1.Donator\n2.Beneficiary");
    type=keyboard.nextInt();
    switch(type){
    case 1: org.insertDonator();
        for(Donator thisDonator : donatorList){
            if(thisDonator.getPhoneNumber()==enteredNumber){
                menuUser=thisDonator;
                type=1;
                break;}
        }
    break;
    case 2: org.insertBeneficiary();
        for(Beneficiary thisBeneficiary : beneficiaryList){   
             if(thisBeneficiary.getPhoneNumber()==enteredNumber){
                menuUser=thisBeneficiary;
                type=2;
                break;}
        }
    break;
    }
    }
    ///////////////////////
    //type: 1=DONATOR 2=BENEFICIARY 3=ADMIN
    //choice=0;
    //choice2=0;
    switch(type){
        case 1: 
        System.out.println("Hello "+ menuUser.getName()+ ", you have successfully logged in " + org.getName()+"'s menu.");
        System.out.println("You are a Donator.\nYour phone number is: "+ menuUser.getPhoneNumber());
        while(going==true){
        System.out.println("1.Add Offer\n2.Show Offers\n3.Commit\n4.Logout\n5.Exit");
        choice=keyboard.nextInt();
        switch(choice){
            case 1:System.out.println("1.Material\n2.Services");
            choice2=keyboard.nextInt();
            switch(choice2){
                case 1:org.listMaterials();
                choice3=keyboard.nextInt();
                entity=org.pickedMaterial(choice3);
                System.out.println(entity.toString());
                System.out.println("Do you wanna offer? (y/n)");
                answer=keyboard.next().charAt(0);
                if(answer=='y'){((Donator)menuUser).addOffer(entity);}
                break;
                case 2:org.listServices();
                choice3=keyboard.nextInt();
                entity=org.pickedService(choice3);
                System.out.println(entity.toString());
                System.out.println("Do you wanna offer? (y/n)");
                answer=keyboard.next().charAt(0);
                if(answer=='y'){((Donator)menuUser).addOffer(entity);}
                break;
            }
        
            break;
            case 2: break;
            case 3: //((Donator)menuUser).commit();
                    break;
            case 4:going=false; break;
            case 5:System.exit(0);
        }
                    }
        break;
        
        
        
        
        case 2:
        System.out.println("Hello "+ menuUser.getName()+ ", you have successfully logged in " + org.getName()+"'s menu.");
        System.out.println("You are a Beneficiary.\nYour phone number is: "+ menuUser.getPhoneNumber());
        while(going==true){
        System.out.println("1.Add Request\n2.Show Requests\n3.Commit\n4.Logout\n5.Exit");
        choice=keyboard.nextInt();
        switch(choice){
            case 1:System.out.println("1.Material\n2.Services");
            choice2=keyboard.nextInt();
            switch(choice2){
                case 1:org.listMaterials();
                choice3=keyboard.nextInt();
                entity=org.pickedMaterial(choice3);
                System.out.println(entity.toString());
                System.out.println("Do you wanna request? (y/n)");
                answer=keyboard.next().charAt(0);
                if(answer=='y'){((Beneficiary)menuUser).addRequest(entity);}
                break;
                case 2:org.listServices();
                choice3=keyboard.nextInt();
                entity=org.pickedService(choice3);
                System.out.println(entity.toString());
                System.out.println("Do you wanna request? (y/n)");
                answer=keyboard.next().charAt(0);
                if(answer=='y'){((Beneficiary)menuUser).addRequest(entity);}
                break;
            }
        
            break;
            case 2: break;
            case 3: //((Beneficiary)menuUser).commit();
                    break;
            case 4:going=false; break;
            case 5:System.exit(0);
                      }
                            }
        break;
        
        
        
        
        case 3:
        System.out.println("Hello "+ menuUser.getName()+ ", you have successfully logged in " + org.getName()+"'s menu.");
        System.out.println("You are a Admin.\nYour phone number is: "+ menuUser.getPhoneNumber());
        while(going==true){
        System.out.println("1.View\n2.Monitor Organization\n3.Logout\n4.Exit");
        choice=keyboard.nextInt();
        switch(choice){
            case 1:System.out.println("1.Material\n2.Services");
            choice2=keyboard.nextInt();
            switch(choice2){
                case 1:org.listMaterials();
                choice3=keyboard.nextInt();
                entity=org.pickedMaterial(choice3);
                System.out.println(entity.toString());
                break;
                case 2:org.listServices();
                choice3=keyboard.nextInt();
                entity=org.pickedService(choice3);
                System.out.println(entity.toString());
                break;
            }
            break;
            case 2:System.out.println("1.List Beneficiaries\n2.List Donators\n3.Reset Beneficiaries Lists");
            choice2=keyboard.nextInt();
            switch(choice2){
                case 1:org.listBeneficiaries();
                System.out.println("1 2 3");
                choice3=keyboard.nextInt();
                pickedUser=org.pickedBeneficiary(choice3);
                //i
                System.out.println("Do you wanna clear this benficiary's received list? (y/n)");
                answer=keyboard.next().charAt(0);
                if(answer=='y')((Beneficiary)pickedUser).reset();
                
                break;
                case 2:org.listDonators();
                break;
                case 3:org.resetAll();
                break;
            }
            break;
            case 3:going=false; break;
            case 4:System.exit(0);
                      }
                            }
        break;
                }
    }
    }
}
