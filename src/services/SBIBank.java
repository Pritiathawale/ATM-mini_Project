package services;
import exception.InsufficientBalanceException;
import exception.InvalidAmountException;
import services.Bank;
public class SBIBank implements Bank
{
	private double bal;
    private double amt;
    
      public void deposite(double amt)throws InvalidAmountException
      {
     try {
     if(amt<=0){
       throw new InvalidAmountException("Invalid Amount");
     }
     }catch(InvalidAmountException e)
     {
                System.out.println("Invalid amount");
     }
       bal=bal+amt;
       }
       
       // withdraw
      public double withdraw(double amt) throws InvalidAmountException,InsufficientBalanceException
      {
      try
      {
     if(amt<=0)
     {
     
       throw new InvalidAmountException("Invalid Amount");
     }
       else if(amt>bal)
       {
       
               throw new InsufficientBalanceException("Invalid Amount");
       }
      }catch(InvalidAmountException e)
      {
          System.out.println("Invalid amount");
      } catch(InsufficientBalanceException e)
     {
                System.out.println("Insufficient  amount");
     }	
       bal=bal-amt;
       return amt;
       }
}