package bankingapplication3;

import java.util.Random;
import java.util.Scanner;


public class BankingApplication3 {

    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Bank bank = new Bank("Hum");
        int option = 0, accountNumber;
        String accountName, accountType;
        double balance, amount, minimum = 1000;
        Account account = null;
        
        while(option != 6){
            System.out.println("Main Menu");
            System.out.println("1. Display all Accounts");
            System.out.println("2. Open New Account​");
            System.out.println("3. Close Existing Account");
            System.out.println("4. Deposit​ Money");
            System.out.println("5. Withdraw Money");
            System.out.println("");
            
            System.out.print("Enter your choice: ");
            option = scan.nextInt();
            scan.nextLine();
            System.out.println("");
            
            switch(option){
                case 1:
                    bank.listAccount();
                    break;
                case 2:
                    accountNumber = generateAccountNumber();
                    System.out.print("Enter Account Name: ");
                    accountName = scan.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    balance = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Enter Account Type Please (s or c): ");
                    accountType = scan.nextLine();
                    
                    if  (accountType.toLowerCase().equals("s")){
                        account = new SavingsAccount(accountNumber, accountName, balance);
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        account = new CurrentAccount(accountNumber, accountName, balance, minimum);
                    }
                    
                    bank.openAccount(account);
                    break;
                case 3:
                    System.out.print("Enter Your Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Account Type Please (s or c): ");
                    accountType = scan.nextLine();
                    if  (accountType.toLowerCase().equals("s")){
                        account = bank.getAccount(accountNumber, "SavingAccount");
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        account = bank.getAccount(accountNumber, "Currentaccount");
                    }
                    bank.closeAccount(account);
                    System.out.println("Delete Successful :)");
                    break;
                case 4:
                    System.out.print("Enter Your Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Account Type Please (s or c): ");
                    accountType = scan.nextLine();
                    if  (accountType.toLowerCase().equals("s")){
                        accountType = "SavingsAccount";
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        accountType = "CurrentAccount";
                    }
                    account = bank.getAccount(accountNumber, accountType);
                    System.out.print("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.depositMoney(account, amount);
                    break;
                case 5:
                    System.out.print("Enter Your Account Number: ");
                    accountNumber = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter Account Type Please (s or c): ");
                    accountType = scan.nextLine();
                    if  (accountType.toLowerCase().equals("s")){
                        accountType = "SavingsAccount";
                    }
                    else if(accountType.toLowerCase().equals("c")){
                        accountType = "CurrentAccount";
                    }
                    account = bank.getAccount(accountNumber, accountType);
                    System.out.print("Enter Amount: ");
                    amount = scan.nextDouble();
                    bank.withdrawMoney(account, amount);
                    break;
            }
        }
    }
    
    public static int generateAccountNumber(){
        Random random = new Random();
        int accNumber = 100000 + random.nextInt(900000);
                return accNumber;
    }
    
}
