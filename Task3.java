import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class Task3 
{    public static void main(String[] args) {
        AtmOpInterface op=new AtmOperations();
        int atmpin=795;
        Scanner in=new Scanner(System.in);
        System.out.println("\nWelcome to bank account !!!");
        
            while(true){
                System.out.println("\n1.View Available Balance in Account \n2.Withdraw Amount from Account\n3.Deposit Amount in Account\n4.Transaction History\n5.Exit\n6.Transfer\n");
                System.out.print("Enter Choice : ");
                int ch=in.nextInt();
                
                if(ch==1){
                	System.out.print("Enter Pin: ");
                    int pin=in.nextInt();
                	if(atmpin == pin){
                		 System.out.println("Account Authorized!\n");
                		 op.viewBalance();
                	    }
                	else{
                        System.out.println("Incorrect pin");
                        System.exit(0);
                    }
                }
                
                else if(ch == 2){
                	System.out.print("Enter Pin: ");
                    int pin=in.nextInt();
                	if(atmpin == pin){
                	    System.out.println("Account Authorized!\n");
                		System.out.println("Enter the amount to withdraw: ");
                		 	double withdrawAmount=in.nextDouble();
                		 	op.withdrawAmount(withdrawAmount);
                	 }
                	else{
                        System.out.println("Incorrect pin");
                        System.exit(0);
                    }
                }
            
                else if(ch == 6){
                	System.out.print("Enter Pin: ");
                    int pin=in.nextInt();
                	if(atmpin == pin){
                	    System.out.println("Account Authorized!\n");
                		System.out.println("Enter the amount to Transfer ");
                        double TransferAmount=in.nextDouble();
                        op.TransferAmount(TransferAmount);
                	 }
                	else{
                        System.out.println("Incorrect pin");
                        System.exit(0);
                    }
                }
                
                else if(ch == 3){
                	System.out.print("Enter Pin: ");
                    int pin=in.nextInt();
                	if(atmpin==pin){
                		System.out.println("Account Authorized! \n");
                        System.out.println("Enter the Amount to Deposit :");
                        double depositAmount=in.nextDouble();
                        op.depositAmount(depositAmount);
                	}
                	else{
                         System.out.println("Incorrect pin");
                         System.exit(0);
                    }
                }
                
                else if(ch == 4){
                	System.out.print("Enter Pin: ");
                    int pin=in.nextInt();
                	if(atmpin==pin){
                		 System.out.println("Account Authorized! \n");
                		 System .out.println("Transaction History");
                		 System.out.println("************************");
                         op.viewMiniStatement();
                	 }
                }
                
                else if(ch == 5){
                    System.out.println("Collect your Card\n Thank you!!");
                    System.exit(0);
                }
                
                    else
                    {
                        System.out.println("Please enter valid choice");
                    }
            
            }
        }
    }


 interface AtmOpInterface {
    public void viewBalance();
    public void withdrawAmount(double withdrawAmount);
    public void depositAmount(double depositAmount);
    public  void viewMiniStatement();
    public  void TransferAmount(double TransferAmount);


}


 class AtmOperations implements AtmOpInterface{
    ATM atm=new ATM();
    Map<Double,String> ministmt=new HashMap<>();
    
    //Method to View Balance
    @Override
    public void viewBalance() {
    	System.out.println("\nLoading your Accout Balance.......");
        System.out.println("The Balance is : "+atm.getBalance());
        	System.out.println();
    }




    //Method to Withdraw Amount
    @Override
    public void withdrawAmount(double withdrawAmount) {
    	Scanner sc=new Scanner(System.in);
        if(withdrawAmount%100==0) {
            if (withdrawAmount <= atm.getBalance()) {
            	System.out.println("Confirm? if yes click: Y if no then click: N Y/N");
            	String confirm=sc.next();
            	if(confirm.equals("Y")) {
                ministmt.put(withdrawAmount, " Amount Withdrawn");
                System.out.println("Collect the Ammount" + withdrawAmount);
                atm.setBalance(atm.getBalance() - withdrawAmount);
                viewBalance();
            	}
            } else {
                System.out.println("Insufficient Balance !!");
            }
        }
        else {
            System.out.println("Please enter the amount in multipal of 100");
        }

    }

    //Method to ddeposit Amount
    @Override
    public void depositAmount(double depositAmount) {
    	System.out.println("Confirm? if yes click: Y if no then click: N Y/N");
    	Scanner sc=new Scanner(System.in);
    	String confirm=sc.next();
	    if(confirm.equals("Y")) {
        ministmt.put(depositAmount," Amount Deposited");
        System.out.println(depositAmount+" Deposited Successfully !!");
        atm.setBalance(atm.getBalance()+depositAmount);
        viewBalance();
        
	    }
    }

    //Method to View Mini Statement
    @Override
    public void viewMiniStatement() {
        for(Map.Entry<Double,String> m:ministmt.entrySet()){
            System.out.println(m.getKey()+""+m.getValue());
        }
    }
    @Override
    public void TransferAmount(double TransferAmount) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the id to transfer");
        String id=sc.next();
        System.out.println("Confirm? if yes click: Y if no then click: N Y/N");
        String confirm=sc.next();
         if(confirm.equals("Y")) {
        ministmt.put(TransferAmount," Amount Transfer");
        System.out.println(TransferAmount+" Tranfered Successfully !!");
        atm.setBalance(atm.getBalance()-TransferAmount);
        viewBalance();
        
        }
    }
}



class ATM {
    private double balance=10000;
    private double depositAmount;
    private double withdrawAmount;
    private double TransferAmount;

    //default constructor
    public ATM(){
    }

    //getter setter
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(double withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public void setTransferAmount(double TransferAmount){
        this.TransferAmount=TransferAmount;
        //return TransferAmount;
    }
}
