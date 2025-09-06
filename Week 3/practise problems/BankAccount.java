public class BankAccount {
     static String bankName;
     static int totalAccounts;
     static double interestRate;

     String accountNumber;
     String accountHolder;
     double balance;

     BankAccount(String accountNumber,String accountHolder,double balance){
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
        totalAccounts++;
     }
     public static void setBankName(String name){
        bankName=name;
     }
     public static void setInterest(double rate){
        interestRate=rate;
     }
     public static int getTotalAccounts(){
        return totalAccounts;
     }

    public static void displayBankInfo(){
        System.out.println("Bank Name: "+bankName);
        System.out.println("Total Accounts: "+totalAccounts);
    }

    //instance methods
    public void deposit(double amount){
        balance=balance+amount;
    }
    public void withdraw(double amount){
        if(amount<=balance){
            balance-=amount;
        }
        else{
            System.out.println("Insufficient amount");
        }
    }
     
    public void calculateInterest(){
        double interest=balance*interestRate/100;
        System.out.println("Interest amount is "+interest);
    }
    public void displayAccountInfo(){
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Account Holder: "+accountHolder);
        System.out.println("Balance: "+balance);
    }
     public static void main(String[] args) {
        //using static methods to set bankName and interest rate
        BankAccount.setBankName("HIMALAYAN BANK LTD");
        BankAccount.setInterest(1.2);

        //multiple bank accounts
        BankAccount a1=new BankAccount("1080797", "Anjan Shrestha", 100000);
        BankAccount a2=new BankAccount("172397290", "Ross Bahadur", 10);
         
        //static methods are shared to each members
        System.out.println("Bank name of account 1: "+a1.bankName);
         System.out.println("Bank name of account 2: "+a2.bankName);
         a1.deposit(1000);
         a2.withdraw(10);
         a1.calculateInterest();

         //showing that instance members are unique to each others
         a1.displayAccountInfo();
         a2.displayAccountInfo();
         
         //static methods with object
         a1.setBankName("CIVIL BANK LTD");
         
         //static methods without object
         BankAccount.setBankName("HIMALAYAN BANK LTD");


     }

}
