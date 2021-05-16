public class Requests extends RequestDonationList
{
    /*public void add(Beneficiary beneficiary,RequestDonation request)
    {
        if(request.getEntity() instanceof Service) super.add(request);
        else if(request.getEntity() instanceof Material)
        {
            for(RequestDonation thisRD : rdEntities){
                if(get(thisRD) == get(request)){
                  if(thisRD.getQuantity()!=request.getQuantity())
                  { throw new QuantityException(); }
                  else
                  { 
                      if(validRequestDonation(beneficiary, request)==true) super.add(request);
                  }
            }
            }
        }
    }
    public void modify(Beneficiary beneficiary,RequestDonation request, int newQuantity){
       if(request.getEntity() instanceof Service) super.add(request);
        else if(request.getEntity() instanceof Material)
        {
            for(RequestDonation thisRD : rdEntities){
                if(get(thisRD) == get(request)){
                  if(thisRD.getQuantity()!=request.getQuantity())
                  { throw new QuantityException(); }
                  else
                  { 
                      if(validRequestDonation(beneficiary, request)==true) super.add(request);
                  }
            }
            }
        }
    }
    // public void commit(Beneficiary beneficiary){
        for(RequestDonation thisRD : rdEntities){
          if(OQuantityTest(thisRD)==true && validRequestDonation(beneficiary,thisRD)==true){
          //afaireitai apo tin currentDonations
            super.remove(thisRD);
          //add stin receivedList tou beneficiary
          }
        }  
    }   //  
    public boolean validRequestDonation(Beneficiary beneficiary,RequestDonation request){
          Material requestTest = (Material) request.getEntity();
          //το request.entity είναι η υπερκλάση δεν περιλαμβάνει το getLevel
          // για αυτό έκανα cast
          if(beneficiary.getNoPersons() == 1){
           for(RequestDonation thisRE : rdEntities)
           {       
            if(get(thisRE)==get(request)) //χρησιμοποιώ το request τύπου requestdonation
            {
              if(request.getQuantity() + thisRE.getQuantity() >= requestTest.getLevel1()){ throw new ValidityException(); }   
              else { return true; }
            } //να δώσουμε λίγη προσοχή στο loop εδώ
           }
        }
          if(beneficiary.getNoPersons() >= 5){
           for(RequestDonation thisRE : rdEntities)
           {       
            if(get(thisRE)==get(request))
            {
              if(request.getQuantity() + thisRE.getQuantity() >= requestTest.getLevel3()){ throw new ValidityException(); }   
              else { return true; }
            }  //να δώσουμε λίγη προσοχή στο loop εδώ
           }
        }
          else {
           for(RequestDonation thisRE : rdEntities)
           {       
            if(get(thisRE)==get(request))
            {
              if(request.getQuantity() + thisRE.getQuantity() >= requestTest.getLevel2()){ throw new ValidityException(); }   
              else { return true; }
            }  //να δώσουμε λίγη προσοχή στο loop εδώ
           }
        }
    }*/
}
           
           
           
           
           