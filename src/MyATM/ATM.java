package MyATM;
import services.Bank;
import exception.InvalidAmountException;
import exception.InsufficientBalanceException;
import java.util.Scanner;
public class ATM {

	public static void main(String[] args)throws InvalidAmountException,InsufficientBalanceException
	{
		// TODO Auto-generated method stub
         String bankName,nextOption;
         int option=0;
         double amt=0.0;
         Scanner sc=new Scanner(System.in);
         start:while(true)
         {
        	 System.out.println("Enter ATM CARD(Bank Name)");
        	 bankName="services."+sc.next();
        	 try
        	 {
        		Bank bank=(Bank)Class.forName(bankName).getDeclaredConstructor().newInstance();
        		start1:
        			while(true)
        			{
        	        	 System.out.println("---------------- Choose operation ----------------");
        	        	 System.out.println("\n 1] Deposit");
        	        	 System.out.println("\n 2] Withdraw");
        	        	 System.out.println("\n 3] Exit");
        	        	 
        	        	 System.out.println("Enter Your Choice ");
        	        	 option=sc.nextInt();
        	        	 
        	        	 try
        	        	 {
        	        		 switch(option)
        	        		 {
        	        		 case 1:
        	        			 System.out.println("Enter Amount to Deposit :");
        	        			 amt=sc.nextDouble();
        	        			 bank.deposite(amt);
        	        			 System.out.println("\nYour amount Successfully Deposited");
        	        			 break;
        	        			
        	        		 case 2:
        	        			 System.out.println("Enter Amount to Withdraw :");
        	        			 amt=sc.nextDouble();
        	        			 bank.withdraw(amt);
        	        			 System.out.println("\nYour amount Withdraw Successfully ");
        	        			 break;
        	        			 
        	        		 case 3:
        	        			 break start1;
        	        			 
        	        		default:
        	        			 System.out.println("Invalid Choice");
        	        			 break;
        	        			 
        	        		 }
        	        		 System.out.println("\nDo You Want to Continue (Y/N)");
        	        		 nextOption=sc.next();
    	        			 if(nextOption.equalsIgnoreCase("N"))
    	        			 {
    	        				 System.out.println("Please Exit From ATM");
    	        				 System.out.println("Thank You!!!!");
    	        				 break start;    	        				 
    	        			 }
        	        	 }catch(InvalidAmountException e)
        	        	 {
        	        		 System.out.println(e.getMessage());
        	        	 }	catch(InsufficientBalanceException e)
        	        	 {
        	        		 System.out.println(e.getMessage());
        	        	 } catch(Exception e)
        	        	 {
        	        		 System.out.println(e.getMessage());
        	        	 }  
        	        	 
        		 }
        	 }catch(ClassNotFoundException e)
        	 {
        		 System.out.println(e.getMessage());
        	 } catch(Exception e)
        	 {
        		 System.out.println(e.getMessage());
        	 }
         }
        sc.close();	  
	}

}