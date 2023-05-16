package bankingapplication3;

public class CurrentAccount implements Account{
    private int accountNumber;
    private String accountName;
    private double balance;
    private double minimum;
    private String accountType = "CurrentAccount";

    public CurrentAccount(int accountNumber, String accountName, double balance, double minimum) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
        this.minimum = minimum;
    }
    

    public int getNumber(){
        return this.accountNumber;
    }
    public String getAccountName(){
        return this.accountName;
    }

    public double getMinimum(){
        return this.minimum;
    }
    public void setMinimum(double minimum){
        this.minimum = minimum;
}

    @Override
    public void deposit(double amount){
        this.balance = this.balance + amount;
    }
    @Override
    public void withdraw(double amount){
        this.balance = this.balance - amount;
    }
    @Override
    public double getBalance(){
        return this.balance;
    }
    @Override
    public String getAccountType(){
        return this.accountType;
    }

}
